package com.notasfiscais.application;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.notasfiscais.adapters.Integration.ClienteNotaFiscalClient;
import com.notasfiscais.adapters.Integration.GovNfeClient;
import com.notasfiscais.core.domain.cliente.ClienteDto;
import com.notasfiscais.core.domain.notafiscal.*;
import com.notasfiscais.core.domain.notafiscal.data.NotaFiscalDtoDataIntegrationFactory;
import com.notasfiscais.core.domain.notafiscal.data.NotaFiscalRepository;
import com.notasfiscais.core.domain.notafiscal.dto.NotaFiscalDto;
import com.notasfiscais.core.exception.EntidadeExisteException;
import com.notasfiscais.core.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class NotaFiscalService {
    @Value("${topicos.notafiscal.request.topic}")
    private String topicoNotaFiscalRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private ClienteNotaFiscalClient clienteNotaFiscalClient;

    @Autowired
    private GovNfeClient govNfeClient;

    @Autowired
    private NotaFiscalMapper notaFiscalMapper;
    private static final String TIPO_BOLETO = TipoPagamento.BOLETO_BANCARIO.getDescricao();

    private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e";


    public void enviarMensagem(NotaFiscalDto notaFiscalDto) {

        try {
            kafkaTemplate.send(topicoNotaFiscalRequest, objectMapper.writeValueAsString(notaFiscalDto));
        } catch (Exception e) {
           log.error(String.format("[INTEGRAÇÃO COM O KAFKA] Error: %s", e.getMessage()));
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void tratarXml(NotaFiscalIntegration notaFiscal) {

        String chaveNFe = notaFiscal.getProtNFe().getInfProt().getChNFe();

        this.verificarNotaFiscal(chaveNFe);

        NotaFiscalDto notaFiscalDto = NotaFiscalDtoDataIntegrationFactory.of(notaFiscal);
        String cpf = notaFiscal.getNFe().getInfNFe().getDest().getCpf();
        ClienteDto clienteDtoResponse = clienteNotaFiscalClient.clienteBusca(cpf);

        if (Objects.isNull(clienteDtoResponse)) {
            throw new EntidadeNaoEncontradaException("Cliente ainda não cadastrado");
        }

        boolean existsByNfe = notaFiscalRepository.existsByIdNfe(notaFiscalDto.getIdNfe());

        if (existsByNfe){
            throw  new EntidadeExisteException(notaFiscalDto.getIdNfe(), "Nota fiscal já existe na base");
        }

        String tipoPagamento = notaFiscalDto.getTipoPagamento();


        if (Objects.equals(tipoPagamento, TIPO_BOLETO)) {
            this.enviarMensagem(notaFiscalDto);
        }

        notaFiscalRepository.save(notaFiscalMapper.toDomain(notaFiscalDto));

    }

    private void verificarNotaFiscal(String chaveNFe) {
            govNfeClient.verificarNfe(chaveNFe, TOKEN);
    }

}

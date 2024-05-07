package com.notasfiscais.application;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notasfiscais.adapters.Integration.ClienteNotaFiscalClient;
import com.notasfiscais.core.domain.cliente.ClienteDto;
import com.notasfiscais.core.domain.notafiscal.*;
import com.notasfiscais.core.domain.notafiscal.data.NotaFiscalDtoDataIntegrationFactory;
import com.notasfiscais.core.domain.notafiscal.data.NotaFiscalRepository;
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

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    private NotaFiscalMapper notaFiscalMapper;
    private static final int TIPO_BOLETO = TipoPagamento.BOLETO_BANCARIO.getCodigo();


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

        TipoPagamento formaPagamento = TipoPagamento.fromCodigo(parseInt(notaFiscalDto.getTipoPagamento()));

        if (formaPagamento.getCodigo() == TIPO_BOLETO) {
            this.enviarMensagem(notaFiscalDto);
        }

        notaFiscalRepository.save(notaFiscalMapper.toDomain(notaFiscalDto));

    }

    private void verificarNotaFiscal(String chaveNFe) {
        System.out.println(chaveNFe);
    }

}

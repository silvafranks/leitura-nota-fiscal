package com.notasfiscais.application;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notasfiscais.adapters.Integration.ClienteNotaFiscalClient;
import com.notasfiscais.core.domain.cliente.ClienteDto;
import com.notasfiscais.core.domain.notafiscal.*;
import com.notasfiscais.core.domain.notafiscal.data.NotaFiscalRepository;
import com.notasfiscais.core.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

@Service
@AllArgsConstructor
@NoArgsConstructor
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
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void tratarXml(NotaFiscalIntegration notaFiscal) {

        String chaveNFe = notaFiscal.getProtNFe().getInfProt().getChNFe();

        this.verificarNotaFiscal(chaveNFe);

        String idNfe = notaFiscal.getNFe().getInfNFe().getIdNfe();
        String valorPagamento = notaFiscal.getNFe().getInfNFe().getPag().getDetPag().getValorPagamento();
        String codigoFormaPagamento = notaFiscal.getNFe().getInfNFe().getPag().getDetPag().getFormaPagamento();
        String informacoesComplementares = notaFiscal.getNFe().getInfNFe().getInfAdic().getInformacoesComplementares();
        String cpf = notaFiscal.getNFe().getInfNFe().getDest().getCpf();
        TipoPagamento formaPagamento = TipoPagamento.fromCodigo(parseInt(codigoFormaPagamento));

        NotaFiscalDto build = NotaFiscalDto.builder()
                .idNfe(idNfe)
                .valor(valorPagamento)
                .tipoPagamento(valueOf(formaPagamento))
                .descricao(informacoesComplementares)
                .build();
        ClienteDto clienteDtoResponse = clienteNotaFiscalClient.clienteBusca(cpf);

        if (Objects.isNull(clienteDtoResponse)) {
            throw new EntidadeNaoEncontradaException("Cliente ainda não cadastrado");
        }

        if (formaPagamento.getCodigo() == TIPO_BOLETO) {
            this.enviarMensagem(build);
        }

        notaFiscalRepository.save(notaFiscalMapper.toDomain(build));

    }

    private void verificarNotaFiscal(String chaveNFe) {
        System.out.println(chaveNFe);
    }

}

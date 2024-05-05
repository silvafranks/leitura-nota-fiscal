package com.notasfiscais.application;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notasfiscais.core.domain.notafiscal.NotaFiscal;
import com.notasfiscais.core.domain.notafiscal.NotaFiscalDto;
import com.notasfiscais.core.domain.notafiscal.TipoPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    @Value("${topicos.notafiscal.request.topic}")
    private String topicoNotaFiscalRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void enviarMensagem(NotaFiscalDto notaFiscalDto) {

        try {
            kafkaTemplate.send(topicoNotaFiscalRequest, objectMapper.writeValueAsString(notaFiscalDto));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void tratarXml (NotaFiscal notaFiscal) {

        String chaveNFe = notaFiscal.getProtNFe().getInfProt().getChNFe();

        this.verificarNotaFiscal(chaveNFe);

        String valorPagamento = notaFiscal.getNFe().getInfNFe().getPag().getDetPag().getValorPagamento();
        String codigoFormaPagamento = notaFiscal.getNFe().getInfNFe().getPag().getDetPag().getFormaPagamento();
        String informacoesComplementares = notaFiscal.getNFe().getInfNFe().getInfAdic().getInformacoesComplementares();

        TipoPagamento formaPagamento = TipoPagamento.fromCodigo(parseInt(codigoFormaPagamento));

        NotaFiscalDto build = NotaFiscalDto.builder()
                .valor(valorPagamento)
                .tipoPagamento(valueOf(formaPagamento))
                .descricao(informacoesComplementares)
                .build();

        this.enviarMensagem(build);

    }

    private void verificarNotaFiscal(String chaveNFe) {
        System.out.println(chaveNFe);
    }


}

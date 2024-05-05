package com.notasfiscais.application;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notasfiscais.core.domain.notafiscal.NotaFiscal;
import com.notasfiscais.core.domain.notafiscal.PagamentoDto;
import com.notasfiscais.core.domain.notafiscal.TipoPagamento;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.Integer.parseInt;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    @Value("${topicos.notafiscal.request.topic}")
    private String topicoPagamentoRequest;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void enviarMensagem(PagamentoDto pagamento) {
        String conteudo = null;
        try {
            conteudo = objectMapper.writeValueAsString(pagamento);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        kafkaTemplate.send(topicoPagamentoRequest, conteudo);
    }

    public void tratarXml (NotaFiscal notaFiscal) {

        String valorPagamento = notaFiscal.getNFe().getInfNFe().getPag().getDetPag().getValorPagamento();
        String codigoFormaPagamento = notaFiscal.getNFe().getInfNFe().getPag().getDetPag().getFormaPagamento();
        String informacoesComplementares = notaFiscal.getNFe().getInfNFe().getInfAdic().getInformacoesComplementares();

        TipoPagamento formaPagamento = TipoPagamento.fromCodigo(parseInt(codigoFormaPagamento));

        PagamentoDto build = PagamentoDto.builder()
                .valor(valorPagamento)
                .numero(String.valueOf(formaPagamento))
                .descricao(informacoesComplementares)
                .build();

            this.enviarMensagem(build);

    }


}

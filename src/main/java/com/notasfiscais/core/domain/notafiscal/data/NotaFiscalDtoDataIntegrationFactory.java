package com.notasfiscais.core.domain.notafiscal.data;

import com.notasfiscais.core.domain.notafiscal.dto.NotaFiscalDto;
import com.notasfiscais.core.domain.notafiscal.NotaFiscalIntegration;
import com.notasfiscais.core.domain.notafiscal.TipoPagamento;

import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class NotaFiscalDtoDataIntegrationFactory {
    public static NotaFiscalDto of (NotaFiscalIntegration notaFiscal) {

        String codigoFormaPagamento = notaFiscal.getNFe().getInfNFe().getPag().getDetPag().getFormaPagamento();

        return  NotaFiscalDto.builder()
                .idNfe(notaFiscal.getNFe().getInfNFe().getIdNfe())
                .valor(notaFiscal.getNFe().getInfNFe().getPag().getDetPag().getValorPagamento())
                .tipoPagamento(valueOf(TipoPagamento.fromCodigo(parseInt(codigoFormaPagamento))))
                .descricao(notaFiscal.getNFe().getInfNFe().getInfAdic().getInformacoesComplementares())
                .build();
    }
}

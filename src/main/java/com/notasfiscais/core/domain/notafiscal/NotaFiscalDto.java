package com.notasfiscais.core.domain.notafiscal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotaFiscalDto {
    private String idNfe;
    private String tipoPagamento;
    private String descricao;
    private String valor;
}

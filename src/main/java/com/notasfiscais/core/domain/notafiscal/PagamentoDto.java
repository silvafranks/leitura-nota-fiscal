package com.notasfiscais.core.domain.notafiscal;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PagamentoDto {
    private String numero;
    private String descricao;
    private String valor;

}

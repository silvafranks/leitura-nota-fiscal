package com.notasfiscais.core.domain.notafiscal;

public enum TipoPagamento {
    DINHEIRO(1, "Dinheiro"),
    CHEQUE(2, "Cheque"),
    CARTAO_CREDITO(3, "Cartão de Crédito"),
    CARTAO_DEBITO(4, "Cartão de Débito"),
    CREDITO_LOJA(5, "Crédito Loja"),
    VALE_ALIMENTACAO(10, "Vale Alimentação"),
    VALE_REFEICAO(11, "Vale Refeição"),
    VALE_PRESENTE(12, "Vale Presente"),
    VALE_COMBUSTIVEL(13, "Vale Combustível"),
    DUPLICATA_MERCANTIL(14, "Duplicata Mercantil"),
    BOLETO_BANCARIO(15, "Boleto Bancário"),
    SEM_PAGAMENTO(90, "Sem Pagamento"),
    OUTROS(99, "Outros");

    private final int codigo;
    private final String descricao;

    TipoPagamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

    public static TipoPagamento fromCodigo(int codigo) {
        for (TipoPagamento tipo : TipoPagamento.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código de pagamento inválido: " + codigo);
    }

}

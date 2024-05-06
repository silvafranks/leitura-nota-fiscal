package com.notasfiscais.core.domain.notafiscal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String idNfe;

    @Column(nullable = false)
    private String tipoPagamento;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String valor;
}

package com.notasfiscais.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static javax.swing.UIManager.put;

@Getter
@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntidadeExisteException extends RuntimeException {
    private static final long serialVersionUID = 2836862867796018869L;

    private final String mensagem;
    private final String entidade;

    public EntidadeExisteException(final String entidade, final String mensagem) {
        super(String.format( "%s Entidade já existe. - %s", entidade, mensagem));
        this.mensagem = Objects.requireNonNull(mensagem);
        this.entidade = Objects.requireNonNull(entidade);
    }
}

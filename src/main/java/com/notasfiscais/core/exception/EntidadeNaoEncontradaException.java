package com.notasfiscais.core.exception;

import org.apache.kafka.common.security.oauthbearer.internals.secured.ValidateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends RuntimeException {
    private static final long serialVersionUID = 4928599035264976611L;

    public EntidadeNaoEncontradaException(String msg){
        super(msg);
    }

}

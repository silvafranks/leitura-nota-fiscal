package com.notasfiscais.core.handler;

import com.notasfiscais.core.exception.EntidadeNaoEncontradaException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class EntidadeNaoEncontradaExceptionHandler  {
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Object> handleEntityNotFoundDomainException(final EntidadeNaoEncontradaException exception,
                                                                      final HttpServletRequest httpServeletRequest) {
        final Map<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", new Date().getTime());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", HttpStatus.NOT_FOUND.name());
        body.put("message", exception.getMessage());
        body.put("path", httpServeletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

}

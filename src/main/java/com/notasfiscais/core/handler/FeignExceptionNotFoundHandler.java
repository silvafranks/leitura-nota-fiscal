package com.notasfiscais.core.handler;

import feign.FeignException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class FeignExceptionNotFoundHandler {

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ResponseBody
    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Object> handleFeignNotFoundException(final FeignException.NotFound exception) {
        final Map<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", new Date().getTime());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", HttpStatus.NOT_FOUND.name());
        body.put("message", "Nota fiscal Inválida");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

}

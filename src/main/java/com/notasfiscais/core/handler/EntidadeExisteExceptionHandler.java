package com.notasfiscais.core.handler;

import com.notasfiscais.core.exception.EntidadeExisteException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EntidadeExisteExceptionHandler {
    @ExceptionHandler(EntidadeExisteException.class)
    public ResponseEntity<Object> handleEntityExistsDomainException(
            final EntidadeExisteException exception,
            final HttpServletRequest httpServeletRequest
    ) {
        final Map<String, Object> body = new HashMap<String, Object>();
        body.put("timestamp", new Date().getTime());
        body.put("status", HttpStatus.CONFLICT.value());
        body.put("error", HttpStatus.CONFLICT.name());
        body.put("message", exception.getMessage());
        body.put("path", httpServeletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }
}

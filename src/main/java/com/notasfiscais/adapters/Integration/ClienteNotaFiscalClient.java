package com.notasfiscais.adapters.Integration;

import com.notasfiscais.core.domain.cliente.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "localhost:8081/cliente", name= "clientesNotaFiscal")
public interface ClienteNotaFiscalClient {

    @GetMapping(value = "/usuario/{cpf}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClienteDto clienteBusca(@PathVariable String cpf);

}

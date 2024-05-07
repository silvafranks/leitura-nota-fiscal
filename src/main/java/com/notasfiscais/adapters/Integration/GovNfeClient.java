package com.notasfiscais.adapters.Integration;

import com.notasfiscais.core.domain.notafiscal.NotaFiscalIntegration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "gov", url = "https://gateway.apiserpro.serpro.gov.br/consulta-nfe-df-trial/api")
public interface GovNfeClient {

    @GetMapping(value = "/v1/nfe/{chave}",  produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    NotaFiscalIntegration verificarNfe(@PathVariable String chave, @RequestHeader("Authorization") String authorization);
}

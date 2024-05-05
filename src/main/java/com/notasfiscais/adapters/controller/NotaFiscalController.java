package com.notasfiscais.adapters.controller;

import com.notasfiscais.application.NotaFiscalService;
import com.notasfiscais.core.domain.notafiscal.NotaFiscal;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/nota-fiscal")
@AllArgsConstructor
@Controller
public class NotaFiscalController {

    private NotaFiscalService service;

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void receberNotaFiscal(@RequestBody NotaFiscal xml) {
        service.tratarXml(xml);
    }
}

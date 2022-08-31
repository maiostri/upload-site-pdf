package com.example.uploadsitepdf.controller;

import com.example.uploadsitepdf.domain.ConverterRequest;
import com.example.uploadsitepdf.service.SiteConverterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/convert-site-to-pdf")
@AllArgsConstructor
public class SiteConverterController {

    private final SiteConverterService siteConverterService;

    @PostMapping
    public ResponseEntity<String> converteSite(@RequestBody ConverterRequest converterRequest) throws IOException {
        String resposta = siteConverterService.convertSite(converterRequest);
        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }
}

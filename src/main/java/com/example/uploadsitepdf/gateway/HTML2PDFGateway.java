package com.example.uploadsitepdf.gateway;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class HTML2PDFGateway {

    private final String apiKey = "N6KBewm2tVRq1XnSD2UlARioV6GDuE6WAMhWIHerGUUNVIEo0Tio4d7aR8UpufVq";

    private RestTemplateBuilder restTemplateBuilder;

    public byte[] convertToPDF(String site) {
        ResponseEntity<byte[]> response = restTemplateBuilder.build()
                .getForEntity(
                        String.format("https://api.html2pdf.app/v1/generate?url=%s&apiKey=%s",
                                site, apiKey), byte[].class);
        return response.getBody();
    }
}

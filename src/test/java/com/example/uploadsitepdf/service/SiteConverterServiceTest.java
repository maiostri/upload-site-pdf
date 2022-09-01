package com.example.uploadsitepdf.service;

import com.example.uploadsitepdf.domain.ConverterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class SiteConverterServiceTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SiteConverterService siteConverterService;

    private MockRestServiceServer mockServer;

    @BeforeEach
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testConvertSite() throws URISyntaxException, IOException {
        ConverterRequest converterRequest = new ConverterRequest();
        converterRequest.setSite("http://example.com");
        converterRequest.setDono("Ricardo");
        converterRequest.setNomeArquivo("nome_do_arquivo_do_teste");


        // 1. Passo 1: Configuro os mocks

        // primeira app
        mockServer.expect(
                ExpectedCount.once(), // Esperamos que o método que vamos configurar seja
                // chamado uma vez apenas.

                // Vamos falar para qual URL queremos que o comportamento seja
                // modificado
                MockRestRequestMatchers.requestTo(
                        new URI("https://api.html2pdf.app/v1/generate?url=http://example.com&apiKey=N6KBewm2tVRq1XnSD2UlARioV6GDuE6WAMhWIHerGUUNVIEo0Tio4d7aR8UpufVq")))
                // Verificamos qual método é esperado
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                // Configuramos a resposta, com status e body

                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK)
                        .body(new byte[]{1}));


        // Passo 2: Executo o que eu preciso
        siteConverterService.convertSite(converterRequest);

        // Passo 3: Faço as verificações
        mockServer.verify();
    }

}

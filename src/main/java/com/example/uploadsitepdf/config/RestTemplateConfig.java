package com.example.uploadsitepdf.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@AllArgsConstructor
public class RestTemplateConfig {

    private RestTemplateBuilder restTemplateBuilder;

    // Esse é o lugar que sabe como
    // criar um restTemplate!
    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder.build();
    }
}

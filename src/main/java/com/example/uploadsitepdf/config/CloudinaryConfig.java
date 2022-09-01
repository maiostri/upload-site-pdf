package com.example.uploadsitepdf.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CloudinaryConfig {

    @Bean // Disponibiliza o retorno como algo a ser injetado em qualquer
    // outra classe
    public Cloudinary criaClientCloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "deog9fqlo",
                "api_key", "555877817628424",
                "api_secret", "xURLdYoxvGoZ8egOR1nArI3iN3w"));
    }
}

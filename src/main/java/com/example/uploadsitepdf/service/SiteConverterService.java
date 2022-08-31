package com.example.uploadsitepdf.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.uploadsitepdf.domain.ConverterRequest;
import com.example.uploadsitepdf.gateway.HTML2PDFGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class SiteConverterService {
    private HTML2PDFGateway html2PDFGateway;

    private Cloudinary cloudinary;

    public String convertSite(ConverterRequest request) throws IOException {
        // 1. Converter o arquivo!
        byte[] arquivoEmBytes = html2PDFGateway.convertToPDF(request.getSite());

        // 2. Enviar o arquivo para o cloudinary
        Map response = cloudinary.uploader().upload(arquivoEmBytes,
                ObjectUtils.asMap("public_id", request.getNomeArquivo()));

        return (String) response.get("secure_url");
    }

}

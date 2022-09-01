package com.example.uploadsitepdf.uploader;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
// 3 principais perfis de execução
// 1 - Desenvolvimento(na propria maquina)
// 2 - Roda a aplicação nos testes
// 3 - Produção
@Profile("test")
public class FakeUploader implements UploaderInterface {

    @Override
    public Map uploadArquivo(byte[] arquivo, String nome) throws IOException {
        return Map.of("secure_url", "fake");
    }
}

package com.example.uploadsitepdf.uploader;

import java.io.IOException;
import java.util.Map;

public interface UploaderInterface {

    Map uploadArquivo(byte[] arquivo, String nome) throws IOException;
}

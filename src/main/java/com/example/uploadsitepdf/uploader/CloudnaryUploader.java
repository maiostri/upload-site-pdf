package com.example.uploadsitepdf.uploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@AllArgsConstructor
@Profile("dev")
public class CloudnaryUploader implements UploaderInterface {

    private Cloudinary cloudinary;

    @Override
    public Map uploadArquivo(byte[] arquivo, String nome) throws IOException {
        return cloudinary.uploader().upload(arquivo,
                ObjectUtils.asMap("public_id", nome));
    }
}

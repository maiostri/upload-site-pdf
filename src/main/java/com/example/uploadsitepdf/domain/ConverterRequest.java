package com.example.uploadsitepdf.domain;


import lombok.Data;

import java.util.Date;

@Data
public class ConverterRequest {
    private String site;
    private String nomeArquivo;
    private String dono; // Nome do usuario que está pedindo isso
    private String comentario;
    private Date horario;
}

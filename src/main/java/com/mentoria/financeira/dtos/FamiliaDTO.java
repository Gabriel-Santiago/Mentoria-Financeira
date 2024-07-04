package com.mentoria.financeira.dtos;

import com.mentoria.financeira.enums.Ocupacao;
import com.mentoria.financeira.model.Cliente;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record FamiliaDTO(
        String nome,
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date dataNascimento,
        Long renda,
        Ocupacao ocupacao
) {
}

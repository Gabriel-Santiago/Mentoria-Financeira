package com.mentoria.financeira.dtos;

import com.mentoria.financeira.enums.Ocupacao;

import java.time.LocalDate;

public record ConjugeDTO(
        String nome,
        LocalDate dataNascimento,
        Long renda,
        Ocupacao ocupacao
) {
}

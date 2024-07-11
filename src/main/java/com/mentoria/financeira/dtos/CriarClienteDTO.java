package com.mentoria.financeira.dtos;

import com.mentoria.financeira.enums.EstadoCivil;
import com.mentoria.financeira.enums.Ocupacao;

import java.time.LocalDate;

public record CriarClienteDTO(
        Long id,
        String nome,
        String telefone,
        String email,
        Long renda,
        LocalDate dataNascimento,
        String cep,
        String bairro,
        String logradouro, // rua
        String localidade, // cidade
        String uf, // sigla estado
        Ocupacao ocupacao,
        EstadoCivil estadoCivil
) {
}

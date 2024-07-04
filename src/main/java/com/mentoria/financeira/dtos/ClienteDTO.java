package com.mentoria.financeira.dtos;

import com.mentoria.financeira.enums.EstadoCivil;
import com.mentoria.financeira.enums.Ocupacao;
import com.mentoria.financeira.model.Familia;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public record ClienteDTO(
        Long id,
        String telefone,
        String email,
        Long renda,
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date dataNascimento,
        String cep,
        String bairro,
        String logradouro, // rua
        String localidade, // cidade
        String uf, // sigla estado
        Ocupacao ocupacao,
        EstadoCivil estadoCivil,
        Familia conjuge,
        List<Familia> filhos
) {
}

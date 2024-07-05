package com.mentoria.financeira.viaCep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade; // Cidade
    private String uf; // estado
}

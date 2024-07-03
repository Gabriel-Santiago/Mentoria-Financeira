package com.mentoria.financeira.model;

import com.mentoria.financeira.enums.EstadoCivil;
import com.mentoria.financeira.enums.Ocupacao;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Table(name = "clientes")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String telefone;
    private String email;
    private Long renda;
    private LocalDate dataNascimento;
    private String cep;
    private String bairro;
    private String logradouro; // rua
    private String localidade; // cidade
    private String uf; // sigla estado

    @Enumerated(EnumType.STRING)
    private Ocupacao ocupacao;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @OneToOne
    private Familia conjuge;

    @OneToMany
    private List<Familia> filhos;
}

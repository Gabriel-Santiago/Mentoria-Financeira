package com.mentoria.financeira.model;

import com.mentoria.financeira.enums.Ocupacao;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "familia")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private Long renda;

    @Enumerated(EnumType.STRING)
    private Ocupacao ocupacao;

    @OneToOne
    private Cliente conjuge;
    @ManyToOne
    private Cliente filhos;
}

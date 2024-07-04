package com.mentoria.financeira.model;

import com.mentoria.financeira.enums.Ocupacao;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Table(name = "familia")
@Entity(name = "familia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataNascimento;
    private Long renda;

    @Enumerated(EnumType.STRING)
    private Ocupacao ocupacao;

    @OneToOne(fetch = FetchType.LAZY)
    private Cliente conjuge;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente filhos;
}

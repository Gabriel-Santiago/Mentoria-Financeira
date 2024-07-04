package com.mentoria.financeira.model;

import com.mentoria.financeira.enums.EstadoCivil;
import com.mentoria.financeira.enums.Ocupacao;
import jakarta.persistence.CascadeType;
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
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Table(name = "clientes")
@Entity(name = "clientes")
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
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataNascimento;
    private String cep;
    private String bairro;
    private String logradouro; // rua
    private String localidade; // cidade
    private String uf; // sigla estado

    @Enumerated(EnumType.STRING)
    private Ocupacao ocupacao;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @OneToOne(mappedBy = "clientes", cascade = CascadeType.ALL, orphanRemoval = true)
    private Familia conjuge;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Familia> filhos;
}

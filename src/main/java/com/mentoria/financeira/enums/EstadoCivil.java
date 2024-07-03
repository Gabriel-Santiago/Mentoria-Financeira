package com.mentoria.financeira.enums;

import lombok.Getter;

@Getter
public enum EstadoCivil {
    SOLTEIRO("Solteiro"),
    CASADO("Casado"),
    DIVORCIADO("Divorciado"),
    VIUVO("Viúvo"),
    SEPARADO("Separado"),
    UNIAO_ESTAVEL("União Estável");

    private final String estadoCivil;

    EstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}

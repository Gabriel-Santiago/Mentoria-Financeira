package com.mentoria.financeira.enums;

import lombok.Getter;

@Getter
public enum Ocupacao {
    ADMINISTRADOR("Administrador"),
    ADVOGADO("Advogado"),
    AGRICULTOR("Agricultor"),
    ANALISTA_DE_SISTEMAS("Analista de Sistemas"),
    ARQUITETO("Arquiteto"),
    ASSISTENTE_ADMINISTRATIVO("Assistente Administrativo"),
    ATOR("Ator"),
    AUXILIAR_ADMINISTRATIVO("Auxiliar Administrativo"),
    BABA("Babá"),
    BALCONISTA("Balconista"),
    BARBEIRO("Barbeiro"),
    BIBLIOTECARIO("Bibliotecário"),
    BIOMEDICO("Biomédico"),
    BOLSISTA("Bolsista"),
    BOMBEIRO("Bombeiro"),
    CABELEIREIRO("Cabeleireiro"),
    CAMINHONEIRO("Caminhoneiro"),
    CARPINTEIRO("Carpinteiro"),
    CIENTISTA("Cientista"),
    CIENTISTA_DA_COMPUTACAO("Cientista da Computação"),
    CIRURGIAO_DENTISTA("Cirurgião Dentista"),
    CIRURGIAO_PLASTICO("Cirurgião Plástico"),
    COMERCIANTE("Comerciante"),
    CONTADOR("Contador"),
    COORDENADOR("Coordenador"),
    CORRETOR_DE_IMOVEIS("Corretor de Imóveis"),
    COZINHEIRO("Cozinheiro"),
    DENTISTA("Dentista"),
    DESENHISTA("Desenhista"),
    DESENVOLVEDOR_DE_SOFTWARE("Desenvolvedor de Software"),
    DIRETOR("Diretor"),
    DOCENTE("Docente"),
    ECONOMISTA("Economista"),
    EDITOR("Editor"),
    ELETRICISTA("Eletricista"),
    ENCANADOR("Encanador"),
    ENFERMEIRO("Enfermeiro"),
    ENGENHEIRO("Engenheiro"),
    ENGENHEIRO_CIVIL("Engenheiro Civil"),
    ENGENHEIRO_DE_PRODUCAO("Engenheiro de Produção"),
    ENGENHEIRO_ELETRICISTA("Engenheiro Eletricista"),
    ENGENHEIRO_MECANICO("Engenheiro Mecânico"),
    ENGENHEIRO_QUIMICO("Engenheiro Químico"),
    ENTREGADOR("Entregador"),
    ESTAGIARIO("Estagiário"),
    ESTETICISTA("Esteticista"),
    FARMACEUTICO("Farmacêutico"),
    FAXINEIRO("Faxineiro"),
    FISIOTERAPEUTA("Fisioterapeuta"),
    FOTOGRAFO("Fotógrafo"),
    FRENTISTA("Frentista"),
    GARCOM("Garçom"),
    GERENTE("Gerente"),
    GESTOR("Gestor"),
    INSPETOR("Inspetor"),
    JARDINEIRO("Jardineiro"),
    JORNALISTA("Jornalista"),
    LAVADOR_DE_CARROS("Lavador de Carros"),
    LAVRADOR("Lavrador"),
    LIXEIRO("Lixeiro"),
    MAGISTRADO("Magistrado"),
    MAQUINISTA("Maquinista"),
    MARCENEIRO("Marceneiro"),
    MECANICO("Mecânico"),
    MEDICO("Médico"),
    MICROBIOLOGO("Microbiólogo"),
    MOTORISTA("Motorista"),
    NUTRICIONISTA("Nutricionista"),
    OPERADOR_DE_MAQUINAS("Operador de Máquinas"),
    PADEIRO("Padeiro"),
    PAISAGISTA("Paisagista"),
    PALEONTOLOGO("Paleontólogo"),
    PEDAGOGO("Pedagogo"),
    PEDREIRO("Pedreiro"),
    PERITO("Perito"),
    PERSONAL_TRAINER("Personal Trainer"),
    PINTOR("Pintor"),
    POLICIAL("Policial"),
    POLICIAL_CIVIL("Policial Civil"),
    POLICIAL_MILITAR("Policial Militar"),
    PROFESSOR("Professor"),
    PROFESSOR_DE_EDUCACAO_FISICA("Professor de Educação Física"),
    PROFESSOR_DE_INGLES("Professor de Inglês"),
    PSICOLOGO("Psicólogo"),
    QUIMICO("Químico"),
    RECEPCIONISTA("Recepcionista"),
    REDATOR("Redator"),
    REPRESENTANTE_COMERCIAL("Representante Comercial"),
    SECRETARIO("Secretário"),
    SEGURANCA("Segurança"),
    SOLDADOR("Soldador"),
    SUPERVISOR("Supervisor"),
    TECNICO_DE_ENFERMAGEM("Técnico de Enfermagem"),
    TECNICO_DE_INFORMATICA("Técnico de Informática"),
    TECNICO_ELETRICISTA("Técnico Eletricista"),
    TECNICO_EM_ELETRONICA("Técnico em Eletrônica"),
    TECNICO_EM_MECANICA("Técnico em Mecânica"),
    TELEMARKETING("Telemarketing"),
    TERAPEUTA_OCUPACIONAL("Terapeuta Ocupacional"),
    TRADUTOR("Tradutor"),
    UBER("Uber"),
    VENDEDOR("Vendedor"),
    VETERINARIO("Veterinário"),
    ZOOTECNISTA("Zootecnista");

    private final String ocupacao;

    Ocupacao(String ocupacao){
        this.ocupacao = ocupacao;
    }
}
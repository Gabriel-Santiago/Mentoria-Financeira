package com.mentoria.financeira.services;

import com.mentoria.financeira.dtos.FamiliaDTO;
import com.mentoria.financeira.model.Familia;
import com.mentoria.financeira.repositorys.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliaService {

    private final FamiliaRepository familiaRepository;

    @Autowired
    public FamiliaService(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    private static boolean naoEhNulo(Object... parameters){
        for(Object parameter : parameters){
            if(parameter == null){
                return false;
            }
        }
        return true;
    }

    public void criarFamilia(FamiliaDTO dto){
        if(naoEhNulo(dto.nome(), dto.renda(), dto.ocupacao(), dto.dataNascimento())){
            throw new IllegalArgumentException("Não pode criar o usuário: Um ou mais espaços estão nulos.");
        }

        Familia familia = new Familia(dto.nome(), dto.dataNascimento(),
                dto.renda(), dto.ocupacao());

        familiaRepository.save(familia);
    }
}

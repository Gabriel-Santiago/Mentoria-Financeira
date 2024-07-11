package com.mentoria.financeira.services;

import com.mentoria.financeira.dtos.ConjugeDTO;
import com.mentoria.financeira.dtos.CriarConjugeDTO;
import com.mentoria.financeira.enums.EstadoCivil;
import com.mentoria.financeira.model.Cliente;
import com.mentoria.financeira.model.Conjuge;
import com.mentoria.financeira.repositorys.ClienteRepository;
import com.mentoria.financeira.repositorys.ConjugeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConjugeService {

    private final ConjugeRepository repository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public ConjugeService(ConjugeRepository repository, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    private static boolean naoEhNulo(Object... parameters){
        for(Object parameter : parameters){
            if(parameter == null){
                return false;
            }
        }
        return true;
    }

    private Conjuge getConjuge(CriarConjugeDTO dto, Cliente cliente) {
        Conjuge conjuge = new Conjuge();
        conjuge.setNome(dto.nome());
        conjuge.setDataNascimento(dto.dataNascimento());
        conjuge.setRenda(dto.renda());
        conjuge.setOcupacao(dto.ocupacao());
        conjuge.setCliente(cliente);

        if(!naoEhNulo(conjuge.getNome(), conjuge.getDataNascimento(), conjuge.getRenda(), conjuge.getOcupacao())){
            throw new IllegalArgumentException("Não pode criar o conjuge: Um ou mais espaços estão nulos.");
        }
        return conjuge;
    }

    @Transactional
    public void criarConjuge(Long cliente_id, CriarConjugeDTO dto){
        Cliente cliente = clienteRepository.findById(String.valueOf(cliente_id))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if(cliente.getEstadoCivil() == EstadoCivil.CASADO || cliente.getEstadoCivil() == EstadoCivil.UNIAO_ESTAVEL){
            Conjuge conjuge = getConjuge(dto, cliente);

            repository.save(conjuge);
        }else{
            throw new IllegalStateException("Cliente não está em um estado civil que permite adicionar um cônjuge");
        }
    }

    public ConjugeDTO procurarConjuge(Long cliente_id){
        Cliente cliente = clienteRepository.findById(String.valueOf(cliente_id))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Conjuge conjuge = cliente.getConjuge();

        if(conjuge == null){
            throw new RuntimeException("Conjuge não encontrado para o cliente com ID: "+ cliente_id);
        }

        return converterParaDto(conjuge);
    }

    private ConjugeDTO converterParaDto(Conjuge conjuge) {
        return new ConjugeDTO(
                conjuge.getNome(),
                conjuge.getDataNascimento(),
                conjuge.getRenda(),
                conjuge.getOcupacao()
        );
    }

    public void atualizarConjuge(Long cliente_id, ConjugeDTO dto){
        Cliente cliente = clienteRepository.findById(String.valueOf(cliente_id))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Conjuge conjuge = cliente.getConjuge();

        if (conjuge != null) {
            if (naoEhNulo(dto.nome(), dto.dataNascimento(), dto.renda(), dto.ocupacao())) {
                conjuge.setNome(dto.nome());
                conjuge.setDataNascimento(dto.dataNascimento());
                conjuge.setRenda(dto.renda());
                conjuge.setOcupacao(dto.ocupacao());
                repository.save(conjuge);
            } else {
                throw new IllegalArgumentException("Não pode atualizar o cônjuge: Um ou mais espaços estão nulos.");
            }
        } else {
            throw new RuntimeException("Cliente não possui um cônjuge associado.");
        }
    }

    public void apagarConjuge(Long cliente_id){
        Cliente cliente = clienteRepository.findById(String.valueOf(cliente_id))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Conjuge conjuge = cliente.getConjuge();

        if (conjuge != null) {
            cliente.setConjuge(null);
            repository.delete(conjuge);
        } else {
            throw new RuntimeException("Cônjuge não encontrado para o cliente com ID: " + cliente_id);
        }
    }
}

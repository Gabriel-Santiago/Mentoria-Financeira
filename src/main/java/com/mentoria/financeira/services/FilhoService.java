package com.mentoria.financeira.services;

import com.mentoria.financeira.dtos.CriarFilhoDTO;
import com.mentoria.financeira.dtos.FilhoDTO;
import com.mentoria.financeira.model.Cliente;
import com.mentoria.financeira.model.Filho;
import com.mentoria.financeira.repositorys.ClienteRepository;
import com.mentoria.financeira.repositorys.FilhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FilhoService {

    private final FilhoRepository repository;
    private final ClienteRepository clienteRepository;

    @Autowired
    public FilhoService(FilhoRepository repository, ClienteRepository clienteRepository) {
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

    @Transactional
    public void criarFilho(Long cliente_id, List<CriarFilhoDTO> dto){
        Cliente cliente = clienteRepository.findById(String.valueOf(cliente_id))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        List<Filho> filhos = dto.stream()
                .map(filhoDTO -> {
                    Filho filho = new Filho();
                    filho.setNome(filhoDTO.nome());
                    filho.setDataNascimento(filhoDTO.dataNascimento());
                    filho.setRenda(filhoDTO.renda());
                    filho.setOcupacao(filhoDTO.ocupacao());
                    filho.setCliente(cliente);

                    if(!naoEhNulo(filho.getNome(), filho.getDataNascimento(), filho.getRenda(), filho.getOcupacao())){
                        throw new IllegalArgumentException("Não pode criar o filho: Um ou mais espaços estão nulos.");
                    }

                    return filho;
                })
                .toList();

        repository.saveAll(filhos);

    }

    public List<FilhoDTO> procurarFilho(Long cliente_id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(String.valueOf(cliente_id));

        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            if (cliente.getFilhos().isEmpty()) {
                return Collections.emptyList();
            } else {
                return cliente.getFilhos().stream().map(this::convertToDto).toList();
//                return cliente.getFilhos().stream()
//                        .map(this::convertToDto)
//                        .collect(Collectors.toList());
            }
        } else {
            return Collections.emptyList();
        }
    }

    private FilhoDTO convertToDto(Filho filho) {
        System.out.println("Convertendo Filho para DTO: " + filho);
        return new FilhoDTO(
                filho.getNome(),
                filho.getDataNascimento(),
                filho.getRenda(),
                filho.getOcupacao()
        );
    }

    public void atualizarFilho(Long cliente_id, Long filho_id, FilhoDTO dto){
        Cliente cliente = clienteRepository.findById(String.valueOf(cliente_id))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Filho filho = repository.findById(String.valueOf(filho_id))
                .orElseThrow(() -> new RuntimeException("Filho(a) não encontrado(a)"));

        if (cliente.getFilhos().contains(filho)) {
            if (naoEhNulo(dto.nome(), dto.dataNascimento(), dto.renda(), dto.ocupacao())) {
                filho.setNome(dto.nome());
                filho.setDataNascimento(dto.dataNascimento());
                filho.setRenda(dto.renda());
                filho.setOcupacao(dto.ocupacao());
                repository.save(filho);
            } else {
                throw new IllegalArgumentException("Não pode atualizar o filho: Um ou mais espaços estão nulos.");
            }
        } else {
            throw new RuntimeException("Filho não está associado ao cliente fornecido");
        }
    }

    public void apagarFilho(Long cliente_id, Long filho_id){
        Cliente cliente = clienteRepository.findById(String.valueOf(cliente_id))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Filho filho = repository.findById(String.valueOf(filho_id))
                .orElseThrow(() -> new RuntimeException("Filho(a) não encontrado(a)"));

        if(cliente.getFilhos().contains(filho)){
            cliente.getFilhos().remove(filho);
            repository.delete(filho);
            clienteRepository.save(cliente);
        }else{
            throw new RuntimeException("Nenhum filho(a) associado(a) ao cliente");
        }
    }
}

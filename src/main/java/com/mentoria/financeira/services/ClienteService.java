package com.mentoria.financeira.services;

import com.mentoria.financeira.dtos.ClienteDTO;
import com.mentoria.financeira.model.Cliente;
import com.mentoria.financeira.model.Familia;
import com.mentoria.financeira.repositorys.ClienteRepository;
import com.mentoria.financeira.viaCep.Address;
import com.mentoria.financeira.viaCep.ViaCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ViaCep viaCep;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, ViaCep viaCep) {
        this.clienteRepository = clienteRepository;
        this.viaCep = viaCep;
    }

    private static boolean naoEhNulo(Object... parameters){
        for(Object parameter : parameters){
            if(parameter == null){
                return false;
            }
        }
        return true;
    }

    public void criarUsuario(ClienteDTO dto) throws Exception {
        if(naoEhNulo(dto.id(), dto.cep(), dto.estadoCivil(),
                dto.dataNascimento(),dto.email(), dto.ocupacao(),
                dto.renda(), dto.telefone())){
            throw new IllegalArgumentException("Não pode criar o usuário: Um ou mais espaços estão nulos.");
        }

        Address address = viaCep.viaCep(dto.cep());

        Cliente cliente = new Cliente(dto.id(), dto.telefone(), dto.email(), dto.renda(),
                dto.dataNascimento(), dto.cep(), address.getBairro(), address.getLogradouro(),
                address.getLocalidade(), address.getUf(), dto.ocupacao(), dto.estadoCivil(),
                dto.conjuge(), dto.filhos());

        clienteRepository.save(cliente);
    }

    public Cliente procurarCliente(Long id){
        if(id < 1){
            throw new IllegalArgumentException("O id deve ser maior que zero");
        }

        return clienteRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado pelo id" + id));

    }

    public List<Cliente> procurarTodosClientes(){
        return clienteRepository.findAll();
    }

    public Familia procurarPorConjuge(Cliente cliente){
        return clienteRepository.procurarPorConjuge(cliente);
    }

    public List<Familia> procurarPorFilhos(Cliente cliente){
        List<Familia> filhos = clienteRepository.procurarPorFilhos(cliente);
        return filhos != null ? filhos : new ArrayList<>();
    }

    public void atualizarCliente(Long id, ClienteDTO dto){
        Cliente cliente = clienteRepository.findById(String.valueOf(id))
                .orElseThrow(RuntimeException::new);

        if(naoEhNulo(dto.id(), dto.cep(), dto.estadoCivil(),
                dto.dataNascimento(),dto.email(), dto.ocupacao(),
                dto.renda(), dto.telefone())){

            cliente.setCep(dto.cep());
            cliente.setEstadoCivil(dto.estadoCivil());
            cliente.setDataNascimento(dto.dataNascimento());
            cliente.setEmail(dto.email());
            cliente.setOcupacao(dto.ocupacao());
            cliente.setRenda(dto.renda());
            cliente.setTelefone(dto.telefone());
            cliente.setConjuge(dto.conjuge());
            cliente.setFilhos(dto.filhos());
        }

        clienteRepository.save(cliente);
    }

    public void apagarCliente(Long id){
        if(!clienteRepository.existsById(String.valueOf(id))){
            throw new RuntimeException("Cliente não encontrado pleo id" + id);
        }

        Cliente cliente = procurarCliente(id);
        clienteRepository.delete(cliente);
    }
}

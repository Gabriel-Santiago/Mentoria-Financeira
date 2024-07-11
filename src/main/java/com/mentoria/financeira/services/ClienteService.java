package com.mentoria.financeira.services;

import com.mentoria.financeira.dtos.CriarClienteDTO;
import com.mentoria.financeira.model.Cliente;
import com.mentoria.financeira.repositorys.ClienteRepository;
import com.mentoria.financeira.viaCep.Address;
import com.mentoria.financeira.viaCep.ViaCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void criarUsuario(CriarClienteDTO dto) throws Exception {

        Address address = viaCep.viaCep(dto.cep());

        Cliente cliente = clienteRepository.findById(String.valueOf(dto.id())).orElse(new Cliente());

        if (!naoEhNulo(dto.telefone(), dto.email(), dto.renda(),  dto.dataNascimento(), dto.cep(),
                address.getBairro(), address.getLogradouro(), address.getLocalidade(),
                address.getUf(), dto.ocupacao(), dto.estadoCivil())) {
            throw new IllegalArgumentException("Não pode criar o cliente: Um ou mais espaços estão nulos.");
        }

        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setEmail(dto.email());
        cliente.setRenda(dto.renda());
        cliente.setDataNascimento(dto.dataNascimento());
        cliente.setCep(dto.cep());
        cliente.setBairro(address.getBairro());
        cliente.setLogradouro(address.getLogradouro());
        cliente.setLocalidade(address.getLocalidade());
        cliente.setUf(address.getUf());
        cliente.setOcupacao(dto.ocupacao());
        cliente.setEstadoCivil(dto.estadoCivil());

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

    public void atualizarCliente(Long id, CriarClienteDTO dto) throws Exception {
        Cliente cliente = clienteRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Address address = viaCep.viaCep(dto.cep());

        if(cliente != null){
            if(!cliente.getCep().equals(dto.cep())){
                cliente.setNome(dto.nome());
                cliente.setCep(dto.cep());
                cliente.setBairro(address.getBairro());
                cliente.setLogradouro(address.getLogradouro());
                cliente.setLocalidade(address.getLocalidade());
                cliente.setUf(address.getUf());
                cliente.setEstadoCivil(dto.estadoCivil());
                cliente.setDataNascimento(dto.dataNascimento());
                cliente.setEmail(dto.email());
                cliente.setOcupacao(dto.ocupacao());
                cliente.setRenda(dto.renda());
                cliente.setTelefone(dto.telefone());

                clienteRepository.save(cliente);
            }
        }
    }

    public void apagarCliente(Long id){
        if(!clienteRepository.existsById(String.valueOf(id))){
            throw new RuntimeException("Cliente não encontrado pelo id" + id);
        }

        Cliente cliente = procurarCliente(id);
        clienteRepository.delete(cliente);
    }
}

package com.mentoria.financeira.controllers;

import com.mentoria.financeira.dtos.CriarClienteDTO;
import com.mentoria.financeira.model.Cliente;
import com.mentoria.financeira.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping("/criar-cliente")
    public ResponseEntity<Void> criarCliente(@RequestBody CriarClienteDTO dto) throws Exception {
        service.criarUsuario(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> procurarCliente(@PathVariable("id") Long id){
        return new ResponseEntity<>(service.procurarCliente(id),
                service.procurarCliente(id) != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> procurarTodosClientes(){
        return new ResponseEntity<>(service.procurarTodosClientes(),
                service.procurarTodosClientes() != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarCliente(@PathVariable("id") Long id){
        service.apagarCliente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCliente(@PathVariable("id") Long id, @RequestBody CriarClienteDTO dto) throws Exception {
        service.atualizarCliente(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

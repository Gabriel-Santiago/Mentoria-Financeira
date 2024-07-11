package com.mentoria.financeira.controllers;

import com.mentoria.financeira.dtos.CriarFilhoDTO;
import com.mentoria.financeira.dtos.FilhoDTO;
import com.mentoria.financeira.services.FilhoService;
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
@RequestMapping("/filhos")
public class FilhoController {

    @Autowired
    private FilhoService service;

    @PostMapping("/{id}")
    public ResponseEntity<Void> criarFilhos(@PathVariable("id") Long id,
                                            @RequestBody List<CriarFilhoDTO> dto){
        service.criarFilho(id, dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<FilhoDTO>> buscarFilhos(@PathVariable("id") Long cliente_id){
        List<FilhoDTO> filhos = service.procurarFilho(cliente_id);

        return new ResponseEntity<>(filhos != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("{cliente_id}/{filho_id}")
    public ResponseEntity<Void> atualizarFilho(@PathVariable("cliente_id") Long cliente_id,
                                               @PathVariable("filho_id") Long filho_id,
                                               @RequestBody FilhoDTO dto){
        service.atualizarFilho(cliente_id, filho_id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{cliente_id}/{filho_id}")
    public ResponseEntity<Void> apagarFilho(@PathVariable("cliente_id") Long cliente_id,
                                            @PathVariable("filho_id") Long filho_id){
        service.apagarFilho(cliente_id, filho_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

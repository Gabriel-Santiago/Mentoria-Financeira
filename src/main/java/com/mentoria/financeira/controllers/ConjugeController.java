package com.mentoria.financeira.controllers;

import com.mentoria.financeira.dtos.ConjugeDTO;
import com.mentoria.financeira.dtos.CriarConjugeDTO;
import com.mentoria.financeira.services.ConjugeService;
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

@RestController
@RequestMapping("/conjuge")
public class ConjugeController {

    @Autowired
    private ConjugeService service;

    @PostMapping("/{id}/criar-conjuge")
    public ResponseEntity<Void> criarConjuge(@PathVariable("id") Long id,
                                             @RequestBody CriarConjugeDTO dto){
        service.criarConjuge(id, dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConjugeDTO> buscarConjuge(@PathVariable("id") Long cliente_id){
        return new ResponseEntity<>(service.procurarConjuge(cliente_id),
                service.procurarConjuge(cliente_id) != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{cliente_id}")
    public ResponseEntity<Void> atualizarConjuge(@PathVariable("cliente_id") Long cliente_id,
                                                 @RequestBody ConjugeDTO dto){
        service.atualizarConjuge(cliente_id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarConjuge(@PathVariable("id") Long cliente_id){
        service.apagarConjuge(cliente_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

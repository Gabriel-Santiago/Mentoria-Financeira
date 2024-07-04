package com.mentoria.financeira.repositorys;

import com.mentoria.financeira.model.Cliente;
import com.mentoria.financeira.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Familia procurarPorConjuge(Cliente cliente);

    List<Familia> procurarPorFilhos(Cliente cliente);
}

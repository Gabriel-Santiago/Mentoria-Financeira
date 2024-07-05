package com.mentoria.financeira.repositorys;

import com.mentoria.financeira.model.Cliente;
import com.mentoria.financeira.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Familia findByConjuge(Cliente cliente);

    List<Familia> findByFilhos(Cliente cliente);
}

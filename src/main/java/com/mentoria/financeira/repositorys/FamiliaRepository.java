package com.mentoria.financeira.repositorys;

import com.mentoria.financeira.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, String> {
}
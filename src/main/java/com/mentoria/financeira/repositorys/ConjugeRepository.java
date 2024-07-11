package com.mentoria.financeira.repositorys;

import com.mentoria.financeira.model.Conjuge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConjugeRepository extends JpaRepository<Conjuge, String> {
}

package com.mentoria.financeira.repositorys;

import com.mentoria.financeira.model.Filho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilhoRepository extends JpaRepository<Filho, String> {
}

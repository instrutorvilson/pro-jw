package com.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula.modelos.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}

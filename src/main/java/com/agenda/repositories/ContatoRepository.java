package com.agenda.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.modelos.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
   Optional<Contato> findByEmail(String email);
}

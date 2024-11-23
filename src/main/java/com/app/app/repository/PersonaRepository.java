package com.app.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.app.entity.Persona;

@Repository("personaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Long> {

   Optional<Persona> findByNumeroDocumento(String numeroDocumento);

}

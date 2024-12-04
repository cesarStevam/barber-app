package com.app.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.app.entity.Persona;

@Repository("personaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Long> {

   Optional<Persona> findByNumeroDocumento(String numeroDocumento);

   Optional<Persona> findByEmail(String email);

   List<Persona> findByRol_IdRol(long id);

   @Query(value = "SELECT * FROM personas WHERE token_recuperacion = :token", nativeQuery = true)
   Optional<Persona> findByTokenRecuperacion(@Param("token") String token);

}

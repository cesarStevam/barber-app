package com.app.app.ServiceInterface;

import java.util.Optional;

import com.app.app.entity.Persona;

public interface IPersonasService {

    public void delete(int id_personas);

    Optional<Persona> findByNumeroDocumento(String numeroDocumento);

}

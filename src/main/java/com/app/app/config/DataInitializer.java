package com.app.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.app.app.services.PersonaService;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataInitializer {

    @Autowired
    private PersonaService personaService;

    @PostConstruct
    public void init() {
        // Actualiza todas las contraseñas no cifradas en la base de datos
        personaService.actualizarContraseñasExistentes();
    }
}

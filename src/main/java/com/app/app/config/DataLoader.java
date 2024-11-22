package com.app.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.app.entity.Rol;
import com.app.app.repository.RolRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public void run(String... args) throws Exception {
        if (rolRepository.findByNombreRol("usuario").isEmpty()) {
            Rol rolUsuario = new Rol();
            rolUsuario.setNombreRol("usuario");
            rolRepository.save(rolUsuario);
        }
    }
}


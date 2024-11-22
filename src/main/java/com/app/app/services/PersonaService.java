package com.app.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.app.entity.Persona;
import com.app.app.entity.Rol;
import com.app.app.repository.PersonaRepository;
import com.app.app.repository.RolRepository;

@Service("personaService")
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RolRepository rolRepository;


    @Autowired
    private PasswordEncoder passwordEncoder; // Inyectar el PasswordEncoder

    public List<Persona> getPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> getPersonaById(Long idPersonas) {
        return personaRepository.findById(idPersonas);
    }

    public void saveOrUpdate(Persona persona) {
        // Verificar si la contraseña ya está cifrada
        String contraseñaActual = persona.getContraseña();
        if (contraseñaActual != null && !contraseñaActual.startsWith("$2a$")) { // Si no está cifrada, cifrarla
            String encryptedPassword = passwordEncoder.encode(contraseñaActual);
            persona.setContraseña(encryptedPassword);
        }
        personaRepository.save(persona);
    }

    public void eliminarpersona(Long idPersonas) {
        if (personaRepository.existsById(idPersonas)) {
            personaRepository.deleteById(idPersonas);
        }
    }

    public void actualizarContraseñasExistentes() {
        // Actualizar todas las contraseñas en la base de datos si no están cifradas
        List<Persona> personas = personaRepository.findAll();
        for (Persona persona : personas) {
            String contraseñaActual = persona.getContraseña();

            // Verificar si la contraseña es nula
            if (contraseñaActual == null) {
                continue; // Saltar a la siguiente iteración si la contraseña es nula
            }

            // Cifrar la contraseña solo si no está cifrada con BCrypt
            if (!contraseñaActual.startsWith("$2a$")) {
                String contraseñaCifrada = passwordEncoder.encode(contraseñaActual);
                persona.setContraseña(contraseñaCifrada);
                personaRepository.save(persona);
            }
        }
    }

    public void registrarUsuario(Persona persona) {
        // Recupera el rol "usuario" desde la base de datos
        Rol rolUsuario = rolRepository.findByNombreRol("usuario")
                .orElseThrow(() -> new RuntimeException("Rol 'usuario' no encontrado"));
    
        // Asigna el rol a la persona
        persona.setRol(rolUsuario);
    
        // Cifra la contraseña antes de guardar
        String contraseñaCifrada = passwordEncoder.encode(persona.getContraseña());
        persona.setContraseña(contraseñaCifrada);
    
        // Guarda la persona con el rol asignado
        personaRepository.save(persona);
    }
    
    

}

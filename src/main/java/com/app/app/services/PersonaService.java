package com.app.app.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.app.entity.Persona;
import com.app.app.entity.Rol;
import com.app.app.repository.PersonaRepository;
import com.app.app.repository.RolRepository;

import jakarta.transaction.Transactional;

@Service("personaService")
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Inyectar el PasswordEncoder

    @Autowired
    private EmailService emailService;

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

    @Transactional
    public boolean resetPassword(String token, String nuevaPassword) {
        System.out.println("Token recibido (sin modificar): [" + token + "]");
        token = token.trim();
        System.out.println("Token después de trim(): [" + token + "]");

        // Encuentra la persona asociada al token
        Optional<Persona> personaOpt = personaRepository.findByTokenRecuperacion(token);

        if (personaOpt.isPresent()) {
            Persona persona = personaOpt.get();
            System.out.println("Token válido para el usuario: " + persona.getEmail());

            if (persona.getTokenExpiracion().isAfter(LocalDateTime.now())) {
                persona.setContraseña(passwordEncoder.encode(nuevaPassword));
                persona.setTokenRecuperacion(null);
                persona.setTokenExpiracion(null);

                personaRepository.save(persona);
                personaRepository.flush();
                System.out.println("Contraseña actualizada y token eliminado para: " + persona.getEmail());
                return true;
            } else {
                System.out.println("El token ha expirado.");
            }
        } else {
            System.out.println("Token no encontrado en la base de datos.");
        }
        return false;
    }

    public boolean enviarEmailRecuperacion(String email) {
        Optional<Persona> personaOpt = personaRepository.findByEmail(email);
        if (personaOpt.isPresent()) {
            Persona persona = personaOpt.get();

            // Generar y asignar el token
            String token = UUID.randomUUID().toString();
            persona.setTokenRecuperacion(token);
            persona.setTokenExpiracion(LocalDateTime.now().plusHours(1));
            personaRepository.save(persona); // Guardar los cambios en la base de datos

            // Enviar correo
            String enlace = "http://localhost:8080/recuperar-password/reset?token=" + token;
            String mensaje = "Haz clic en el siguiente enlace para restablecer tu contraseña: " + enlace;
            emailService.enviarEmail(email, "Recuperación de contraseña", mensaje);

            return true;
        }
        return false;
    }

    public boolean validarToken(String token) {
        System.out.println("Validando token recibido: " + token);
        Optional<Persona> personaOpt = personaRepository.findByTokenRecuperacion(token);
        System.out.println("Token buscado: " + token);
        if (personaOpt.isPresent()) {
            Persona persona = personaOpt.get();
            System.out.println("Token válido para el usuario: " + persona.getEmail());

            System.out.println("Token en la base de datos: " + persona.getTokenRecuperacion());

            // Verificar la expiración
            if (persona.getTokenExpiracion().isAfter(LocalDateTime.now())) {
                return true;
            } else {
                System.out.println("El token ha expirado.");
                return false;
            }
        }
        System.out.println("Token no encontrado.");
        return false;

    }

    public boolean existeEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existeEmail'");
    }

    public void guardar(Persona persona) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

}

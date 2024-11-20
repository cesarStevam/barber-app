package com.app.app.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.app.entity.Persona;
import com.app.app.entity.SecurityPersona;
import com.app.app.repository.PersonaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class PersonaDetailsServiceImpl implements UserDetailsService {

    private PersonaRepository personaRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String numeroDocumento) throws UsernameNotFoundException {
        Persona persona = personaRepository.findByNumeroDocumento(numeroDocumento)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new SecurityPersona(persona);
    }
}
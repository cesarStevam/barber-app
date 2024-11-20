package com.app.app.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor

public class SecurityPersona implements UserDetails {

    private Persona persona;

/*     private Rol rol; */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Extraer el nombre del rol desde la entidad Rol asociada a la Persona
        String nombreRol = persona.getRol().getNombreRol();
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + nombreRol));
    }

    @Override
    public String getPassword() {
        return persona.getContraseña();
    }

    @Override
    public String getUsername() {
        return persona.getNumeroDocumento();
    }
}
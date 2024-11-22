package com.app.app.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        // Verifica el rol del usuario autenticado y redirige según corresponda
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_administrador"))) {
            response.sendRedirect("/index");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_usuario"))) {
            response.sendRedirect("/index");
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_barbero"))) {
            response.sendRedirect("/reservas");
        } else {
            response.sendRedirect("/login?error"); // Caso de rol no esperado
        }
    }
}

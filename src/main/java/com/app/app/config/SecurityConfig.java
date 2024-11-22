package com.app.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                return http
                                .csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/", "/index.html", "/barberia6.jpg", "/Logo.jpeg",
                                                                "/static", "/resources",
                                                                "/Fondo.jpeg", "/BuzzCut.jpeg", "/Ceradecabello.jpg",
                                                                "/cortebarberia.jpeg",
                                                                "/Cremadeafeitar.jpg", "/Cremaparaelcabello.jpg",
                                                                "/Gelparaelcabello.jpg",
                                                                "/TaperFade.jpg", "/Lowfadee.jpg", "/Mohicano.jpg",
                                                                "/templates", "/register",
                                                                "/style.css", "/public/**")
                                                .permitAll()

                                                // Rutas para administrador
                                                .requestMatchers("/admin/**", "/agregarreserva", "/personas",
                                                                "/reservas", "/roles", "/editarRol/idRol")
                                                .hasRole("administrador")

                                                // Rutas para usuario
                                                .requestMatchers("/user/**").hasRole("usuario")

                                                // Rutas para barbero
                                                .requestMatchers("/barbero/**", "/agregarreserva", "/reservas")
                                                .hasRole("barbero")

                                                // Cualquier otra ruta debe ser autenticada
                                                .anyRequest().authenticated())

                                .formLogin(form -> form
                                                .loginPage("/login") // Página personalizada de login
                                                .permitAll() // Permitir acceso sin autenticación a la página de login
                                                .successHandler(customAuthenticationSuccessHandler())) // Handler
                                                                                                       // personalizado
                                .logout(logout -> logout
                                                .logoutUrl("/logout") // URL de logout
                                                .logoutSuccessUrl("/index?logout") // Redirigir a /index con el
                                                                                   // parámetro logout
                                                .invalidateHttpSession(true) // Invalida la sesión
                                                .deleteCookies("JSESSIONID") // Elimina la cookie JSESSIONID
                                                .permitAll()) // Permitir acceso sin autenticación al logout

                                .build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
                return new CustomAuthenticationSuccessHandler();
        }
}

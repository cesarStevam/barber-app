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
                                                .requestMatchers("/", "/index.html", "/indexA.html", "/indexB.html",
                                                                "/indexU.html", "/barberia6.jpg", "/Logo.jpeg",
                                                                "/static", "/resources",
                                                                "/Fondo.jpeg", "/BuzzCut.jpeg", "/Ceradecabello.jpg",
                                                                "/cortebarberia.jpeg",
                                                                "/Cremadeafeitar.jpg", "/Cremaparaelcabello.jpg",
                                                                "/Gelparaelcabello.jpg",
                                                                "/TaperFade.jpg", "/Lowfadee.jpg",
                                                                "/Mohicano.jpg",
                                                                "/templates", "/register",
                                                                "/style.css", "/Barberia-moderna-ia-.webp",
                                                                "/youtube.png", "/whatsapp.png", "/instagram.png",
                                                                "/facebook.png", "/Barberia~3.mp4", "/Barbero1.jpg",
                                                                "/Barbero2.jpg", "/Productos.webp",
                                                                "/recuperar-password/**", "/reset-password/**",
                                                                "/eliminarReserva", "/agregarreserva", "/productosU",
                                                                "/Cera American Crew.jpg", "/Fijador L'Oreal.webp",
                                                                "/Balsamo L'Oreal.jpg", "/Shampoo HyS.jpeg",
                                                                "AfterShave Clubman.webp/",
                                                                "/Crema Afeitar Proraso.jpg", "/Aceite Proraso.jpg",
                                                                "/Pomada Reuzel.webp", "/AfterShave Clubman.webp",
                                                                "/public/")
                                                .permitAll()

                                                // Rutas para administrador
                                                .requestMatchers("/admin/", "/agregarreserva", "/editarRol/1",
                                                                "/editarRol/{idRol}", "/personas", "/Agregarpersona",
                                                                "/editarRol", "/agregarrol",
                                                                "/roles", "/editarRol/idRol",
                                                                "/AgregarReserva"

                                                )
                                                .hasRole("administrador")

                                                // Rutas para usuario
                                                .requestMatchers("/user/", "/listaReserva", "/reservaU",
                                                                "/agregarreserva", "/productosU")
                                                .hasRole("usuario")

                                                // Rutas para barbero
                                                .requestMatchers("/barbero/", "/agregarrol", "/agregarreserva")
                                                .hasRole("barbero")

                                                .requestMatchers("/reservas")
                                                .hasAnyRole("administrador", "usuario", "barbero")

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
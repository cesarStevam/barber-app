package com.app.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/inicioSesion")
    public String mostrarPaginaDeInicioSesion() {
        return "inicioSesion";

    }
}

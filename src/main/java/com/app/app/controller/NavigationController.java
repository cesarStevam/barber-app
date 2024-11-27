package com.app.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class NavigationController {

    @GetMapping("/paginaActual")
    public String paginaActual(@RequestHeader(value = "Referer", required = false) String referer, Model model) {
        // Si el encabezado Referer es nulo, redirigir a una página predeterminada (ej. Inicio)
        String prevPage = (referer != null) ? referer : "/";
        model.addAttribute("prevPage", prevPage);
        return "paginaActual"; // Nombre del archivo HTML
    }
}

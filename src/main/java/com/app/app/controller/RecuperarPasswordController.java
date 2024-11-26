package com.app.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.app.services.PersonaService;

@Controller
@RequestMapping("/recuperar-password")
public class RecuperarPasswordController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public String mostrarFormularioRecuperacion() {
        return "recuperar-password"; // Página HTML para introducir el email
    }

    @PostMapping
    public String procesarRecuperacion(@RequestParam("email") String email, Model model) {
        boolean enviado = personaService.enviarEmailRecuperacion(email);
        if (enviado) {
            model.addAttribute("mensaje", "Se ha enviado un enlace de recuperación a tu correo.");
        } else {
            model.addAttribute("error", "No se encontró una cuenta con ese correo.");
        }
        return "recuperar-password";
    }

    @GetMapping("/reset")
    public String mostrarFormularioReset(@RequestParam("token") String token, Model model) {
        if (!personaService.validarToken(token)) {
            model.addAttribute("error", "El token es inválido o ha expirado.");
            return "error";
        }
        model.addAttribute("token", token);
        return "reset-password"; // Página HTML para establecer nueva contraseña
    }

    @PostMapping("/reset")
    public String procesarResetPassword(@RequestParam("token") String token, 
                                         @RequestParam("nuevaPassword") String nuevaPassword, 
                                         Model model) {
        boolean actualizado = personaService.resetPassword(token, nuevaPassword);
        if (actualizado) {
            model.addAttribute("mensaje", "Tu contraseña ha sido restablecida con éxito.");
            return "login";
        } else {
            model.addAttribute("error", "El token es inválido o ha expirado.");
            return "reset-password";
        }
    }
}


package com.app.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.app.entity.Persona;
import com.app.app.repository.PersonaRepository;
import com.app.app.services.PersonaService;

@Controller
@RequestMapping("/recuperar-password")
public class RecuperarPasswordController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private PersonaRepository personaRepository;

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
        return "login";
    }

    @GetMapping("/reset")
    public String mostrarFormularioReset(@RequestParam("token") String token, Model model) {
        System.out.println("Token recibido en la solicitud: " + token);
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

    @PostMapping("/validarToken")
    public ResponseEntity<?> validarToken(@RequestParam("token") String token) {
        // Verificar y depurar el token recibido
        System.out.println("Token recibido (sin modificar): " + token);
    
        // Eliminar cualquier espacio en blanco extra si es necesario
        token = token.trim();
        System.out.println("Token después de trim(): [" + token + "]");
    
        // Realizar la consulta en la base de datos
        Optional<Persona> personaOpt = personaRepository.findByTokenRecuperacion(token);
        if (personaOpt.isPresent()) {
            System.out.println("Token válido para el usuario: " + personaOpt.get().getEmail());
            return ResponseEntity.ok("Token válido.");
        } else {
            System.out.println("Token no encontrado en la base de datos.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Token no encontrado.");
        }
    }

    @GetMapping("/recuperar-password/reset")
    public String showResetPasswordPage(@RequestParam("token") String token, Model model) {
    model.addAttribute("token", token);  // Pasamos el token al modelo
    return "recuperar-contraseña";  // Retornamos la vista que contiene el formulario
    }


    


}


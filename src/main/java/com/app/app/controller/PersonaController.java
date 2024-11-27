package com.app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.app.entity.Persona;
import com.app.app.services.PersonaService;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/home/Personas")

public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping
    public List<Persona> getAll() {
        return personaService.getPersonas();
    }

    @PostMapping
    public void guardarPersona(@RequestBody Persona persona) {
        personaService.saveOrUpdate(persona);
    }

    @GetMapping("/eliminarpersona/{idPersonas}")
    public String eliminarpersona(@PathVariable("idPersonas") Long idPersonas, RedirectAttributes redirectAttributes) {
        personaService.eliminarpersona(idPersonas);
        redirectAttributes.addFlashAttribute("mensaje", "Persona eliminada con éxito");
        return "redirect:/personas";
    }

    @PostMapping("/recuperar-password")
    public String enviarCorreoRecuperacion(@RequestParam String email) {
        boolean enviado = personaService.enviarEmailRecuperacion(email); // Usa el método existente
        if (enviado) {
            return "mensaje-envio"; // Página de éxito
        } else {
            return "error-envio"; // Página de error si el correo no se encuentra
        }
    }

}

package com.app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.app.entity.Ventas;
import com.app.app.services.VentasService;

@RestController
@RequestMapping("/home/Ventas")
public class VentasController {

    @Autowired
    VentasService ventasService;

    @GetMapping
    public List<Ventas> getAll() {
        return ventasService.getVentas();
    }

    @GetMapping("/eliminarventas/{idVentas}")
    public String eliminarventas(@PathVariable("idVentas") Long idVentas, RedirectAttributes redirectAttributes) {
        ventasService.eliminarventas(idVentas);
        redirectAttributes.addFlashAttribute("mensaje", "Persona eliminada con éxito");
        return "redirect:/ventas";
    }

}

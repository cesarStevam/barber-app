package com.app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.app.entity.Inventario;
import com.app.app.services.InventarioService;

@RestController
@RequestMapping("/home/Inventario")
public class InventarioController {
    
    @Autowired
    InventarioService inventarioService;

    @GetMapping
    public List<Inventario> getAll() {
        return inventarioService.getInventario();
    }

    @GetMapping("/eliminarinventario/{idInventario}")
    public String eliminarinventario(@PathVariable("idInventario") Long idInventario, RedirectAttributes redirectAttributes) {
        inventarioService.eliminarinventario(idInventario);
        redirectAttributes.addFlashAttribute("mensaje", "Persona eliminada con éxito");
        return "redirect:/inventario";
    }
}

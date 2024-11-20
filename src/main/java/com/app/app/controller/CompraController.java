package com.app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.app.entity.Compra;
import com.app.app.services.CompraService;

@RestController
@RequestMapping("/home/Compras")
public class CompraController {
    @Autowired
    CompraService compraService;

    @GetMapping
    public List<Compra> getAll() {
        return compraService.getCompras();
    }

    @GetMapping("/eliminarcompra/{idCompras}")
    public String eliminarcompra(@PathVariable("idCompra") Long idCompras, RedirectAttributes redirectAttributes) {
        compraService.eliminarcompra(idCompras);
        redirectAttributes.addFlashAttribute("mensaje", "Persona eliminada con éxito");
        return "redirect:/compras";
    }
}

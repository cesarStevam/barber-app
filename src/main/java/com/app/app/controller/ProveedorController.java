package com.app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.app.entity.Proveedor;
import com.app.app.services.ProveedorService;

@RestController
@RequestMapping("/home/Proveedor")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> getAll() {
        return proveedorService.getProveedor();
    }

    @GetMapping("/eliminarproveedor/{idProveedor}")
    public String eliminarproveedor(@PathVariable("idProveedor") Long idProveedor,
            RedirectAttributes redirectAttributes) {
        proveedorService.eliminarproveedor(idProveedor);
        redirectAttributes.addFlashAttribute("mensaje", "Persona eliminada con éxito");
        return "redirect:/proveedores";
    }
}

package com.app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.app.entity.Producto;
import com.app.app.services.ProductoService;

@RestController
@RequestMapping("/home/Productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping
    public List<Producto> getAll() {
        return productoService.getProductos();
    }

    @PostMapping
    public void guardarProducto(@RequestBody Producto producto) {
        productoService.saveOrUpdate(producto);
    }

    @GetMapping("/eliminarproducto/{idProducto}")
    public String eliminarproducto(@PathVariable("idProducto") Long idProducto, RedirectAttributes redirectAttributes) {
        productoService.eliminarproducto(idProducto);
        redirectAttributes.addFlashAttribute("mensaje", "Persona eliminada con éxito");
        return "redirect:/productos";
    }
}

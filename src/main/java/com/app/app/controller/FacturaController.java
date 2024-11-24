package com.app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.app.entity.Factura;
import com.app.app.services.FacturaService;

@RestController
@RequestMapping("/home/Factura")
public class FacturaController {
    @Autowired
    FacturaService facturaService;

    @GetMapping
    public List<Factura> getAll() {
        return facturaService.getFactura();
    }

    @GetMapping("/{idFactura}")
    public Factura getFacturaById(@PathVariable Long idFactura) {
        return facturaService.getFacturaById(idFactura).orElse(null);
    }
}

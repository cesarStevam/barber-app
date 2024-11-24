package com.app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.app.entity.Recibo;
import com.app.app.services.ReciboService;

@RestController
@RequestMapping("/home/Recibo")
public class ReciboController {
    
    @Autowired
    ReciboService reciboService;

    @GetMapping
    public List<Recibo> getAll() {
        return reciboService.getRecibo();
    }

    @GetMapping("/eliminarrecibo/{idRecibo}")
    public String eliminarrecibo(@PathVariable("idRecibo") Long idRecibo, RedirectAttributes redirectAttributes) {
        reciboService.eliminarrecibo(idRecibo);
        redirectAttributes.addFlashAttribute("mensaje", "Persona eliminada con éxito");
        return "redirect:/recibos";
    }
}

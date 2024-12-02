package com.app.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.app.entity.Rol;
import com.app.app.services.RolService;

@RestController
@RequestMapping("/home/Roles")
public class RolController {

    @Autowired 
    RolService rolService;

    @GetMapping
    public List<Rol> getAll(){
        return rolService.getRoles();
    }
    @PostMapping
    public void guardarRol(@RequestBody Rol rol){
        rolService.saveOrUpdate(rol);
    }

    @GetMapping("/eliminarRol/{idRol}")
    public String eliminarRol(@PathVariable("idRol") Long idRol, RedirectAttributes redirectAttributes) {
        rolService.eliminarRol(idRol);
        return "redirect:/rol";
    }


}

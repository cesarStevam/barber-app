package com.app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

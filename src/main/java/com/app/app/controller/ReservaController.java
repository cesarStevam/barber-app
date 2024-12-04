package com.app.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.app.entity.Persona;
import com.app.app.entity.Reserva;
import com.app.app.repository.PersonaRepository;
import com.app.app.services.ReservaService;

@RestController
@RequestMapping("/home/Reservas")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

        @Autowired
    PersonaRepository personaRepository;


    public Optional<Persona> getLoggerUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String numDoc = authentication.getName();
        return personaRepository.findByNumeroDocumento(numDoc);
    }
    
    
    @GetMapping
    public List<Reserva> getAll(){
        return reservaService.getReservas();
    }

    @PostMapping
    public void guardarReserva(@RequestBody Reserva reserva){
        reservaService.saveOrUpdate(reserva);
    }
}

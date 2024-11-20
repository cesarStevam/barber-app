package com.app.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.app.entity.Reserva;
import com.app.app.services.ReservaService;

@RestController
@RequestMapping("/home/Reservas")
public class ReservaController {

    @Autowired
    ReservaService reservaService;
    
    @GetMapping
    public List<Reserva> getAll(){
        return reservaService.getReservas();
    }

    @PostMapping
    public void guardarReserva(@RequestBody Reserva reserva){
        reservaService.saveOrUpdate(reserva);
    }
}

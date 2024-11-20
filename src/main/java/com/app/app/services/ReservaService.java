package com.app.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.app.entity.Reserva;
import com.app.app.repository.ReservaRepository;


@Service("reservaService")
public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;
    
    public List <Reserva> getReservas(){   //List = Select(Mysql)
    return reservaRepository.findAll();
    }

    public Optional<Reserva> getReservaById(Long idReservas){
    return reservaRepository.findById(idReservas);
}

    public void saveOrUpdate(Reserva reserva) {
    reservaRepository.save(reserva);
}

    public void eliminarReserva(Long idReservas){
    reservaRepository.deleteById(idReservas);
}

}

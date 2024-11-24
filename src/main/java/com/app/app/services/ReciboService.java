package com.app.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.app.entity.Recibo;
import com.app.app.repository.ReciboRepository;

@Service("reciboService")
public class ReciboService {

    @Autowired
    private ReciboRepository reciboRepository;

    public List<Recibo> getRecibo() { // List = Select(Mysql)
        return reciboRepository.findAll();
    }

    public void saveOrUpdate(Recibo recibo) {
        reciboRepository.save(recibo);
    }

    public Optional<Recibo> getReciboById(Long idRecibo) {
        return reciboRepository.findById(idRecibo);
    }

    public void eliminarrecibo(Long idRecibo) {
        if (reciboRepository.existsById(idRecibo)) {
            reciboRepository.deleteById(idRecibo);
        }
    }

}

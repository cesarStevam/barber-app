package com.app.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.app.entity.Ventas;
import com.app.app.repository.VentasRepository;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    public List<Ventas> getVentas() {
        return ventasRepository.findAll();
    }

    public Optional<Ventas> getVentasById(Long idVentas) {
        return ventasRepository.findById(idVentas);
    }

    public  Ventas saveOrUpdate(Ventas ventas) {
        return ventasRepository.save(ventas);
    }

    public void deleteVentas(Long idVentas) {
        ventasRepository.deleteById(idVentas);
    }

    public void eliminarventas(Long idVentas) {
        if (ventasRepository.existsById(idVentas)) {
            ventasRepository.deleteById(idVentas);
        }
    }
}

package com.app.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.app.entity.Factura;
import com.app.app.repository.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    public List<Factura> getFacturas() {
        return facturaRepository.findAll();
    }

    public void saveOrUpdate(Factura factura) {
        facturaRepository.save(factura);
    }

    public Optional<Factura> getFacturaById(Long idFacturas) {
        return facturaRepository.findById(idFacturas);
    }

    public void eliminarFactura(Long idFacturas) {
        if (facturaRepository.existsById(idFacturas)) {
            facturaRepository.deleteById(idFacturas);
        }
    }
}

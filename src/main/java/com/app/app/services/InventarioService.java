package com.app.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.app.entity.Inventario;
import com.app.app.repository.InventarioRepository;

@Service("inventarioService")
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getInventario() { // List = Select(Mysql)
        return inventarioRepository.findAll();
    }

    public void saveOrUpdate(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    public Optional<Inventario> getInventarioById(Long idInventario) {
        return inventarioRepository.findById(idInventario);
    }

    public void eliminarinventario(Long idInventario) {
        if (inventarioRepository.existsById(idInventario)) {
            inventarioRepository.deleteById(idInventario);
        }
    }

}

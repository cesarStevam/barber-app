package com.app.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.app.entity.Inventario;
import com.app.app.repository.InventarioRepository;

import jakarta.transaction.Transactional;

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
        @Transactional
        public void actualizarCantidadCompra(Long idInventario, int cantidadCompra) {
            Inventario inventario = inventarioRepository.findById(idInventario)
                    .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    
            inventario.setCantidad(inventario.getCantidad() + cantidadCompra);
    
            inventarioRepository.save(inventario);
        }

        // Método para reducir la cantidad de un producto en el inventario
        public void reducirCantidad(Long idInventario, int cantidadVendida) {
        Inventario inventario = inventarioRepository.findById(idInventario)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado en el inventario"));

    // Restar la cantidad vendida al inventario
    if (inventario.getCantidad() >= cantidadVendida) {
        inventario.setCantidad(inventario.getCantidad() - cantidadVendida);
        inventarioRepository.save(inventario); // Guardamos la actualización
    } else {
        throw new RuntimeException("No hay suficiente cantidad en el inventario para esta venta");
    }
}

        @Transactional
        public void realizarVenta(Long idInventario, int cantidadVendida) {
            // Primero, actualizamos el inventario restando la cantidad vendida
            inventarioRepository.actualizarCantidad(idInventario, cantidadVendida);
       
    }
    
}



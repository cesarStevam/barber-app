package com.app.app.services;

import com.app.app.entity.Producto;
import com.app.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long idProducto) {
        return productoRepository.findById(idProducto);
    }

    public Producto saveOrUpdate(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }

    public void eliminarproducto(Long idProducto) {
        if (productoRepository.existsById(idProducto)) {
            productoRepository.deleteById(idProducto);
        }
    }
}

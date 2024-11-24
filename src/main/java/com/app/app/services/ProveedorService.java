package com.app.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.app.entity.Proveedor;
import com.app.app.repository.ProveedorRepository;

@Service("proveedorService")
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> getProveedor() { // List = Select(Mysql)
        return proveedorRepository.findAll();
    }

    public void saveOrUpdate(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    public Optional<Proveedor> getProveedorById(Long idProveedor) {
        return proveedorRepository.findById(idProveedor);
    }

    public void eliminarproveedor(Long idProveedor) {
        if (proveedorRepository.existsById(idProveedor)) {
            proveedorRepository.deleteById(idProveedor);
        }
    }

}

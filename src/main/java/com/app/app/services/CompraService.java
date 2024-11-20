package com.app.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.app.entity.Compra;

import com.app.app.repository.CompraRepository;

@Service("compraService")
public class CompraService {

    @Autowired // instancea la clase
    CompraRepository compraRepository;

    public List<Compra> getCompras() { // List = Select(Mysql)
        return compraRepository.findAll();
    }

    public void saveOrUpdate(Compra compra) {
        compraRepository.save(compra);
    }

    public Optional<Compra> getCompraById(Long idCompras) {
        return compraRepository.findById(idCompras);
    }

    public void eliminarcompra(Long idCompras) {
        if (compraRepository.existsById(idCompras)) {
            compraRepository.deleteById(idCompras);
        }
    }

}

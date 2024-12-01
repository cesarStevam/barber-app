package com.app.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.app.entity.Inventario;

import jakarta.transaction.Transactional;

@Repository("inventarioRepository")
public interface InventarioRepository extends JpaRepository<Inventario, Long> {
 
    @Modifying
    @Transactional
    @Query("UPDATE Inventario i SET i.cantidad = i.cantidad - :cantidad WHERE i.idInventario = :idInventario")
    
    void actualizarCantidad(@Param("idInventario") Long idInventario, @Param("cantidad") int cantidad);
    
}


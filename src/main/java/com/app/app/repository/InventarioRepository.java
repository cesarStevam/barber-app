package com.app.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.app.entity.Inventario;

@Repository("inventarioRepository")
public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    
}


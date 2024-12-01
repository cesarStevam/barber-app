package com.app.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.app.entity.Ventas;

@Repository("ventasRepository")
public interface VentasRepository extends JpaRepository<Ventas, Long> {

    Optional<Ventas> findByNombreVenta(String nombreVenta);
}

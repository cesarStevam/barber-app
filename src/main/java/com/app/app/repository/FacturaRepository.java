package com.app.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.app.entity.Factura;

@Repository("facturaRepository")
public interface FacturaRepository extends JpaRepository<Factura, Long> {

}

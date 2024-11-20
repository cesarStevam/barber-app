package com.app.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.app.entity.Compra;

@Repository("compraRepository")
public interface CompraRepository extends JpaRepository<Compra, Long> {

}

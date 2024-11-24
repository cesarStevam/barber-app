package com.app.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.app.entity.Proveedor;


@Repository("ProveedorRepository")
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{


}

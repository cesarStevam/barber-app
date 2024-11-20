package com.app.app.repository;

import com.app.app.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productoRepository")
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

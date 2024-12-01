package com.app.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;

    @Column(name = "nombre", length = 25)
    private String nombre;

    @Column(name = "descripcion", length = 25)
    private String descripcion;

    @Column(name = "precio")
    private Integer precio;


    public Producto() {
    }


    public Producto(Long idProducto, String nombre, String descripcion, Integer precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }


    public Long getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return this.precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    
    
}

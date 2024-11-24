package com.app.app.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idCompras")
    private long idCompras;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "descripcion_producto")
    private String descripcion_producto;

    @Column(name = "valor_unitario")
    private String valor_unitario;

    @Column(name = "valor_total")
    private String valor_total;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fecha_compra;

    @Column(name = "estado_compra")
    private String estado_compra;

    @ManyToMany(mappedBy = "compras")
    private Set<Proveedor> proveedores = new HashSet<>();

    public Compra() {
    }



    public Compra(long idCompras, Integer cantidad, String descripcion_producto, String valor_unitario, String valor_total, LocalDateTime fecha_compra, String estado_compra) {
        this.idCompras = idCompras;
        this.cantidad = cantidad;
        this.descripcion_producto = descripcion_producto;
        this.valor_unitario = valor_unitario;
        this.valor_total = valor_total;
        this.fecha_compra = fecha_compra;
        this.estado_compra = estado_compra;
    }


    public long getIdCompras() {
        return this.idCompras;
    }

    public void setIdCompras(long idCompras) {
        this.idCompras = idCompras;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion_producto() {
        return this.descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getValor_unitario() {
        return this.valor_unitario;
    }

    public void setValor_unitario(String valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public String getValor_total() {
        return this.valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total = valor_total;
    }

    public LocalDateTime getFecha_compra() {
        return this.fecha_compra;
    }

    public void setFecha_compra(LocalDateTime fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getEstado_compra() {
        return this.estado_compra;
    }

    public void setEstado_compra(String estado_compra) {
        this.estado_compra = estado_compra;
    }
    

}

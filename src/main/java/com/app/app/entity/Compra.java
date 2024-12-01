package com.app.app.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Column(name = "descripcion_producto", length = 25)
    private String descripcion_producto;

    @Column(name = "valor_unitario")
    private Integer valor_unitario;

    @Column(name = "valor_total")
    private Integer valor_total;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fecha_compra;

    @Column(name = "estado_compra", length=25)
    private String estado_compra;

    @ManyToOne
    @JoinColumn(name = "idInventario")  
    private Inventario inventario;

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @ManyToOne
    @JoinColumn(name = "idProveedor")  
    private Proveedor proveedor;
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Compra() {
    }



    public Compra(long idCompras, Integer cantidad, String descripcion_producto, Integer valor_unitario, Integer valor_total, LocalDateTime fecha_compra, String estado_compra, Inventario inventario, Proveedor proveedor) {
        this.idCompras = idCompras;
        this.cantidad = cantidad;
        this.descripcion_producto = descripcion_producto;
        this.valor_unitario = valor_unitario;
        this.valor_total = valor_total;
        this.fecha_compra = fecha_compra;
        this.estado_compra = estado_compra;
        this.inventario = inventario;
        this.proveedor = proveedor;
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

    public Integer getValor_unitario() {
        return this.valor_unitario;
    }

    public void setValor_unitario(Integer valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public Integer getValor_total() {
        return this.valor_total;
    }

    public void setValor_total(Integer valor_total) {
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

    public Inventario getInventario() {
        return this.inventario;
    }


    public Proveedor getProveedor() {
        return this.proveedor;
    }


}

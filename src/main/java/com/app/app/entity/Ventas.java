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
@Table(name = "ventas")

public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idVentas")
    private long idVentas;

    @Column(name = "nombreVenta", length=25)
    private String nombreVenta;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fecha_venta;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "idInventario")  
    private Inventario inventario;

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @ManyToOne
    @JoinColumn(name = "idRecibo")  
    private Recibo recibo;

    @ManyToOne
    @JoinColumn(name = "idProducto")  
    private Producto producto;


    public Ventas() {
    }


    public Ventas(long idVentas, String nombreVenta, LocalDateTime fecha_venta, int cantidad, Inventario inventario, Recibo recibo, Producto producto) {
        this.idVentas = idVentas;
        this.nombreVenta = nombreVenta;
        this.fecha_venta = fecha_venta;
        this.cantidad = cantidad;
        this.inventario = inventario;
        this.recibo = recibo;
        this.producto = producto;
    }



    public long getIdVentas() {
        return this.idVentas;
    }

    public void setIdVentas(long idVentas) {
        this.idVentas = idVentas;
    }

    public String getNombreVenta() {
        return this.nombreVenta;
    }

    public void setNombreVenta(String nombreVenta) {
        this.nombreVenta = nombreVenta;
    }

    public LocalDateTime getFecha_venta() {
        return this.fecha_venta;
    }

    public void setFecha_venta(LocalDateTime fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Inventario getInventario() {
        return this.inventario;
    }


    public Recibo getRecibo() {
        return this.recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


}

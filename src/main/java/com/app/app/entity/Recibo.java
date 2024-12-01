package com.app.app.entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name="recibos")
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idRecibo")
    private Long idRecibo;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime fecha_recibo;

    @Column(name = "tipo_servicio", length = 25)
    private String tipo_servicio;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "sub_total")
    private Integer sub_total;

    @Column(name = "total")
    private Integer total;


    public Recibo() {
    }



    public Recibo(Long idRecibo, LocalDateTime fecha_recibo, String tipo_servicio, Integer cantidad, Integer sub_total, Integer total) {
        this.idRecibo = idRecibo;
        this.fecha_recibo = fecha_recibo;
        this.tipo_servicio = tipo_servicio;
        this.cantidad = cantidad;
        this.sub_total = sub_total;
        this.total = total;
    }


    public Long getIdRecibo() {
        return this.idRecibo;
    }

    public void setIdRecibo(Long idRecibo) {
        this.idRecibo = idRecibo;
    }

    public LocalDateTime getFecha_recibo() {
        return this.fecha_recibo;
    }

    public void setFecha_recibo(LocalDateTime fecha_recibo) {
        this.fecha_recibo = fecha_recibo;
    }

    public String getTipo_servicio() {
        return this.tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getSub_total() {
        return this.sub_total;
    }

    public void setSub_total(Integer sub_total) {
        this.sub_total = sub_total;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}

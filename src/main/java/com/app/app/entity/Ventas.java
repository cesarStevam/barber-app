package com.app.app.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @Column(name = "Fecha")
    private Date Fecha;

    @Column(name = "Hora")
    private Date Hora;

    @OneToOne
    @JoinColumn(name = "IdFactura")
    private Factura factura;

    public Ventas() {
    }

    public Ventas(long idVentas, Date Fecha, Date Hora) {
        this.idVentas = idVentas;
        this.Fecha = Fecha;
        this.Hora = Hora;
    }

    public long getIdVentas() {
        return this.idVentas;
    }

    public void setIdVentas(long idVentas) {
        this.idVentas = idVentas;
    }

    public Date getFecha() {
        return this.Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Date getHora() {
        return this.Hora;
    }

    public void setHora(Date Hora) {
        this.Hora = Hora;
    }

}

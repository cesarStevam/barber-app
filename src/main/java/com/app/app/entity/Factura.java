package com.app.app.entity;

import java.util.Set;

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
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFactura")
    private long idFactura;

    @Column(name = "Fecha")
    private String Fecha; // Cambiado a String

    @Column(name = "Hora")
    private String Hora; // Cambiado a String

    @ManyToMany(mappedBy = "factura")
    private Set<Compra> compras;

    public Factura() {
    }


    public Factura(long idFactura, String Fecha, String Hora, Set<Compra> compras) {
        this.idFactura = idFactura;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.compras = compras;
    }


    public long getIdFactura() {
        return this.idFactura;
    }

    public void setIdFactura(long idFactura) {
        this.idFactura = idFactura;
    }

    public String getFecha() {
        return this.Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getHora() {
        return this.Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public Set<Compra> getCompras() {
        return this.compras;
    }

    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }



}

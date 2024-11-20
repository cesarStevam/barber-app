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
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFacturas")
    private long idFacturas;

    @Column(name = "Fecha")
    private String Fecha; // Cambiado a String

    @Column(name = "Hora")
    private String Hora; // Cambiado a String

    @ManyToMany(mappedBy = "facturas")
    private Set<Compra> compras;

    public Factura() {
    }

    public Factura(long idFacturas, String Fecha, String Hora) { // Cambiado a String
        this.idFacturas = idFacturas;
        this.Fecha = Fecha;
        this.Hora = Hora;
    }

    public long getIdFacturas() {
        return this.idFacturas;
    }

    public void setIdFacturas(long idFacturas) {
        this.idFacturas = idFacturas;
    }

    public String getFecha() { // Cambiado a String
        return this.Fecha;
    }

    public void setFecha(String Fecha) { // Cambiado a String
        this.Fecha = Fecha;
    }

    public String getHora() { // Cambiado a String
        return this.Hora;
    }

    public void setHora(String Hora) { // Cambiado a String
        this.Hora = Hora;
    }

}

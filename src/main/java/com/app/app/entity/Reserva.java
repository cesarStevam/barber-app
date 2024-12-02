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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idReservas")
    private long idReservas;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime FechaHora;

    @ManyToOne
    @JoinColumn(name="idPersonas")
    private Persona id_Personas;

    // Relación inversa One-to-One con Recibo
    @OneToOne(mappedBy = "reserva")
    private Recibo recibo;


    public Reserva() {
    }


    public Reserva(long idReservas, LocalDateTime FechaHora, Persona id_Personas) {
        this.idReservas = idReservas;
        this.FechaHora = FechaHora;
        this.id_Personas = id_Personas;
    }

    

    public long getIdReservas() {
        return this.idReservas;
    }

    public void setIdReservas(long idReservas) {
        this.idReservas = idReservas;
    }

    public LocalDateTime getFechaHora() {
        return this.FechaHora;
    }

    public void setFechaHora(LocalDateTime FechaHora) {
        this.FechaHora = FechaHora;
    }

    public Persona getId_Personas() {
        return this.id_Personas;
    }

    public void setId_Personas(Persona id_Personas) {
        this.id_Personas = id_Personas;
    }




}

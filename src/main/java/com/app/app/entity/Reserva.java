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
@Table(name = "reservas")
public class Reserva {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idReservas")
    private long idReservas;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime FechaHora;


    @ManyToOne
    @JoinColumn(name="idCliente")
    private Persona idCliente;

    @ManyToOne
    @JoinColumn(name="persona_barbero_id")
    private Persona personaBarbero;



    public Reserva() {
    }
    

    public Reserva(long idReservas, LocalDateTime FechaHora, Persona idCliente, Persona personaBarbero) {
        this.idReservas = idReservas;
        this.FechaHora = FechaHora;
        this.idCliente = idCliente;
        this.personaBarbero = personaBarbero;
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


    public Persona getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Persona idCliente) {
        this.idCliente = idCliente;
    }

    public Persona getPersonaBarbero() {
        return this.personaBarbero;
    }

    public void setPersonaBarbero(Persona personaBarbero) {
        this.personaBarbero = personaBarbero;
    }



}
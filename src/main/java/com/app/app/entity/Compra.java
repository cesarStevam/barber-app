package com.app.app.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @Column(name = "primer_nombre")
    private String primer_nombre;

    @Column(name = "segundo_nombre")
    private String segundo_nombre;

    @Column(name = "primer_apellido")
    private String primer_apellido;

    @Column(name = "segundo_apellido")
    private String segundo_apellido;

    @Column(name = "numero_documento")
    private String numero_documento;

    @Column(name = "descripcion_producto")
    private String descripcion_producto;

    @Column(name = "Cantidad")
    private String Cantidad;

    @Column(name = "valor_unitario")
    private String valor_unitario;

    @Column(name = "valor_total")
    private String valor_total;

    @ManyToOne
    @JoinColumn(name = "idPersonas")
    private Persona persona;

    @ManyToMany
    @JoinTable(name = "compra_factura", joinColumns = @JoinColumn(name = "idCompras"), inverseJoinColumns = @JoinColumn(name = "idFacturas"))
    private Set<Factura> facturas;

    public Compra() {
    }

    public Compra(long idCompras, String primer_nombre, String segundo_nombre, String primer_apellido,
            String segundo_apellido, String numero_documento, String descripcion_producto, String Cantidad,
            String valor_unitario, String valor_total) {
        this.idCompras = idCompras;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.numero_documento = numero_documento;
        this.descripcion_producto = descripcion_producto;
        this.Cantidad = Cantidad;
        this.valor_unitario = valor_unitario;
        this.valor_total = valor_total;
    }

    public long getIdCompras() {
        return this.idCompras;
    }

    public void setIdCompras(long idCompras) {
        this.idCompras = idCompras;
    }

    public String getPrimer_nombre() {
        return this.primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return this.segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getPrimer_apellido() {
        return this.primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return this.segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getNumero_documento() {
        return this.numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getDescripcion_producto() {
        return this.descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getCantidad() {
        return this.Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
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

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Set<Factura> getFacturas() {
        return this.facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

}

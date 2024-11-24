package com.app.app.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name="proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idProveedor")
    private Long idProveedor;

    @Column(name = "primer_nombre")
    private String primer_nombre;

    @Column(name = "segundo_nombre")
    private String segundo_nombre;

    @Column(name = "primer_apellido")
    private String primer_apellido;

    @Column(name = "segundo_apellido")
    private String segundo_apellido;

    @Column(name = "numeroDocumento")
    private String numeroDocumento;

    @ManyToMany
    @JoinTable(
        name = "proveedor_compra", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "proveedor_id"), // Clave foránea hacia Proveedor
        inverseJoinColumns = @JoinColumn(name = "compra_id") // Clave foránea hacia Compra
    )
    private Set<Compra> compras = new HashSet<>();


    public Proveedor() {
    }


    public Long getIdProveedor() {
        return this.idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getNumeroDocumento() {
        return this.numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Set<Compra> getCompras() {
        return this.compras;
    }

    public void setCompras(Set<Compra> compras) {
        this.compras = compras;
    }





}

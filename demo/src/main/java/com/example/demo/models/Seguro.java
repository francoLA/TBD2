package com.example.demo.models;

import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "seguro")
public class Seguro {
    @Id
    @GeneratedValue
    @Column(name = "idSeguro")
    private String idSeguro;
    @Column(nullable = false, name = "cobertura")
    private String cobertura;
    @Column(nullable = false, name = "duracion")
    private String duracion;
    @Column(nullable = false, name = "tipo")
    private String tipo;
    //RELACIONES
    //Seguro -> Persona
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idSeguro")
    @JsonIgnore
    private Set<Persona> personas;
    //Seguro -> Isapre
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idFondo")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FondoDeSalud fondoDeSalud;

    public Seguro(String idSeguro, String cobertura, String duracion, String tipo) {
        this.idSeguro = idSeguro;
        this.cobertura = cobertura;
        this.duracion = duracion;
        this.tipo = tipo;
    }

    public String getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(String idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Seguro{" +
                "idSeguro=" + idSeguro +
                ", cobertura='" + cobertura + '\'' +
                ", duracion='" + duracion + '\'' +
                ", tipo=" + tipo + '\'' +
                '}';
    }
}
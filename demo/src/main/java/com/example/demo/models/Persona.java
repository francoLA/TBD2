package com.example.demo.models;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    @Column(name = "idPersona")
    private String idPersona;
    @Column(nullable = false, name = "nombre")
    private String nombre;
    @Column(nullable = false, name = "genero")
    private String genero;
    //RELACIONES
    //Persona -> Cotizacion
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersona")
    @JsonIgnore
    private List<Cotizacion> cotizaciones;
    //Persona -> Seguro
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersona")
    @JsonIgnore
    private List<Seguro> seguros;
    //Persona -> Plan
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPersona")
    @JsonIgnore
    private List<Plan> planes;

    public Persona(String idPersona, String nombre, String genero) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
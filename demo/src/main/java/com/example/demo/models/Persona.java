package com.example.demo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue
    private String id;
    @Column(nullable = false, name = "nombre")
    private String nombre;
    @Column(nullable = false, name = "genero")
    private String genero;

    public Persona(String id, String nombre, String genero) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    //RELACIONES

    //Persona -> Cotizacion
    /*@OneToMany(mappedBy = "personas")
    @JsonIgnore
    private List<Cotizacion> cotizacionesList;

    //Persona -> Seguro
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "seguros")
    private Seguro seguro;

    //Persona -> Plan
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "planes")
    private Plan plan;*/
    
}
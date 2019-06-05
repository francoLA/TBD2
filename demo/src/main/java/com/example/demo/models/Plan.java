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
@Table(name = "planes")
public class Plan {
    @Id
    @GeneratedValue
    private String id;
    @Column(nullable = false, name = "cobertura")
    private String cobertura;
    @Column(nullable = false, name = "cantidad_personas")
    private int cantidad_personas;

    public Plan(String id, String cobertura, int cantidad_personas) {
        this.id = id;
        this.cobertura = cobertura;
        this.cantidad_personas = cantidad_personas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public int getCantidadPersonas() {
        return cantidad_personas;
    }

    public void setCantidadPersonas(int cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }


    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", cobertura='" + cobertura + '\'' +
                ", cantidad personas='" + cantidad_personas + '\'' +
                '}';
    }

    //RELACIONES

    //Plan -> Persona
    /*@OneToMany(mappedBy = "planes")
    @JsonIgnore
    private List<Persona> personasList;

    //Plan -> Isapre
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "isapres")
    private Isapre isapre;*/
}
package com.example.demo.models;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue
    @Column(name = "idPlan")
    private String idPlan;
    @Column(nullable = false, name = "cobertura")
    private String cobertura;
    @Column(nullable = false, name = "cantidad_personas")
    private int cantidad_personas;
    //RELACIONES
    //Plan -> Persona
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idPlan")
    @JsonIgnore
    private List<Persona> personas;
    //Plan -> Fondo de Salud
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idFondo")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private FondoDeSalud fondoDeSalud;

    public Plan(String idPlan, String cobertura, int cantidad_personas) {
        this.idPlan = idPlan;
        this.cobertura = cobertura;
        this.cantidad_personas = cantidad_personas;
    }

    public String getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(String id) {
        this.idPlan = id;
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
                "idPlan=" + idPlan +
                ", cobertura='" + cobertura + '\'' +
                ", cantidad personas='" + cantidad_personas + '\'' +
                '}';
    }
}
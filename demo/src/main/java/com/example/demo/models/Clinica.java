package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "clinica")
public class Clinica {
    @Id
    @GeneratedValue
    @Column(name = "idClinica")
    private String idClinica;
    @Column(nullable = false, name = "nombre")
    private String nombre;
    @ManyToMany
    private Set<FondoDeSalud> fondosDeSalud;

    public Clinica(String id, String nombre) {
        this.idClinica = id;
        this.nombre = nombre;
    }

    public String getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(String id) {
        this.idClinica = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<FondoDeSalud> getFondosDeSalud(){
        return this.fondosDeSalud;
    }

    public void setFondosDeSalud(Set<FondoDeSalud> fondosDeSalud){
        this.fondosDeSalud = fondosDeSalud;
    }

    @Override
    public String toString() {
        return "Clinica{" +
                "id=" + idClinica +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
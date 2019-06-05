package com.example.demo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "isapres")
public class Isapre {
    @Id
    @GeneratedValue
    private String id;
    @Column(nullable = false, name = "nombre")
    private String nombre;
    @Column(nullable = false, name = "telefono")
    private String telefono;
    @Column(nullable = false, name = "fonasa")
    private boolean fonasa;

    public Isapre(String id, String nombre, String telefono, boolean fonasa) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fonasa = fonasa;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getFonasa() {
        return fonasa;
    }

    public void setFonasa(boolean fonasa) {
        this.fonasa = fonasa;
    }

    @Override
    public String toString() {
        return "Isapre{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fonasa=" + (this.fonasa ? "fonasa" : "isapre") +
                '}';
    }

    //RELACIONES

    //Isapre -> Seguro
    /*@OneToMany(mappedBy = "isapres")
    @JsonIgnore
    private List<Seguro> segurosList;

    //Isapre -> Plan
    @OneToMany(mappedBy = "isapres")
    @JsonIgnore
    private List<Plan> planList;*/
}
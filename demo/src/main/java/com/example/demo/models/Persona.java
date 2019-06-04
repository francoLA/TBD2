package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Entity
@NoArgsConstructor
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue
    private String id;
    @NonNull
    private String nombre;
    @NonNull
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
    @OneToMany(mappedBy = "personas")
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
    private Plan plan;
    
}
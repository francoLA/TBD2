package com.example.demo.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;


import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Entity
@NoArgsConstructor
@Table(name = "clinicas")
public class Clinica {
    @Id
    @GeneratedValue
    private String id;
    @NonNull
    private String nombre;

    public Clinica(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Clinica{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
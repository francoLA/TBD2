package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "isapres")
public class Isapre {
    @Id
    @GeneratedValue
    private String id;
    @NonNull
    private String nombre;
    @NonNull
    private String telefono;
    @NonNull
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
}
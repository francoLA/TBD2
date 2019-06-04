package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "seguros")
public class Seguro {
    @Id
    @GeneratedValue
    private String id;
    @NonNull
    private String cobertura;
    @NonNull
    private int cantidad_personas;

    public Clinica(String id, String cobertura, int cantidad_personas {
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

    public String getCantidadPersonas() {
        return cantidad_personas;
    }

    public void setCantidadPersonas(String cantidad_personas) {
        this.cantidad_personas = cantidad_personas;
    }


    @Override
    public String toString() {
        return "Seguro{" +
                "id=" + id +
                ", cobertura='" + cobertura + '\'' +
                ", cantidad personas='" + cantidad_personas + '\'' +
                '}';
    }
}
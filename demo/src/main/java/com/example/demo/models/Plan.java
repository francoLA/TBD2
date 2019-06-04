package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "planes")
public class Plan {
    @Id
    @GeneratedValue
    private String id;
    @NonNull
    private String cobertura;
    @NonNull
    private int cantidad_personas;

    public Plan(String id, String cobertura, int cantidad_personas {
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
}
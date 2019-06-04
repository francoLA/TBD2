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
    private String duracion;
    @NonNull
    private String tipo;

    public Seguro(String id, String cobertura, String duracion, String tipo) {
        this.id = id;
        this.cobertura = cobertura;
        this.duracion = duracion;
        this.tipo = tipo;
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

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Seguro{" +
                "id=" + id +
                ", cobertura='" + cobertura + '\'' +
                ", duracion='" + duracion + '\'' +
                ", tipo=" + tipo + '\'' +
                '}';
    }
}
package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "cotizaciones")
public class Cotizacion {
    @Id
    @GeneratedValue
    private String id;
    @NonNull
    private Date fecha;
    @NonNull
    private int monto;

    public Cotizacion(String id, Date fecha, int monto {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }


    @Override
    public String toString() {
        return "Cotizacion{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", monto='" + monto + '\'' +
                '}';
    }
}
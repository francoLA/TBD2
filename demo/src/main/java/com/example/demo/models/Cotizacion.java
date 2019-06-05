package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cotizaciones")
public class Cotizacion {
    @Id
    @GeneratedValue
    private String id;
    @Column(nullable = false, name = "fecha")
    private Date fecha;
    @Column(nullable = false, name = "monto")
    private int monto;

    public Cotizacion(String id, Date fecha, int monto) {
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

    //Cotizacion -> Persona
    /*@ManyToOne
    @JsonIgnore
    @JoinColumn(name = "personas")
    private Persona persona;*/
}
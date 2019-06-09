package com.example.demo.models;

import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cotizacion")
public class Cotizacion {
    @Id
    @GeneratedValue
    @Column(name = "idCotizacion")
    private String idCotizacion;
    @Column(nullable = false, name = "fecha")
    private Date fecha;
    @Column(nullable = false, name = "monto")
    private int monto;
    //Cotizacion -> Persona
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "idPersona")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Persona persona;
    
    public Cotizacion(String id, Date fecha, int monto) {
        this.idCotizacion = id;
        this.fecha = fecha;
        this.monto = monto;
    }

    public String getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(String id) {
        this.idCotizacion = id;
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

    public Persona getPersona(){
        return persona;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Cotizacion{" +
                "idCotizacion=" + idCotizacion +
                ", fecha='" + fecha + '\'' +
                ", monto='" + monto + '\'' +
                '}';
    }

}
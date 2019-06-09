package com.example.demo.models;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "fondo_de_salud")
public class FondoDeSalud {
    @Id
    @GeneratedValue
    @Column(name = "idFondo")
    private String idFondo;
    @Column(nullable = false, name = "nombre")
    private String nombre;
    @Column(nullable = false, name = "telefono")
    private String telefono;
    @Column(nullable = false, name = "fonasa")
    private boolean fonasa;
    @Column(nullable = false, name = "aprobacion")
    private int aprobacion;
    @Column(nullable = false, name = "desaprobacion")
    private int desaprobacion;
    @Column(nullable = false, name = "cantidadAfiliados")
    private int cantidadAfiliados;  
    //RELACIONES
    //Fondo de Salud -> Seguro
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFondo")
    @JsonIgnore
    private List<Seguro> seguros;
    //Fondo de Salud -> Plan
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFondo")
    @JsonIgnore
    private List<Plan> planes;
    //Fondo de Salud -> Palabras
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idFondo")
    @JsonIgnore
    private List<Palabra> palabras;

    public FondoDeSalud(){}

    public FondoDeSalud(String id, String nombre, String telefono, boolean fonasa) {
        this.idFondo = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fonasa = fonasa;
        this.aprobacion = 0;
        this.desaprobacion = 0;
        this.cantidadAfiliados = 0;
    }

    public String getIdFondo() {
        return idFondo;
    }

    public void setIdFondo(String id) {
        this.idFondo = id;
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

    public int getAprobacion(){
        return aprobacion;
    }

    public void setAprobacion(int aprobacion){
        this.aprobacion = aprobacion;
    }

    public int getDesaprobacion(){
        return desaprobacion;
    }

    public void setDesaprobacion(int desaprobacion){
        this.desaprobacion = desaprobacion;
    }

    public int getCantidadAfiliados(){
        return cantidadAfiliados;
    }

    public void setCantidadAfiliados(int cantidadAfiliados){
        this.cantidadAfiliados = cantidadAfiliados;
    }

    public List<Seguro> getSeguros(){
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros){
        this.seguros = seguros;
    }

    public List<Plan> getPlanes(){
        return planes;
    }

    public void setPlanes(List<Plan> planes){
        this.planes = planes;
    }

    public List<Palabra> getPalabras(){
        return palabras;
    }

    public void setPalabras(List<Palabra> palabras){
        this.palabras = palabras;
    }

    @Override
    public String toString() {
        return "FondoDeSalud{" +
                "idFondo=" + idFondo +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fonasa=" + (this.fonasa ? "fonasa" : "isapre") +
                '}';
    }
}
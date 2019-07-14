package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FondoDeSaludNodo {

    @Id
    @GeneratedValue
    private Long id;

    private String fdsID;

    private String name;

    private String telefono;

    private boolean fonasa;

    private int aprobacion;

    private int desaprobacion;

    private int cantidadAfiliados;

    private Double size;

    public FondoDeSaludNodo(String fdsID, String nombre) {
        this.fdsID = fdsID;
        this.name = nombre;
        this.size = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isFonasa() {
        return fonasa;
    }

    public void setFonasa(boolean fonasa) {
        this.fonasa = fonasa;
    }

    public int getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(int aprobacion) {
        this.aprobacion = aprobacion;
    }

    public int getDesaprobacion() {
        return desaprobacion;
    }

    public void setDesaprobacion(int desaprobacion) {
        this.desaprobacion = desaprobacion;
    }

    public int getCantidadAfiliados() {
        return cantidadAfiliados;
    }

    public void setCantidadAfiliados(int cantidadAfiliados) {
        this.cantidadAfiliados = cantidadAfiliados;
    }

    public String getFdsId() {
        return fdsID;
    }

    public void setFdsId(String fdsId) {
        this.fdsID = fdsId;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}

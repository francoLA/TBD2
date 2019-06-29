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

    private Long fdsId;

    private String nombre;

    private String telefono;

    private boolean fonasa;

    private int aprobacion;

    private int desaprobacion;

    private int cantidadAfiliados;

    private Double size;

    public FondoDeSaludNodo(Long fdsId, String nombre) {
        this.fdsId = fdsId;
        this.nombre = nombre;
        this.size = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getFdsId() {
        return fdsId;
    }

    public void setFdsId(Long fdsId) {
        this.fdsId = fdsId;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}

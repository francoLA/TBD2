package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "palabras")
public class Palabra {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;
    @Column(nullable = false, name = "texto")
    private String texto;
    @Column(nullable = false, name = "tipo")
    private String tipo;

    public Palabra(String texto, String tipo){
        this.texto = texto;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
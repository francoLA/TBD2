package com.example.demo.models;
import javax.persistence.*;

@Entity
@Table(name = "palabras", schema = "tbd")
public class Palabra {
    @Id
    @GeneratedValue
    @Column(name = "idPalabra")
    private String idPalabra;
    @Column(nullable = false, name = "texto")
    private String texto;
    @Column(nullable = false, name = "tipo")
    private String tipo;

    public Palabra(){}

    public Palabra(String idPalabra, String texto, String tipo){
        this.idPalabra = idPalabra;
        this.texto = texto;
        this.tipo = tipo;
    }

    public String getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(String id) {
        this.idPalabra = id;
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
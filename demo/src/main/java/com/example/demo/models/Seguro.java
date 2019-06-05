package com.example.demo.models;

// import java.util.List;
import javax.persistence.*;
// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "seguros")
public class Seguro {
    @Id
    @GeneratedValue
    private String id;
    @Column(nullable = false, name = "cobertura")
    private String cobertura;
    @Column(nullable = false, name = "duracion")
    private String duracion;
    @Column(nullable = false, name = "tipo")
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

    //RELACIONES

    //Seguro -> Persona
    /*@OneToMany(mappedBy = "seguros")
    @JsonIgnore
    private List<Persona> personasList;

    //Seguro -> Isapre
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "isapres")
    private Isapre isapre;*/
}
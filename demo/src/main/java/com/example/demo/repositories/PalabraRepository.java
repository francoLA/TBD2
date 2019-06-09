package com.example.demo.repositories;

import com.example.demo.models.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalabraRepository extends JpaRepository<Palabra, String> {
    Palabra findPalabraByIdPalabra(String id);
    Palabra findPalabraByTexto(String texto);
    List<Palabra> findPalabraByTipo(String tipo);
}

package com.example.demo.repositories;

import com.example.demo.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, String> {
    Persona findPersonaById(String id);
}
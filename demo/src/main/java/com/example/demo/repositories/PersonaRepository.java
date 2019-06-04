package com.example.demo.repositories;

import com.example.demo.models.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, String> {
    Persona findPersonaById(String id);
}
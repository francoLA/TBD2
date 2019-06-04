package com.example.demo.repositories;

import com.example.demo.models.Clinica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends MongoRepository<Clinica, String> {
    Clinica findClinicaById(String id);
}
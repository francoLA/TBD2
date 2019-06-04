package com.example.demo.repositories;

import com.example.demo.models.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, String> {
    Clinica findClinicaById(String id);
}
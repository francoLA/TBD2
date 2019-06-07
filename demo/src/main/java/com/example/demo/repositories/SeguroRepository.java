package com.example.demo.repositories;

import com.example.demo.models.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, String> {
    Seguro findSeguroById(String id);
}
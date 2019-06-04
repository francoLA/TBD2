package com.example.demo.repositories;

import com.example.demo.models.Seguro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroRepository extends MongoRepository<Seguro, String> {
    Seguro findSeguroById(String id);
}
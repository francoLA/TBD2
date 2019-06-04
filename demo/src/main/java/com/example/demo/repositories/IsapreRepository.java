package com.example.demo.repositories;

import com.example.demo.models.Isapre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsapreRepository extends MongoRepository<Isapre, String> {
    Isapre findIsapreById(String id);
}
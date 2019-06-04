package com.example.demo.repositories;

import com.example.demo.models.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends MongoRepository<Plan, String> {
    Plan findPlanById(String id);
}
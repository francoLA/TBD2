package com.example.demo.repositories;

import com.example.demo.models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, String> {
    Plan findPlanByIdPlan(String id);
}
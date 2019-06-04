package com.example.demo.repositories;

import com.example.demo.models.Isapre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IsapreRepository extends JpaRepository<Isapre, String> {
    Isapre findIsapreById(String id);
}
package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.annotation.Query;

import java.util.Collection;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User)<-[r:COMENTA]-(f:FondoDeSalud) RETURN u,r,f")
    Collection<User> getAllUsers();
}

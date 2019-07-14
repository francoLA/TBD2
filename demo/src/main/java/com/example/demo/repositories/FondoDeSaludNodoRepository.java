package com.example.demo.repositories;

import com.example.demo.models.FondoDeSaludNodo;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "Fondo", path = "Fondo")
@Repository
public interface FondoDeSaludNodoRepository extends Neo4jRepository<FondoDeSaludNodo, Long> {
    FondoDeSaludNodo findByFdsID(@Param("fdsID") Long userID);
}

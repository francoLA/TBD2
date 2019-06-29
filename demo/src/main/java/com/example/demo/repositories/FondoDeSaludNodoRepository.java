package com.example.demo.repositories;

import com.example.demo.models.FondoDeSaludNodo;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "Fondo", path = "Fondo")
@Repository
public interface FondoDeSaludNodoRepository {
    FondoDeSaludNodo findByFondoId(@Param("userID") Long userID);
}

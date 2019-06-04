package com.example.demo.repositories;

import com.example.demo.models.Cotizacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotizacionRepository extends MongoRepository<Cotizacion, String> {
    Cotizacion findCotizacionById(String id);
}
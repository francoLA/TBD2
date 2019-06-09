package com.example.demo.repositories;

import com.example.demo.models.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotizacionRepository extends JpaRepository<Cotizacion, String> {
    Cotizacion findCotizacionByIdCotizacion(String id);
}
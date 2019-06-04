package com.example.demo.services;

import com.example.demo.models.Cotizacion;
import com.example.demo.repositories.CotizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/cotizacion")
public class CotizacionService {

    @Autowired
    private CotizacionRepository cotizacionRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Cotizacion getCotizacionById(@PathVariable String id){
        return this.cotizacionRepository.findCotizacionById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Cotizacion> getAllCotizacions(){
        return cotizacionRepository.findAll();
    }

}
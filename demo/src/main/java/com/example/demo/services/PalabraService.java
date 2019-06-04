package com.example.demo.services;

import com.example.demo.elasticSearch.SearchRepository;
import com.example.demo.kafka.TwitterKafkaProducer;
import com.example.demo.models.Palabra;
import com.example.demo.repositories.PalabraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.remoting.soap.SoapFaultException;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/palabra")
public class PalabraService {
    @Autowired
    private PalabraRepository palabraRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Palabra> getAllPalabras(){
        return palabraRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Palabra getPalabraById(@PathVariable String id){
        return palabraRepository.findPalabraById(id);
    }

    @RequestMapping(value = "/categoria/{tipo}", method = RequestMethod.GET)
    @ResponseBody
    public List<Palabra> getPalabraByTipo(@PathVariable String tipo){
        return palabraRepository.findPalabraByTipo(tipo);
    }    
}

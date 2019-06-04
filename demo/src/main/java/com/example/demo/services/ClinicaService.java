package com.example.demo.services;

import com.example.demo.models.Clinica;
import com.example.demo.repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clinica")
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @RequestMapping(value = "/{id", method = RequestMethod.GET)
    @ResponseBody
    public Clinica getClinicaById(@PathVariable String id){
        return this.clinicaRepository.findClinicaById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Clinica> getAllClinicas(){
        return clinicaRepository.findAll();
    }

}
package com.example.demo.services;

import com.example.demo.models.Persona;
import com.example.demo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/persona")
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Persona getPersonaByIdPersona(@PathVariable String id){
        return this.personaRepository.findPersonaByIdPersona(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Persona> getAllPersonas(){
        return personaRepository.findAll();
    }

}
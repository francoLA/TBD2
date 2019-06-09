package com.example.demo.services;

import com.example.demo.models.FondoDeSalud;
import com.example.demo.repositories.FondoDeSaludRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/fondoDeSalud")
public class FondoDeSaludService {

    @Autowired
    private FondoDeSaludRepository fondoDeSaludRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FondoDeSalud getFondoDeSaludByIdFondo(@PathVariable String id){
        return this.fondoDeSaludRepository.findFondoDeSaludByIdFondo(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<FondoDeSalud> getAllFondosDeSalud(){
        return fondoDeSaludRepository.findAll();
    }

}
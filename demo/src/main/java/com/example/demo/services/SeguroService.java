package com.example.demo.services;

import com.example.demo.models.Seguro;
import com.example.demo.repositories.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/seguro")
public class SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Seguro getSeguroByIdSeguro(@PathVariable String id){
        return this.seguroRepository.findSeguroByIdSeguro(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Seguro> getAllSeguros(){
        return seguroRepository.findAll();
    }

}
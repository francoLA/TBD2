package com.example.demo.services;

import com.example.demo.models.Isapre;
import com.example.demo.repositories.IsapreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/isapre")
public class IsapreService {

    @Autowired
    private IsapreRepository isapreRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Isapre getIsapreById(@PathVariable String id){
        return this.isapreRepository.findIsapreById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Isapre> getAllIsapres(){
        return isapreRepository.findAll();
    }

}
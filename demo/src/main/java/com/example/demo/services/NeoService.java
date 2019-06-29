package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserNodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/neo")
public class NeoService {

    @Autowired
    UserNodoRepository userRepository;


}

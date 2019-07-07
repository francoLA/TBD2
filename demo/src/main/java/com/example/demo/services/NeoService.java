package com.example.demo.services;

import com.example.demo.models.FondoDeSalud;
import com.example.demo.models.FondoDeSaludNodo;
import com.example.demo.models.User;
import com.example.demo.models.UserNodo;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/neo")
public class NeoService {

    private String uri = "bolt://localhost";
    private String user = "neo4j";
    private String password = "password";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserNodoRepository userNodoRepository;

    @Autowired
    private FondoDeSaludNodoRepository fondoDeSaludNodoRepository;

    @Autowired
    private FondoDeSaludRepository fondoDeSaludRepository;

    @Autowired
    private TwittRepository twittRepository;

    //@Autowired
    //private Twitter twitter;

    //carga de usuarios
    @RequestMapping(value = "/loadUsers", method = RequestMethod.GET)
    @ResponseBody
    public void loadUsers(){
        List<User> users = userRepository.findAll();
        for (int i = 0; i < users.size(); i++){
            User u = users.get(i);
            UserNodo user = new UserNodo(u.getName(), u.getFollowersCount(), u.getId());
            userNodoRepository.save(user);
        }
    }

    //carga de fondos de salud
    @RequestMapping(value = "/loadFondos", method = RequestMethod.GET)
    @ResponseBody
    public void loadFondos(){
        List<FondoDeSalud> fondos = fondoDeSaludRepository.findAll();
        for (int i = 0; i < fondos.size(); i++){
            FondoDeSalud f = fondos.get(i);
            FondoDeSaludNodo fondo = new FondoDeSaludNodo(f.getIdFondo(), f.getNombre());
            fondoDeSaludNodoRepository.save(fondo);
        }
    }
}

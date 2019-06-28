package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserService {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public Collection<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
}

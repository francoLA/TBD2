package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserNodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/user")
public class UserService {

    @Autowired
    UserNodoRepository userRepository;

}

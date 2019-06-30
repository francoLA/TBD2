package com.example.demo.services;

import com.example.demo.models.Twitt;
import com.example.demo.models.User;
import com.example.demo.repositories.TwittRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TwittRepository twittRepository;

    @RequestMapping(value = "/loadUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> loadUsers(){

        List<Twitt> twitts;
        twitts = twittRepository.findAll();

        for (Twitt twitt:twitts
             ) {
            User aux = twitt.getUser();
            User newUser = new User(aux.getId(), aux.getName(), aux.getScreenName(), aux.getLocation(), aux.getFollowersCount());
            userRepository.save(newUser);
        }

        return userRepository.findAll();
    }

}

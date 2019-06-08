package com.example.demo.services;

import com.example.demo.models.Twitt;
import com.example.demo.repositories.SearchRepository;
import com.example.demo.repositories.TwittRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elastic")
public class SearchService {

    @Autowired
    SearchRepository searchRepository;

    @Autowired
    TwittRepository twittRepository;

    @GetMapping(value = "/delete")
    public void deleteAll(){
        searchRepository.deleteAll();
    }

    @GetMapping(value = "/update")
    public Iterable<Twitt> update(){
        List<Twitt> list = twittRepository.findAll();
        for (Twitt tweet:list
             ) {
            searchRepository.save(tweet);
        }
        return searchRepository.findAll();
    }

    @GetMapping(value = "/getAll")
    public Iterable<Twitt> getAll(){

        return searchRepository.findAll();
    }

    @GetMapping(value = "/content/{text}")
    public List<Twitt> searchByContent(@PathVariable final String text){
        return searchRepository.findByText(text);
    }

    @GetMapping(value = "/user/name/{text}")
    public Iterable<Twitt> searchByUserName(@PathVariable final String text){
        return searchRepository.findByUserName(text);
    }
}

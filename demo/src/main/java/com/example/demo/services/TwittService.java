package com.example.demo.services;

import com.example.demo.kafka.TwitterKafkaConsumer;
import com.example.demo.kafka.TwitterListener;
import com.example.demo.models.Palabra;
import com.example.demo.models.Twitt;
import com.example.demo.repositories.PalabraRepository;
import com.example.demo.repositories.TwittRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/twitt")
public class TwittService {

    @Autowired
    private TwittRepository twittRepository;

    @Autowired
    private TwitterListener twitterListener;

    @Autowired
    private TwitterKafkaConsumer twitterKafkaConsumer;

    @Autowired
    private PalabraRepository palabraRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Twitt getTwittById(@PathVariable String id){
        return this.twittRepository.findTweetById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Twitt> getAllTwitts(){
        return twittRepository.findAll();
    }




    @RequestMapping(value = "/startKafka", method = RequestMethod.GET)
    @ResponseBody
    public void start(){

        List<String> hashtags = new ArrayList<>();

        List<Palabra> palabras = this.palabraRepository.findAll();

        for (Palabra p:palabras
             ) {
            hashtags.add(p.getTexto());
            System.out.println(p.getTexto());
        }

        twitterListener.run(hashtags);
        twitterKafkaConsumer.run();
    }

    @RequestMapping(value = "/stopKafka", method = RequestMethod.GET)
    public List<Twitt> stop(){
        this.twitterKafkaConsumer.stop();
        return twittRepository.findAll();
    }

}

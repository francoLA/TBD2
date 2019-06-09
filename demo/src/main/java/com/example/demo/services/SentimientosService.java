package com.example.demo.services;

import com.example.demo.models.FondoDeSalud;
import com.example.demo.models.Twitt;
import com.example.demo.repositories.FondoDeSaludRepository;
import com.example.demo.repositories.SearchRepository;
import com.example.demo.sentimiento.Clasificar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sentimientos")
public class SentimientosService {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private Clasificar clasificar;

    @Autowired
    private FondoDeSaludRepository fondoDeSaludRepository;

    @RequestMapping(value = "/{text}/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void tweetSentiment(@PathVariable final String text, @PathVariable final String id){
        List<Twitt> tweetList = searchRepository.findByText(text);
        int positive = 0;
        int negative = 0;
        for(int i = 0 ; i < tweetList.size();i++) {
            Twitt tweet = tweetList.get(i);
            boolean typeOfTweet = clasificar.classify(tweet.getText());
            if(typeOfTweet){ positive++; }
            else { negative++; }
        }
        FondoDeSalud current = this.fondoDeSaludRepository.findFondoDeSaludByIdFondo(id);
        current.setAprobacion(positive);
        current.setDesaprobacion(negative);
        current.setCantidadAfiliados(negative + positive);
        this.fondoDeSaludRepository.save(current);
        System.out.println("\nPositivo = "+positive);
        System.out.println("\nNegativo = "+negative);
    }
}

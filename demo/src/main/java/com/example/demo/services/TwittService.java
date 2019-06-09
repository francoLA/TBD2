package com.example.demo.services;

import com.example.demo.kafka.TwitterKafkaConsumer;
import com.example.demo.kafka.TwitterListener;
import com.example.demo.models.Twitt;
import com.example.demo.models.FondoDeSalud;
import com.example.demo.models.Palabra;
import com.example.demo.repositories.FondoDeSaludRepository;
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

    @Autowired
    private FondoDeSaludRepository fondoDeSaludRepository;

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
        }

        twitterListener.run(hashtags);
        twitterKafkaConsumer.run();
    }

    @RequestMapping(value = "/stopKafka", method = RequestMethod.GET)
    public List<Twitt> stop(){
        this.twitterKafkaConsumer.stop();
        return twittRepository.findAll();
    }

    @RequestMapping(value = "/actualizarCantidadAfiliados", method = RequestMethod.GET)
    @ResponseBody
    public void actualizarCantidadAfiliados(){
        int i,j,k, cantidadAfiliados;
        List<Twitt> tweets = twittRepository.findAll();
        List<FondoDeSalud> fondos = fondoDeSaludRepository.findAll();
        List<Palabra> palabras;
        FondoDeSalud fondoActual;
        for(i=0;i<fondos.size();i++){fondos.get(i).setCantidadAfiliados(0);}

        for(i=0;i<tweets.size();i++){
            for(k=0;k<fondos.size();k++){
                fondoActual = fondos.get(k);
                palabras = palabraRepository.findPalabrasByTipo(fondoActual.getNombre());
                for(j=0;j<palabras.size();j++){
                    if(tweets.get(i).getText().contains(palabras.get(j).getTexto())){
                        cantidadAfiliados = fondoActual.getCantidadAfiliados();
                        fondoActual.setCantidadAfiliados(cantidadAfiliados++);
                        break;
                    }
                }
            }
        }
    }
}

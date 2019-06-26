package com.example.demo.services;

import com.example.demo.kafka.TwitterKafkaConsumer;
import com.example.demo.kafka.TwitterListener;
import com.example.demo.models.Palabra;
import com.example.demo.models.Twitt;
import com.example.demo.models.Palabra;
import com.example.demo.repositories.PalabraRepository;
import com.example.demo.repositories.TwittRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        }

        twitterListener.run(hashtags);
        twitterKafkaConsumer.run();
    }

    @RequestMapping(value = "/stopKafka", method = RequestMethod.GET)
    public List<Twitt> stop(){
        this.twitterKafkaConsumer.stop();
        return twittRepository.findAll();
    }

    @RequestMapping(value = "/cantidadAfiliados", method = RequestMethod.GET)
    @ResponseBody
    public List<Integer> cantidadAfiliados(){
        int i,j, nuevaCantidad;
        List<Integer> cantidades = new ArrayList<>();
        for(i=0;i<13;i++){
            cantidades.add(0);
        }
        List<Twitt> tweets = twittRepository.findAll();
        List<Palabra> palabras = palabraRepository.findAll();
        List<Palabra> Fonasa = new ArrayList<>();
        List<Palabra> Colmena = new ArrayList<>();
        List<Palabra> CruzBlanca = new ArrayList<>();
        List<Palabra> Consalud = new ArrayList<>();
        List<Palabra> VidaTres = new ArrayList<>();
        List<Palabra> NuevaMasVida = new ArrayList<>();
        List<Palabra> Banmédica = new ArrayList<>();
        List<Palabra> Chuquicamata = new ArrayList<>();
        List<Palabra> CruzDelNorte = new ArrayList<>();
        List<Palabra> Fundación = new ArrayList<>();
        List<Palabra> Fusat = new ArrayList<>();
        List<Palabra> RíoBlanco = new ArrayList<>();
        List<Palabra> SanLorenzo = new ArrayList<>();
        Palabra actual;
        for(i=0;i<palabras.size();i++){
            actual = palabras.get(i);
                 if(actual.getTipo() == "Fonasa"){
                Fonasa.add(actual);
            }
            else if(actual.getTipo() == "Colmena"){
                Colmena.add(actual);
            }
            else if(actual.getTipo() == "CruzBlanca"){
                CruzBlanca.add(actual);
            }
            else if(actual.getTipo() == "Consalud"){
                Consalud.add(actual);
            }
            else if(actual.getTipo() == "VidaTres"){
                VidaTres.add(actual);
            }
            else if(actual.getTipo() == "NuevaMasVida"){
                NuevaMasVida.add(actual);
            }
            else if(actual.getTipo() == "Banmédica"){
                Banmédica.add(actual);
            }
            else if(actual.getTipo() == "Chuquicamata"){
                Chuquicamata.add(actual);
            }
            else if(actual.getTipo() == "CruzDelNorte"){
                CruzDelNorte.add(actual);
            }
            else if(actual.getTipo() == "Fundación"){
                Fundación.add(actual);
            }
            else if(actual.getTipo() == "Fusat"){
                Fusat.add(actual);
            }
            else if(actual.getTipo() == "RíoBlanco"){
                RíoBlanco.add(actual);
            }
            else if(actual.getTipo() == "SanLorenzo"){
                SanLorenzo.add(actual);
            }
        }
        for(i=0;i<tweets.size();i++){
            for(j=0;j<Fonasa.size();j++){
                actual = Fonasa.get(j);
                if(tweets.get(i).getText().contains(Fonasa.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(0);
                    nuevaCantidad++;
                    cantidades.set(0,nuevaCantidad);
                }
            }
            for(j=0;j<Colmena.size();j++){
                actual = Colmena.get(j);
                if(tweets.get(i).getText().contains(Colmena.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(1);
                    nuevaCantidad++;
                    cantidades.set(1,nuevaCantidad);
                }
            }
            for(j=0;j<CruzBlanca.size();j++){
                actual = CruzBlanca.get(j);
                if(tweets.get(i).getText().contains(CruzBlanca.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(2);
                    nuevaCantidad++;
                    cantidades.set(2,nuevaCantidad);
                }
            }
            for(j=0;j<Consalud.size();j++){
                actual = Consalud.get(j);
                if(tweets.get(i).getText().contains(Consalud.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(3);
                    nuevaCantidad++;
                    cantidades.set(3,nuevaCantidad);
                }
            }
            for(j=0;j<VidaTres.size();j++){
                actual = VidaTres.get(j);
                if(tweets.get(i).getText().contains(VidaTres.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(4);
                    nuevaCantidad++;
                    cantidades.set(4,nuevaCantidad);
                }
            }
            for(j=0;j<NuevaMasVida.size();j++){
                actual = NuevaMasVida.get(j);
                if(tweets.get(i).getText().contains(NuevaMasVida.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(5);
                    nuevaCantidad++;
                    cantidades.set(5,nuevaCantidad);
                }
            }
            for(j=0;j<Banmédica.size();j++){
                actual = Banmédica.get(j);
                if(tweets.get(i).getText().contains(Banmédica.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(6);
                    nuevaCantidad++;
                    cantidades.set(6,nuevaCantidad);
                }
            }
            for(j=0;j<Chuquicamata.size();j++){
                actual = Chuquicamata.get(j);
                if(tweets.get(i).getText().contains(Chuquicamata.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(7);
                    nuevaCantidad++;
                    cantidades.set(7,nuevaCantidad);
                }
            }
            for(j=0;j<CruzDelNorte.size();j++){
                actual = CruzDelNorte.get(j);
                if(tweets.get(i).getText().contains(CruzDelNorte.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(8);
                    nuevaCantidad++;
                    cantidades.set(8,nuevaCantidad);
                }
            }
            for(j=0;j<Fundación.size();j++){
                actual = Fundación.get(j);
                if(tweets.get(i).getText().contains(Fundación.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(9);
                    nuevaCantidad++;
                    cantidades.set(9,nuevaCantidad);
                }
            }
            for(j=0;j<Fusat.size();j++){
                actual = Fusat.get(j);
                if(tweets.get(i).getText().contains(Fusat.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(10);
                    nuevaCantidad++;
                    cantidades.set(10,nuevaCantidad);
                }
            }
            for(j=0;j<RíoBlanco.size();j++){
                actual = RíoBlanco.get(j);
                if(tweets.get(i).getText().contains(RíoBlanco.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(11);
                    nuevaCantidad++;
                    cantidades.set(11,nuevaCantidad);
                }
            }
            for(j=0;j<SanLorenzo.size();j++){
                actual = SanLorenzo.get(j);
                if(tweets.get(i).getText().contains(SanLorenzo.get(j).getTexto())){
                    nuevaCantidad = cantidades.get(12);
                    nuevaCantidad++;
                    cantidades.set(12,nuevaCantidad);
                }
            }
        }
        return cantidades;
    }

    @RequestMapping(value = "/topInfluencia", method = RequestMethod.GET)
    @ResponseBody
    public List<Twitt> topInfluencia(){
        List<Twitt> tweets = twittRepository.findAll();
        List<Twitt> topTweets = new ArrayList<Twitt>();
        //Bubblesort
        Twitt temp;
        int remaining = tweets.size()-1;
        for(int i=0; i<tweets.size();i++){
            for(int j=0;j<remaining;j++){
                if(tweets.get(j).getInfluence() > tweets.get(j+1).getInfluence()){
                    temp = tweets.get(j+1);
                    tweets.set(j+1,tweets.get(j));
                    tweets.set(j,temp);
                }
            }
            remaining--;
        }
        for(int i=0;i<5;i++){
            topTweets.add(tweets.get(i));
        }
        return topTweets;
    }
}
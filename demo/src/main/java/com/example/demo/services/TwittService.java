package com.example.demo.services;

import com.example.demo.kafka.TwitterKafkaConsumer;
import com.example.demo.kafka.TwitterListener;
import com.example.demo.models.Palabra;
import com.example.demo.models.Twitt;
import com.example.demo.models.Palabra;
import com.example.demo.services.SearchService;
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

    @Autowired
    private SearchService searchService;

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

    @RequestMapping(value = "/getTopFonasa", method = RequestMethod.GET)
    @ResponseBody
    public List<Twitt> getTopFonasa(){
        List<Twitt> topTweets = new ArrayList<Twitt>();
        List<Twitt> tweetsFonasa = searchService.searchByContent("Fonasa");
        List<Twitt> tweetsfonasa = searchService.searchByContent("fonasa");
        tweetsFonasa.addAll(tweetsfonasa);
        Twitt tweet = tweetsFonasa.get(0);
        int seguidores = tweetsFonasa.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsFonasa.size();j++){
                if(seguidores < tweetsFonasa.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsFonasa.get(j).getUser().getFollowersCount();
                    tweet = tweetsFonasa.get(j);
                }
            }
            topTweets.add(tweet);
            tweetsFonasa.remove(tweet);
        }
        return topTweets;
    } 

    @RequestMapping(value = "/getTopIsapre", method = RequestMethod.GET)
    @ResponseBody
    public List<Twitt> getTopIsapre(){
        List<Twitt> topTweets = new ArrayList<Twitt>();
        List<Twitt> tweetsIsapre = searchService.searchByContent("Isapre");
        List<Twitt> tweetsisapre = searchService.searchByContent("isapre");
        tweetsIsapre.addAll(tweetsisapre);
        Twitt tweet = tweetsIsapre.get(0);
        int seguidores = tweetsIsapre.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsIsapre.size();j++){
                if(seguidores < tweetsIsapre.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsIsapre.get(j).getUser().getFollowersCount();
                    tweet = tweetsIsapre.get(j);
                }
            }
            topTweets.add(tweet);
            tweetsIsapre.remove(tweet);
        }
        return topTweets;
    }

    @RequestMapping(value = "/getTopPorCadaIsapre", method = RequestMethod.GET)
    @ResponseBody
    public List<List<Twitt>> getTopPorCadaIsapre(){
        List<List<Twitt>> topTweets = new ArrayList<List<Twitt>>();
        Twitt tweet;
        int seguidores;
        //Fundación
        List<Twitt> topTweetsFundacion = new ArrayList<Twitt>();
        List<Twitt> tweetsFundacion = searchService.searchByContent("IsapreFundación");
        List<Twitt> tweetsFundacion1 = searchService.searchByContent("IsapreFundacion");
        List<Twitt> tweetsFundacion2 = searchService.searchByContent("Isaprefundación");
        List<Twitt> tweetsFundacion3 = searchService.searchByContent("Isaprefundacion");
        List<Twitt> tweetsFundacion4 = searchService.searchByContent("IsapreFundasión");
        List<Twitt> tweetsFundacion5 = searchService.searchByContent("IsapreFundasion");
        List<Twitt> tweetsFundacion6 = searchService.searchByContent("Isaprefundasión");
        List<Twitt> tweetsFundacion7 = searchService.searchByContent("Isaprefundasion");
        tweetsFundacion.addAll(tweetsFundacion1);
        tweetsFundacion.addAll(tweetsFundacion2);
        tweetsFundacion.addAll(tweetsFundacion3);
        tweetsFundacion.addAll(tweetsFundacion4);
        tweetsFundacion.addAll(tweetsFundacion5);
        tweetsFundacion.addAll(tweetsFundacion6);
        tweetsFundacion.addAll(tweetsFundacion7);
        
        tweet = tweetsFundacion.get(0);
        seguidores = tweetsFundacion.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsFundacion.size();j++){
                if(seguidores < tweetsFundacion.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsFundacion.get(j).getUser().getFollowersCount();
                    tweet = tweetsFundacion.get(j);
                }
            }
            topTweetsFundacion.add(tweet);
            tweetsFundacion.remove(tweet);
        }
        topTweets.add(topTweetsFundacion);

        //Fusat
        List<Twitt> topTweetsFusat = new ArrayList<Twitt>();
        List<Twitt> tweetsFusat = searchService.searchByContent("IsapreFusat");
        List<Twitt> tweetsFusat1 = searchService.searchByContent("Isaprefusat");
        List<Twitt> tweetsFusat2 = searchService.searchByContent("isapreFusat");
        List<Twitt> tweetsFusat3 = searchService.searchByContent("isaprefusat");
        List<Twitt> tweetsFusat4 = searchService.searchByContent("Fusat");
        List<Twitt> tweetsFusat5 = searchService.searchByContent("fusat");
        tweetsFundacion.addAll(tweetsFusat1);
        tweetsFundacion.addAll(tweetsFusat2);
        tweetsFundacion.addAll(tweetsFusat3);
        tweetsFundacion.addAll(tweetsFusat4);
        tweetsFundacion.addAll(tweetsFusat5);
        
        tweet = tweetsFusat.get(0);
        seguidores = tweetsFusat.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsFusat.size();j++){
                if(seguidores < tweetsFusat.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsFusat.get(j).getUser().getFollowersCount();
                    tweet = tweetsFusat.get(j);
                }
            }
            topTweetsFusat.add(tweet);
            tweetsFusat.remove(tweet);
        }
        topTweets.add(topTweetsFusat);

        //Rio Blanco
        List<Twitt> topTweetsRioBlanco = new ArrayList<Twitt>();
        List<Twitt> tweetsRioBlanco = searchService.searchByContent("IsapreRíoBlanco");
        List<Twitt> tweetsRioBlanco1 = searchService.searchByContent("IsapreRioBlanco");
        List<Twitt> tweetsRioBlanco2 = searchService.searchByContent("IsapreRíoblanco");
        List<Twitt> tweetsRioBlanco3 = searchService.searchByContent("IsapreRioblanco");
        List<Twitt> tweetsRioBlanco4 = searchService.searchByContent("Isapreríoblanco");
        List<Twitt> tweetsRioBlanco5 = searchService.searchByContent("Isaprerioblanco");
        List<Twitt> tweetsRioBlanco6 = searchService.searchByContent("isapreRíoBlanco");
        List<Twitt> tweetsRioBlanco7 = searchService.searchByContent("isapreRioBlanco");
        List<Twitt> tweetsRioBlanco8 = searchService.searchByContent("isapreRíoblanco");
        List<Twitt> tweetsRioBlanco9 = searchService.searchByContent("isapreRioblanco");
        List<Twitt> tweetsRioBlanco10 = searchService.searchByContent("isapreríoblanco");
        List<Twitt> tweetsRioBlanco11 = searchService.searchByContent("isaprerioblanco");
        tweetsRioBlanco.addAll(tweetsRioBlanco1);
        tweetsRioBlanco.addAll(tweetsRioBlanco2);
        tweetsRioBlanco.addAll(tweetsRioBlanco3);
        tweetsRioBlanco.addAll(tweetsRioBlanco4);
        tweetsRioBlanco.addAll(tweetsRioBlanco5);
        tweetsRioBlanco.addAll(tweetsRioBlanco6);
        tweetsRioBlanco.addAll(tweetsRioBlanco7);
        tweetsRioBlanco.addAll(tweetsRioBlanco8);
        tweetsRioBlanco.addAll(tweetsRioBlanco9);
        tweetsRioBlanco.addAll(tweetsRioBlanco10);
        tweetsRioBlanco.addAll(tweetsRioBlanco11);
        
        tweet = tweetsRioBlanco.get(0);
        seguidores = tweetsRioBlanco.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsRioBlanco.size();j++){
                if(seguidores < tweetsRioBlanco.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsRioBlanco.get(j).getUser().getFollowersCount();
                    tweet = tweetsRioBlanco.get(j);
                }
            }
            topTweetsRioBlanco.add(tweet);
            tweetsRioBlanco.remove(tweet);
        }
        topTweets.add(topTweetsRioBlanco);

        //San Lorenzo
        List<Twitt> topTweetsSanLorenzo = new ArrayList<Twitt>();
        List<Twitt> tweetsSanLorenzo = searchService.searchByContent("IsapreSanLorenzo");
        List<Twitt> tweetsSanLorenzo1 = searchService.searchByContent("IsapreSanLorenso");
        List<Twitt> tweetsSanLorenzo2 = searchService.searchByContent("Isapresanlorenzo");
        List<Twitt> tweetsSanLorenzo3 = searchService.searchByContent("isapreSanLorenzo");
        List<Twitt> tweetsSanLorenzo4 = searchService.searchByContent("isapreSanLorenso");
        List<Twitt> tweetsSanLorenzo5 = searchService.searchByContent("isapresanlorenzo");
        tweetsSanLorenzo.addAll(tweetsSanLorenzo1);
        tweetsSanLorenzo.addAll(tweetsSanLorenzo2);
        tweetsSanLorenzo.addAll(tweetsSanLorenzo3);
        tweetsSanLorenzo.addAll(tweetsSanLorenzo4);
        tweetsSanLorenzo.addAll(tweetsSanLorenzo5);
        
        tweet = tweetsSanLorenzo.get(0);
        seguidores = tweetsSanLorenzo.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsSanLorenzo.size();j++){
                if(seguidores < tweetsSanLorenzo.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsSanLorenzo.get(j).getUser().getFollowersCount();
                    tweet = tweetsSanLorenzo.get(j);
                }
            }
            topTweetsSanLorenzo.add(tweet);
            tweetsSanLorenzo.remove(tweet);
        }
        topTweets.add(topTweetsSanLorenzo);

        //Colmena
        List<Twitt> topTweetsColmena = new ArrayList<Twitt>();
        List<Twitt> tweetsColmena = searchService.searchByContent("IsapreColmena");
        List<Twitt> tweetsColmena1 = searchService.searchByContent("Isaprecolmena");
        List<Twitt> tweetsColmena2 = searchService.searchByContent("isapreColmena");
        List<Twitt> tweetsColmena3 = searchService.searchByContent("isaprecolmena");
        tweetsColmena.addAll(tweetsColmena1);
        tweetsColmena.addAll(tweetsColmena2);
        tweetsColmena.addAll(tweetsColmena3);
        
        tweet = tweetsColmena.get(0);
        seguidores = tweetsColmena.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsColmena.size();j++){
                if(seguidores < tweetsColmena.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsColmena.get(j).getUser().getFollowersCount();
                    tweet = tweetsColmena.get(j);
                }
            }
            topTweetsColmena.add(tweet);
            tweetsColmena.remove(tweet);
        }
        topTweets.add(topTweetsColmena);
        
        //Cruz Blanca
        List<Twitt> topTweetsCruzBlanca = new ArrayList<Twitt>();
        List<Twitt> tweetsCruzBlanca = searchService.searchByContent("IsapreCruzBlanca");
        List<Twitt> tweetsCruzBlanca1 = searchService.searchByContent("IsapreCrusBlanca");
        List<Twitt> tweetsCruzBlanca2 = searchService.searchByContent("isapreCruzBlanca");
        List<Twitt> tweetsCruzBlanca3 = searchService.searchByContent("isapreCrusBlanca");
        List<Twitt> tweetsCruzBlanca4 = searchService.searchByContent("Isaprecruzblanca");
        List<Twitt> tweetsCruzBlanca5 = searchService.searchByContent("isaprecruzblanca");
        tweetsCruzBlanca.addAll(tweetsCruzBlanca1);
        tweetsCruzBlanca.addAll(tweetsCruzBlanca2);
        tweetsCruzBlanca.addAll(tweetsCruzBlanca3);
        tweetsCruzBlanca.addAll(tweetsCruzBlanca4);
        tweetsCruzBlanca.addAll(tweetsCruzBlanca5);
        
        tweet = tweetsCruzBlanca.get(0);
        seguidores = tweetsCruzBlanca.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsCruzBlanca.size();j++){
                if(seguidores < tweetsCruzBlanca.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsCruzBlanca.get(j).getUser().getFollowersCount();
                    tweet = tweetsCruzBlanca.get(j);
                }
            }
            topTweetsCruzBlanca.add(tweet);
            tweetsCruzBlanca.remove(tweet);
        }
        topTweets.add(topTweetsCruzBlanca);
        
        //Consalud
        List<Twitt> topTweetsConsalud = new ArrayList<Twitt>();
        List<Twitt> tweetsConsalud = searchService.searchByContent("IsapreConsalud");
        List<Twitt> tweetsConsalud1 = searchService.searchByContent("Isapreconsalud");
        List<Twitt> tweetsConsalud2 = searchService.searchByContent("isapreconsalud");
        List<Twitt> tweetsConsalud3 = searchService.searchByContent("Consalud");
        List<Twitt> tweetsConsalud4 = searchService.searchByContent("consalud");
        tweetsConsalud.addAll(tweetsConsalud1);
        tweetsConsalud.addAll(tweetsConsalud2);
        tweetsConsalud.addAll(tweetsConsalud3);
        tweetsConsalud.addAll(tweetsConsalud4);
        
        tweet = tweetsConsalud.get(0);
        seguidores = tweetsConsalud.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsConsalud.size();j++){
                if(seguidores < tweetsConsalud.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsConsalud.get(j).getUser().getFollowersCount();
                    tweet = tweetsConsalud.get(j);
                }
            }
            topTweetsConsalud.add(tweet);
            tweetsConsalud.remove(tweet);
        }
        topTweets.add(topTweetsConsalud);
        
        //Vida Tres
        List<Twitt> topTweetsVidaTres = new ArrayList<Twitt>();
        List<Twitt> tweetsVidaTres = searchService.searchByContent("IsapreVidaTres");
        List<Twitt> tweetsVidaTres1 = searchService.searchByContent("isapreVidaTres");
        List<Twitt> tweetsVidaTres2 = searchService.searchByContent("Isaprevidatres");
        List<Twitt> tweetsVidaTres3 = searchService.searchByContent("isaprevidatres");
        List<Twitt> tweetsVidaTres4 = searchService.searchByContent("VidaTres");
        List<Twitt> tweetsVidaTres5 = searchService.searchByContent("Vidatres");
        List<Twitt> tweetsVidaTres6 = searchService.searchByContent("vidatres");
        List<Twitt> tweetsVidaTres7 = searchService.searchByContent("vidaTres");
        tweetsVidaTres.addAll(tweetsVidaTres1);
        tweetsVidaTres.addAll(tweetsVidaTres2);
        tweetsVidaTres.addAll(tweetsVidaTres3);
        tweetsVidaTres.addAll(tweetsVidaTres4);
        tweetsVidaTres.addAll(tweetsVidaTres5);
        tweetsVidaTres.addAll(tweetsVidaTres6);
        tweetsVidaTres.addAll(tweetsVidaTres7);
        
        tweet = tweetsVidaTres.get(0);
        seguidores = tweetsVidaTres.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsVidaTres.size();j++){
                if(seguidores < tweetsVidaTres.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsVidaTres.get(j).getUser().getFollowersCount();
                    tweet = tweetsVidaTres.get(j);
                }
            }
            topTweetsVidaTres.add(tweet);
            tweetsVidaTres.remove(tweet);
        }
        topTweets.add(topTweetsVidaTres);
        
        //Nueva Mas Vida
        List<Twitt> topTweetsNuevaMasVida = new ArrayList<Twitt>();
        List<Twitt> tweetsNuevaMasVida = searchService.searchByContent("IsapreNuevaMasVida");
        List<Twitt> tweetsNuevaMasVida1 = searchService.searchByContent("Isaprenuevamasvida");
        List<Twitt> tweetsNuevaMasVida2 = searchService.searchByContent("isapreNuevaMasVida");
        List<Twitt> tweetsNuevaMasVida3 = searchService.searchByContent("isaprenuevamasvida");
        List<Twitt> tweetsNuevaMasVida4 = searchService.searchByContent("IsapreNuevaMásVida");
        List<Twitt> tweetsNuevaMasVida5 = searchService.searchByContent("isapreNuevaMásVida");        
        tweetsNuevaMasVida.addAll(tweetsNuevaMasVida1);
        tweetsNuevaMasVida.addAll(tweetsNuevaMasVida2);
        tweetsNuevaMasVida.addAll(tweetsNuevaMasVida3);
        tweetsNuevaMasVida.addAll(tweetsNuevaMasVida4);
        tweetsNuevaMasVida.addAll(tweetsNuevaMasVida5);
        
        tweet = tweetsNuevaMasVida.get(0);
        seguidores = tweetsNuevaMasVida.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsNuevaMasVida.size();j++){
                if(seguidores < tweetsNuevaMasVida.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsNuevaMasVida.get(j).getUser().getFollowersCount();
                    tweet = tweetsNuevaMasVida.get(j);
                }
            }
            topTweetsNuevaMasVida.add(tweet);
            tweetsNuevaMasVida.remove(tweet);
        }
        topTweets.add(topTweetsNuevaMasVida);
        
        //Banmedica
        List<Twitt> topTweetsBanmedica = new ArrayList<Twitt>();
        List<Twitt> tweetsBanmedica = searchService.searchByContent("IsapreBanmédica");
        List<Twitt> tweetsBanmedica1 = searchService.searchByContent("IsapreBanmedica");
        List<Twitt> tweetsBanmedica2 = searchService.searchByContent("isapreBanmédica");
        List<Twitt> tweetsBanmedica3 = searchService.searchByContent("isapreBanmedica");
        List<Twitt> tweetsBanmedica4 = searchService.searchByContent("Isaprebanmédica");
        List<Twitt> tweetsBanmedica5 = searchService.searchByContent("Isaprebanmedica");
        List<Twitt> tweetsBanmedica6 = searchService.searchByContent("Banmédica");
        List<Twitt> tweetsBanmedica7 = searchService.searchByContent("banmédica");
        List<Twitt> tweetsBanmedica8 = searchService.searchByContent("Banmedica");
        List<Twitt> tweetsBanmedica9 = searchService.searchByContent("banmedica");
        tweetsBanmedica.addAll(tweetsBanmedica1);
        tweetsBanmedica.addAll(tweetsBanmedica2);
        tweetsBanmedica.addAll(tweetsBanmedica3);
        tweetsBanmedica.addAll(tweetsBanmedica4);
        tweetsBanmedica.addAll(tweetsBanmedica5);
        tweetsBanmedica.addAll(tweetsBanmedica6);
        tweetsBanmedica.addAll(tweetsBanmedica7);
        tweetsBanmedica.addAll(tweetsBanmedica8);
        tweetsBanmedica.addAll(tweetsBanmedica9);
        
        tweet = tweetsBanmedica.get(0);
        seguidores = tweetsBanmedica.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsBanmedica.size();j++){
                if(seguidores < tweetsBanmedica.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsBanmedica.get(j).getUser().getFollowersCount();
                    tweet = tweetsBanmedica.get(j);
                }
            }
            topTweetsBanmedica.add(tweet);
            tweetsBanmedica.remove(tweet);
        }
        topTweets.add(topTweetsBanmedica);
        
        //Chuquicamata
        List<Twitt> topTweetsChuquicamata = new ArrayList<Twitt>();
        List<Twitt> tweetsChuquicamata = searchService.searchByContent("IsapreChuquicamata");
        List<Twitt> tweetsChuquicamata1 = searchService.searchByContent("isapreChuquicamata");
        List<Twitt> tweetsChuquicamata2 = searchService.searchByContent("Isaprechuquicamata");
        List<Twitt> tweetsChuquicamata3 = searchService.searchByContent("isaprechuquicamata");
        tweetsChuquicamata.addAll(tweetsChuquicamata1);
        tweetsChuquicamata.addAll(tweetsChuquicamata2);
        tweetsChuquicamata.addAll(tweetsChuquicamata3);
        
        tweet = tweetsChuquicamata.get(0);
        seguidores = tweetsChuquicamata.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsChuquicamata.size();j++){
                if(seguidores < tweetsChuquicamata.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsChuquicamata.get(j).getUser().getFollowersCount();
                    tweet = tweetsChuquicamata.get(j);
                }
            }
            topTweetsChuquicamata.add(tweet);
            tweetsChuquicamata.remove(tweet);
        }
        topTweets.add(topTweetsChuquicamata);
        
        //Cruz del Norte
        List<Twitt> topTweetsCruzDelNorte = new ArrayList<Twitt>();
        List<Twitt> tweetsCruzDelNorte = searchService.searchByContent("IsapreCruzDelNorte");
        List<Twitt> tweetsCruzDelNorte1 = searchService.searchByContent("isapreCruzDelNorte");
        List<Twitt> tweetsCruzDelNorte2 = searchService.searchByContent("IsapreCrusDelNorte");
        List<Twitt> tweetsCruzDelNorte3 = searchService.searchByContent("isapreCrusdelNorte");
        List<Twitt> tweetsCruzDelNorte4 = searchService.searchByContent("IsapreCruzNorte");
        List<Twitt> tweetsCruzDelNorte5 = searchService.searchByContent("isapreCruzNorte");
        tweetsCruzDelNorte.addAll(tweetsCruzDelNorte1);
        tweetsCruzDelNorte.addAll(tweetsCruzDelNorte2);
        tweetsCruzDelNorte.addAll(tweetsCruzDelNorte3);
        tweetsCruzDelNorte.addAll(tweetsCruzDelNorte4);
        tweetsCruzDelNorte.addAll(tweetsCruzDelNorte5);
        
        tweet = tweetsCruzDelNorte.get(0);
        seguidores = tweetsCruzDelNorte.get(0).getUser().getFollowersCount();
        for(int i=0;i<5;i++){
            for(int j=0;j<tweetsCruzDelNorte.size();j++){
                if(seguidores < tweetsCruzDelNorte.get(j).getUser().getFollowersCount()){
                    seguidores = tweetsCruzDelNorte.get(j).getUser().getFollowersCount();
                    tweet = tweetsCruzDelNorte.get(j);
                }
            }
            topTweetsCruzDelNorte.add(tweet);
            tweetsCruzDelNorte.remove(tweet);
        }
        topTweets.add(topTweetsCruzDelNorte);
        
        return topTweets;
    } 

}
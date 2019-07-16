package com.example.demo.services;

import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.neo4j.driver.v1.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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

    @Autowired
    private SearchRepository searchRepository;

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

    @RequestMapping(value = "/loadRelaciones", method = RequestMethod.GET)
    @ResponseBody
    public void loadRelaciones(){

        Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
        Session session = driver.session();

        session.run("match (a)-[r]-(b) delete r");
        session.run("match (n) delete n");

        List<FondoDeSalud> fondos = this.fondoDeSaludRepository.findAll();

        for(FondoDeSalud fondoDeSalud: fondos){

            System.out.println(fondoDeSalud.getNombre());

            session.run("CREATE (s:Fondo {name:'" + fondoDeSalud.getNombre() + "'})");

            List<Twitt> twitts = new ArrayList<>();
            twitts.addAll(this.searchRepository.findByText(fondoDeSalud.getNombre()));
            System.out.println("cantidad= "+twitts.size());

            int aux = 0;
            for(Twitt twitt:twitts){

                User user = twitt.getUser();
               // System.out.println(user.getScreenName());
                if (user.getScreenName().indexOf("'") > 0){
                    //System.out.println(user.getName());
                    user.setScreenName(user.getScreenName().replaceAll("'", ""));
                }

                StatementResult verificacion = session.run("match (u:User) where u.name='"+user.getScreenName()+"' return distinct u.name as name, u.followers as followers");

                if(!verificacion.hasNext()){
                    session.run("CREATE(u:User {name:'" + user.getScreenName() + "',followers:" + user.getFollowersCount() + "})");
                }

                try{
                    session.run("match (s:Fondo) where s.name='" + fondoDeSalud.getNombre() + "'"
                            + "  match (u:User) where u.name='" + user.getScreenName() + "'"
                            + "  create unique (u)-[label:Comenta]->(s)");
                }catch (EntityNotFoundException e){
                    System.out.println("error");
                }
            }
        }
        session.close();
        driver.close();
    }

    @RequestMapping(value = "/fondo/{nombre}/{top}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> usersByfondo(@PathVariable("nombre") String nombre, @PathVariable("top") Integer top){

        Driver driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
        Session session = driver.session();

        StatementResult nodoResultado = session.run("MATCH (u:User)" +
                "match (s:Fondo) where s.name='"+ nombre +"' " +
                "match (u)-[label]->(s)" +
                "return u.name as name, u.followers as followers order by followers desc limit " + top);

        List<User> usuarios = new ArrayList<>();

        while(nodoResultado.hasNext()){
            Record record = nodoResultado.next();
            String userName = record.get("name").toString().replace("\"", "");
            int followersCount = Integer.parseInt(record.get("followers").toString());

            User aux = this.userRepository.findUserByScreenName(userName);
            System.out.println(aux.getScreenName());
            User u = new User(aux.getId(), aux.getName(), userName, aux.getLocation(), followersCount);
            usuarios.add(u);
        }
        session.close();
        driver.close();
        return usuarios;
    }
}

package com.example.demo.services;

import com.example.demo.models.FondoDeSalud;
import com.example.demo.repositories.FondoDeSaludRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/fondoDeSalud")
public class FondoDeSaludService {

    @Autowired
    private FondoDeSaludRepository fondoDeSaludRepository;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FondoDeSalud getFondoDeSaludByIdFondo(@PathVariable String id){
        return this.fondoDeSaludRepository.findFondoDeSaludByIdFondo(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<FondoDeSalud> getAllFondosDeSalud(){
        return fondoDeSaludRepository.findAll();
    }

    //entrega arreglo correspondiente a la cantidad de afiliados en cada isapre y en fonasa.
    @RequestMapping(value = "/getAfiliados", method = RequestMethod.GET)
    @ResponseBody
    public List<Integer> getCantidadAfiliados(){
        List<Integer> afiliados = new ArrayList<>();
        List<FondoDeSalud> fondos = fondoDeSaludRepository.findAll();

        for (FondoDeSalud f:fondos
             ) {
            afiliados.add(f.getCantidadAfiliados());
        }

        return afiliados;
    }

    //entrega la comparacion de sentimientos entre fonasa e isapre.
    @RequestMapping(value = "/getComparacionFi", method = RequestMethod.GET)
    @ResponseBody
    public List<Integer> getComparacionFi(){
        List<Integer> comparacion = new ArrayList<>();
        FondoDeSalud fonasa = fondoDeSaludRepository.findFondoDeSaludByIdFondo("1");
        FondoDeSalud isapre = fondoDeSaludRepository.findFondoDeSaludByIdFondo("14");

        comparacion.add(fonasa.getAprobacion());
        comparacion.add(fonasa.getDesaprobacion());
        comparacion.add(isapre.getAprobacion());
        comparacion.add(isapre.getDesaprobacion());

        return comparacion;
    }

    //entrega la comparacion de sentimientos entre las isapres.
    @RequestMapping(value = "/getComparacionIsapres", method = RequestMethod.GET)
    @ResponseBody
    public List<Integer> getComparacionIsapres(){
        List<Integer> comparacion = new ArrayList<>();
        List<FondoDeSalud> fondos = fondoDeSaludRepository.findAll();

        FondoDeSalud fonasa = fondoDeSaludRepository.findFondoDeSaludByIdFondo("1");
        FondoDeSalud isapre = fondoDeSaludRepository.findFondoDeSaludByIdFondo("14");

        fondos.remove(fonasa);
        fondos.remove(isapre);

        for (FondoDeSalud f:fondos
        ) {
            comparacion.add(f.getAprobacion());
            comparacion.add(f.getDesaprobacion());
        }

        return comparacion;
    }

}
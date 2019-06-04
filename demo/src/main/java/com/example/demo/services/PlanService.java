package com.example.demo.services;

import com.example.demo.models.Plan;
import com.example.demo.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/plan")
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    @RequestMapping(value = "/{id", method = RequestMethod.GET)
    @ResponseBody
    public Plan getPlanById(@PathVariable String id){
        return this.planRepository.findPlanById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Plan> getAllPlans(){
        return planRepository.findAll();
    }

}
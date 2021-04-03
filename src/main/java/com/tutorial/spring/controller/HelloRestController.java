package com.tutorial.spring.controller;

import com.tutorial.spring.entities.Greeting;
import com.tutorial.spring.entities.Person;
import com.tutorial.spring.services.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @CrossOrigin
    @GetMapping("/rest")
    public Greeting greet(
            @RequestParam(defaultValue = "world", required = false)String name){
        return new Greeting("Hello, "+name+"!");
    }

    @CrossOrigin
    @PostMapping(path = "/eligibility", consumes = "application/json", produces = "application/json")
    public boolean shouldGetFoodStamp(@RequestBody Person person) {
        boolean answer = (boolean) RestClient.checkRule(person);
        System.out.print(person.getAge() + person.getIncome());
        return answer;
        // if(person.getIncome() >= 1000) {
        //     return false;
        // } else {
        //     return true;
        // }
    }
}

package com.tutorial.spring.controller;

import com.tutorial.spring.entities.Greeting;
import com.tutorial.spring.entities.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // it has responsebody annotation transform objects into json and the opposite (serialize object)
public class HelloRestController {
// in the background it uses jackson library to deserialize and serialize json
    @GetMapping("/rest")
    public Greeting greet(
            @RequestParam(defaultValue = "world", required = false)String name){
        return new Greeting("Hello, "+name+"!");
    }
    @PostMapping(path = "/foodStamp", consumes = "application/json", produces = "application/json")
    public boolean shouldGetFoodStamp(@RequestBody Person person) {
        System.out.print(person.getAge() + person.getMaritalStatus() + person.getInsurance() + person.getIncome());
        if(person.getIncome() >= 1000) {
            return false;
        } else {
            return true;
        }
    }
}

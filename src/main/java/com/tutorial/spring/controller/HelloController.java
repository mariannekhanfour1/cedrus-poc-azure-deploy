package com.tutorial.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller  //has component annotation in it  and we scan for component annotation under root
public class HelloController {

    @GetMapping(value = "/hello")
    public String sayHello(
            @RequestParam(defaultValue = "world", required = false) String name, Model model) { // take advantage of the dependency injection use Model
        model.addAttribute("user", name);
        return "hello";
    }

}
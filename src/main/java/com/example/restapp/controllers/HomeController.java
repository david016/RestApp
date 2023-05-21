package com.example.restapp.controllers;

import com.example.restapp.models.Person;
import com.example.restapp.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    PersonService personService = new PersonService();
    List<Person> people = personService.getPeople();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("people", people);
        return "index";
    }
}

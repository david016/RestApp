package com.example.restapp.api.controllers;

import com.example.restapp.models.Person;
import com.example.restapp.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {
    PersonService personService = new PersonService();

    @GetMapping("/api/user/{id}")
    public Person getUser(@PathVariable() String id){
        Optional<Person> person = personService.getUser(id);
        return person.orElse(null);
    }
}

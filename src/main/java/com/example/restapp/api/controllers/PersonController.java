package com.example.restapp.api.controllers;

import com.example.restapp.models.Person;
import com.example.restapp.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {
    PersonService personService = new PersonService();

    @GetMapping("/api/user/{id}")
    public Person getUser(@PathVariable() String id) {
        Optional<Person> person = personService.getUser(id);
        return person.orElse(null);
    }

    @PostMapping("/api/person")
    public ResponseEntity addPerson(@RequestParam() String name,
                                    @RequestParam() String surname,
                                    @RequestParam("identificationNumber") String id,
                                    @RequestParam(defaultValue = "false") boolean bornBefore2000) {
        boolean added = personService.addPerson(new Person(name, surname, id, bornBefore2000));
        if (added) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Person created successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Person already exists");
    }
}

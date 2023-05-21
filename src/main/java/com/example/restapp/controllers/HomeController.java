package com.example.restapp.controllers;

import com.example.restapp.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
    List<Person> people = Arrays.asList(
            new Person("David", "Varga", "910801/1234", true),
            new Person("Elon", "Musk", "7502281234", true),
            new Person("Peter", "Parker", "010831/1234", false)
    );

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("people", people);
        return "index";
    }

    @PostMapping("/add")
    public String add() {
        return "idnex";
    }
}
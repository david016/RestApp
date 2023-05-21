package com.example.restapp.services;

import com.example.restapp.models.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonService {
    private List<Person> people = Arrays.asList(
            new Person("David", "Varga", "910801/1234", true),
            new Person("Elon", "Musk", "7502281234", true),
            new Person("Peter", "Parker", "010831/1234", false)
    );

    public List<Person> getPeople() {
        return people;
    }

    public Optional<Person> getUser(String id) {
        Optional optional = Optional.empty();

        for (Person person : people) {
            if (id.equals(person.getIdentificationNumber())){
                optional = Optional.of(person);
                return  optional;
            }
        }
        return  optional;
    }
}

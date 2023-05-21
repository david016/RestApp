package com.example.restapp.services;

import com.example.restapp.models.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Pattern;

public class PersonService {
    public List<Person> people = new ArrayList<>();

    public PersonService() {
        people.add(new Person("David", "Varga", "910801/1234", true));
        people.add(new Person("Elon", "Musk", "7502281234", true));
        people.add(new Person("Peter", "Parker", "010831/1234", false));
    }

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

    public boolean addPerson(Person person) {
        if (!isIdValid(person.getIdentificationNumber(),person.isBornBefore2000())){
            return false;
        }
        for (Person p : people) {
            if (Objects.equals(p, person)) {
                return  false;
            }
        }
        people.add(person);
        return true;
    }

    public boolean isIdValid(String id, boolean bornBefore2000){
        String regexPattern = "\\d{6}(/)?\\d{4}";

        if (!Pattern.matches(regexPattern, id)) {
            return false;
        }

        try {
            String dateString = id.substring(0, 6);
            DateTimeFormatter formatter = MyDateFormatter.getFormatter(bornBefore2000);
            LocalDate date = LocalDate.parse(dateString, formatter);
            // have to convert it back to Str, because parsing Feb31 returns Feb 28/29
            String dateString2 = date.format(formatter);
            return dateString.equals(dateString2);

        } catch (DateTimeParseException e) {
            return false;
        }
    }
}

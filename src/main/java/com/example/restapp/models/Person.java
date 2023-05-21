package com.example.restapp.models;

import com.example.restapp.services.MyDateFormatter;

public class Person {
    private String name;
    private String surname;
    private final String identificationNumber;
    private final boolean bornBefore2000;


    public Person(String name, String surname, String identificationNumber, boolean bornBefore2000) {
        this.name = name;
        this.surname = surname;
        this.identificationNumber = MyDateFormatter.removeSlashFromId(identificationNumber);
        this.bornBefore2000 = bornBefore2000;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        // people should not have same id number so I guess checking this is enough
        return this.identificationNumber.equals(((Person) o).identificationNumber);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public boolean isBornBefore2000() {
        return bornBefore2000;
    }
}

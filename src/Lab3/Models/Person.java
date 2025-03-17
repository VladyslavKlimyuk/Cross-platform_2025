package Lab3.Models;

import java.time.LocalDate;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate dateBirth;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public Person() {}

    public Person(String firstName, String lastName, LocalDate dateBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + dateBirth + ")";
    }
}
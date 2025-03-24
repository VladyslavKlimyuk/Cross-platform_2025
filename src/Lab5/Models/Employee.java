package Lab5.Models;

import java.io.Serializable;

public class Employee implements Serializable {
    private String surname;
    private String name;
    private int age;
    private String position;

    public Employee(String surname, String name, int age, String position) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Прізвище: " + surname + ", Ім'я: " + name + ", Вік: " + age + ", Посада: " + position;
    }
}

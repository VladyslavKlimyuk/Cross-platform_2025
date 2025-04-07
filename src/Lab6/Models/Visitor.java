package Lab6.Models;

public class Visitor {
    private String name;
    private String surname;

    public Visitor(String s) {}

    public Visitor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "Ім'я відвідувача = '" + name + '\'' +
                ", Прізвище відвідувача = '" + surname + '\'' +
                '}';
    }
}

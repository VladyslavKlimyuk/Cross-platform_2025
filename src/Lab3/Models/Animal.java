package Lab3.Models;

public class Animal {
    private String breed; // порода тварини (всі тварини мають власну породу)
    private int age;
    private double weight;
    private double dailyFeedStandard; // добова норма корму у кг

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getDailyFeedStandard() {
        return dailyFeedStandard;
    }

    public Animal() {}

    public Animal(String breed, int age, double weight, double dailyFeedStandard) {
        this.breed = breed;
        this.age = age;
        this.weight = weight;
        this.dailyFeedStandard = dailyFeedStandard;
    }

    public String sound() {
        return "*звук тварини*";
    }

    @Override
    public String toString() {
        return "Порода: " + breed + "; Вік (у роках): " + age + "; Вага (у кг): " +  weight
                + "; Добова норма корму (у кг): " + dailyFeedStandard;
    }
}
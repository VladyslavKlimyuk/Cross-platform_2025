package Lab3.Models;

public class Kangaroo extends Animal {
    private final String name = "Кенгуру";
    private double handbagSize; // розмір сумочки кенгуру

    public double getHandbagSize() {
        return handbagSize;
    }

    public Kangaroo() {}

    public Kangaroo(String breed, int age, double weight,
                    double dailyFeedStandard, double handbagSize) {
        super(breed, age, weight, dailyFeedStandard);
        this.handbagSize = handbagSize;
    }

    @Override
    public String sound() {
        return "Хрю-хрю!";
    }

    @Override
    public String toString() {
        return "Тварина: " + name + "; " + super.toString() + "; Розмір сумочки (у кг): " + handbagSize;
    }
}
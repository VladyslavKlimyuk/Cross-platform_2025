package Lab3.Models;

public class Rabbit extends Animal {
    private final String name = "Кролик";
    private int earLength; // довжина вух кролика

    public int getEarLength() {
        return earLength;
    }

    public Rabbit() {}

    public Rabbit(String breed, int age, double weight,
                  double dailyFeedStandard, int earLength) {
        super(breed, age, weight, dailyFeedStandard);
        this.earLength = earLength;
    }

    @Override
    public String sound() {
        return "Хрум-хрум!";
    }

    @Override
    public String toString() {
        return "Тварина: " + name + "; " + super.toString() + "; Довжина вух (у см): " + earLength;
    }
}
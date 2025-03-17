package Lab3.Models;

public class Tiger extends Animal {
    private final String name = "Тигр";
    private String stripeColor; // колір полос тигра

    public String getStripeColor() {
        return stripeColor;
    }

    public Tiger() {}

    public Tiger(String breed, int age, double weight,
                 double dailyFeedStandard, String stripeColor) {
        super(breed, age, weight, dailyFeedStandard);
        this.stripeColor = stripeColor;
    }

    @Override
    public String sound() {
        return "Р-р-р!";
    }

    @Override
    public String toString() {
        return "Тварина: " + name + "; " + super.toString() + "; Колір полос: " + stripeColor;
    }
}
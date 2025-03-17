package Lab3.Models;

public class Wolf extends Animal {
    private final String name = "Вовк";
    private boolean mainWolf; // перевірка - чи є вовк вожаком стаї

    public boolean isMainWolf() {
        return mainWolf;
    }

    public Wolf() {}

    public Wolf(String breed, int age, double weight,
                double dailyFeedStandard, boolean mainWolf) {
        super(breed, age, weight, dailyFeedStandard);
        this.mainWolf = mainWolf;
    }

    @Override
    public String sound() {
        return "Ау-у-у!";
    }

    @Override
    public String toString() {
        String wolf = mainWolf ? "Так" : "Ні";
        return "Тварина: " + name + "; " + super.toString() + "; Вожак стаї: " + wolf;
    }
}
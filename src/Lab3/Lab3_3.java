package Lab3;

import Lab3.Models.*;

public class Lab3_3 {
    public static void main(String[] args) {
        double minWeightDailyFeedStandard = 0; // мінімально потрібна вага корму для
                                               // добового раціону годування всіх тварин

        Animal[] zoo = new Animal[] {
                new Tiger("Бенгальский", 3, 150.300, 2, "Чорний"),
                new Rabbit("Висловухий", 7, 1.3, 0.25, 12),
                new Wolf("Арктичний", 4, 35.6, 1.8, false),
                new Kangaroo("Червоний", 2, 71.7, 2.2, 5.2)
        };

        for(Animal animal : zoo) {
            minWeightDailyFeedStandard += animal.getDailyFeedStandard();
            System.out.println(animal + "; Звук: " + animal.sound());
        }

        System.out.println("\nКількість тварин у зоопарку: " + zoo.length);
        System.out.println("Мінімально потрібна вага корму для добового раціону годування всіх тварин: "
                + minWeightDailyFeedStandard + " кг");
    }
}
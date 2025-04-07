package Lab6;

import Lab6.Models.Visitor;
import Lab6.Models.Cafe;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;

public class Lab6_3 {
    public static void main(String[] args) {
        Cafe cafe = new Cafe(3);
        Random random = new Random();

        Visitor v1 = new Visitor("Владислав", "Климюк");
        Visitor v2 = new Visitor("Богдан", "Шевченко");
        Visitor v3 = new Visitor("Вікторія", "Юрченко");
        Visitor v4 = new Visitor("Дмитро", "Зененко");
        Visitor v5 = new Visitor("Олександр", "Волошин");
        Visitor v6 = new Visitor("Софія", "Іванова");

        cafe.arrive(v1, LocalDateTime.now());
        cafe.arrive(v2, LocalDateTime.now().plusMinutes(2));
        cafe.arrive(v3, LocalDateTime.now().plusMinutes(5));

        cafe.makeReservation(v4, LocalDateTime.of(2025, Month.APRIL, 7, 13, 10));
        cafe.makeReservation(v5, LocalDateTime.of(2025, Month.APRIL, 7, 13, 30));

        LocalDateTime currentTime = LocalDateTime.now();
        while (currentTime.isBefore(LocalDateTime
                .of(2025, Month.APRIL,7, 13, 15))) {
            System.out.println("\nЧас: " + currentTime);
            cafe.checkReservations(currentTime);
            cafe.displayQueue(currentTime);

            if (random.nextDouble() < 0.2) {
                cafe.tableFreed(currentTime);
            }
            if (random.nextDouble() < 0.1) {
                Visitor newVisitor = new Visitor("Відвідувач " + (random.nextInt(100) + 7));
                cafe.arrive(newVisitor, currentTime);
            }

            currentTime = currentTime.plusMinutes(1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        cafe.displayQueue(currentTime);
    }
}

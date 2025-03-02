package Lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab1_2 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/Lab1/input1_2"));
            int tankCapacity = scanner.nextInt();
            int distanceAB = scanner.nextInt();
            int distanceBC = scanner.nextInt();
            int Weight = scanner.nextInt();
            scanner.close();

            if (Weight > 2000) {
                System.out.println("Літак не піднімає вантаж більше 2000 кг.");
                return;
            }

            int fuelConsumption = getFuelConsumption(Weight);

            int fuelNeededAB = distanceAB * fuelConsumption;
            int fuelNeededBC = distanceBC * fuelConsumption;

            if (fuelNeededAB > tankCapacity || fuelNeededBC > tankCapacity) {
                System.out.println("Неможливо подолати маршрут з повним баком.");
                return;
            }

            int refuelingNeeded = fuelNeededBC;
            System.out.println("Мінімальна кількість палива для дозаправки в пункті B: " + refuelingNeeded + " літрів.");

        } catch (FileNotFoundException e) {
            System.out.println("Файл input.txt не знайдено.");
        }
    }

    private static int getFuelConsumption(int weight) {
        if (weight <= 500) {
            return 1;
        } else if (weight <= 1000) {
            return 4;
        } else if (weight <= 1500) {
            return 7;
        } else {
            return 9;
        }
    }
}

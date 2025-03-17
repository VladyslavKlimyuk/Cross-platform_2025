package Lab3;

import Lab3.Models.CarParking;
import Lab3.Models.CarParkingData;

import java.util.Scanner;

public class Lab3_1 {
    public static void main(String[] args) {
        CarParkingData myCarData;
        CarParking[] cars = {
                new CarParking("Toyota", "Corolla", "Ivanov",
                        "Kremechuk, Poltava region", "BI0120AA", 1,
                        true),
                new CarParking("Jeep", "Grand Cherokee", "Petrov",
                        "Kherson, Kherson region", "BT0609EA", 2,
                        true),
                new CarParking("Audi", "RS6", "Shabanov",
                        "Kyiv, Kyiv region", "KA2017PC", 3,
                        false)
        };

        myCarData = new CarParkingData(cars);

        System.out.println("Список авто на стоянці: ");
        myCarData.printParkingData();

        System.out.println("\nСписок наявних авто на стоянці: ");
        myCarData.printParkingData(true);

        System.out.println("\nСписок відсутніх авто на стоянці: ");
        myCarData.printParkingData(false);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nПошук авто за номером. Введіть номер авто: ");
        String carNumber = scanner.next();
        scanner.close();

        String carNumbers = myCarData.findCarByNumber(carNumber);
        System.out.println(carNumbers);
    }
}
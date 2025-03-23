package Lab3.Models;

import java.io.*;

public class CarParkingData {
    private CarParking[] cars;

    public CarParkingData(CarParking[] list) {
        cars = list;
    }

    public void printParkingData() {
        for(CarParking car : cars) {
            System.out.println(car);
        }
    }

    public void printParkingData(boolean parkingPresence) {
        for(CarParking car : cars) {
            if(car.isParkingPresence() == parkingPresence) {
                System.out.println(car);
            }
        }
    }

    public String findCarByNumber(String carNumber) {
        String result = "";
        for(CarParking car : cars) {
            if(car.getCarNumber().contains(carNumber)) {
                result += car.toString();
            }
        }
        return result.isEmpty()? "Авто не знайдено": result;
    }

    // зміни до лабораторної роботи №4
    public void saveToFile(String fileName) {
        File file = new File(fileName);

        try (FileOutputStream fileOut = new FileOutputStream(file);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOut)) {

            outputStream.writeObject(cars);

        } catch (FileNotFoundException e) {
            System.out.println("Файл для запису даних не створено - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка запису даних - " + e.getMessage());
        }
    }

    // зміни до лабораторної роботи №4
    public void loadFromFile(String fileName) {
        File file = new File(fileName);

        try (FileInputStream fileIn = new FileInputStream(file);
             ObjectInputStream inputStream = new ObjectInputStream(fileIn)) {

            cars = (CarParking[]) inputStream.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("Не знайдено файл з даними - " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Помилка в структурі даних - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка читання даних - " + e.getMessage());
        }
    }
}
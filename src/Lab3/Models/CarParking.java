package Lab3.Models;

import java.io.*;
import java.time.LocalDate;

// зміни до лабораторної роботи №4
public class CarParking implements Serializable, Comparable<CarParking> {
    private String brand;
    private String model;
    private String lastNameOwner;
    private String addressOwner;
    private String carNumber; // примітка: номер авто не може містити пробіли
    private int parkingNumber; // номер місця на стоянці
    private boolean parkingPresence; // наявність авто на стоянці
    private LocalDate stopParking; // час заїзду на стоянку
    private LocalDate leaveParking; // час виїзду зі стоянки

    private static final long serialVersionUID = 1L;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getLastNameOwner() {
        return lastNameOwner;
    }

    public String getAddressOwner() {
        return addressOwner;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public boolean isParkingPresence() {
        return parkingPresence;
    }

    public LocalDate getStopParking() {
        return stopParking;
    }

    public LocalDate getLeaveParking() {
        return leaveParking;
    }

    public CarParking() {}

    public CarParking(String brand, String model, String lastNameOwner,
                      String addressOwner, String carNumber, int parkingNumber,
                      boolean parkingPresence /*, LocalDate stopParking, LocalDate leaveParking */) {
        this.brand = brand;
        this.model = model;
        this.lastNameOwner = lastNameOwner;
        this.addressOwner = addressOwner;
        this.carNumber = carNumber;
        this.parkingNumber = parkingNumber;
        this.parkingPresence = parkingPresence;
        // this.stopParking = stopParking;
        // this.leaveParking = leaveParking;
    }

    @Override
    public String toString() {
        return brand + ", " + model + ", " + lastNameOwner + ", " + addressOwner + ", " + carNumber + ", " +
                parkingNumber + ", " + parkingPresence /* + ", " + stopParking + ", " + leaveParking */;
    }

    @Override
    public int compareTo(CarParking another) {
        int result = parkingNumber - another.getParkingNumber();

        if(result == 0) System.out.println("Неможливе перебування двох машин на одному парковочному місці");

        return result;
    }
}
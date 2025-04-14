package org.example.Services;

import org.example.DTOs.*;

import java.util.HashMap;
import java.util.Map;

public class StatisticsService {

    private Map<Driver, Integer> cargoCountByDriver = new HashMap<>();
    private Map<String, Integer> cargoCountByDestination = new HashMap<>();
    private Map<Driver, Double> earningsByDriver = new HashMap<>();

    public void updateStatistics(Trip completedTrip) {
        Driver driver = completedTrip.getDriver();
        Cargo cargo = completedTrip.getRequest().getCargo();
        String destination = completedTrip.getRequest().getDestination();
        double payment = completedTrip.getPayment();

        cargoCountByDriver.put(driver, cargoCountByDriver
                .getOrDefault(driver, 0) + cargo.getQuantity());
        cargoCountByDestination.put(destination, cargoCountByDestination
                .getOrDefault(destination, 0) + cargo.getQuantity());
        earningsByDriver.put(driver, earningsByDriver.getOrDefault(driver, 0.0) + payment);
    }

    public Map<Driver, Integer> getCargoCountByDriver() {
        return cargoCountByDriver;
    }

    public Map<String, Integer> getCargoCountByDestination() {
        return cargoCountByDestination;
    }

    public Map<Driver, Double> getEarningsByDriver() {
        return earningsByDriver;
    }

    public Driver getTopEarner() {
        return earningsByDriver.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
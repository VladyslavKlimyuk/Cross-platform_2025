package org.example.Services;

import org.example.DTOs.*;
import org.example.Loggers.TripLogger;

import java.util.*;

public class DispatcherService {
    private List<Driver> availableDrivers;
    private List<Car> availableCars;
    private List<Trip> ongoingTrips;
    private Random random = new Random();

    private StatisticsService statisticsService = new StatisticsService();

    public DispatcherService() {}

    public DispatcherService(List<Driver> availableDrivers, List<Car> availableCars) {
        this.availableDrivers = availableDrivers;
        this.availableCars = availableCars;
        this.ongoingTrips = new ArrayList<>();
    }

    public List<Driver> getAvailableDrivers() {
        return availableDrivers;
    }

    public void setAvailableDrivers(List<Driver> availableDrivers) {
        this.availableDrivers = availableDrivers;
    }

    public List<Car> getAvailableCars() {
        return availableCars;
    }

    public void setAvailableCars(List<Car> availableCars) {
        this.availableCars = availableCars;
    }

    public List<Trip> getOngoingTrips() {
        return ongoingTrips;
    }

    public void setOngoingTrips(List<Trip> ongoingTrips) {
        this.ongoingTrips = ongoingTrips;
    }

    public StatisticsService getStatisticsService() {
        return statisticsService;
    }

    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DispatcherService that = (DispatcherService) o;
        return Objects.equals(availableDrivers, that.availableDrivers)
                && Objects.equals(availableCars, that.availableCars)
                && Objects.equals(ongoingTrips, that.ongoingTrips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(availableDrivers, availableCars, ongoingTrips);
    }

    public Optional<Trip> assignTrip(RouteRequest request) {
        Optional<Driver> suitableDriver = findSuitableDriver(request);
        Optional<Car> suitableCar = findSuitableCar(request.getCargo());

        if (suitableDriver.isPresent() && suitableCar.isPresent()) {
            Driver driver = suitableDriver.get();
            Car car = suitableCar.get();

            availableDrivers.remove(driver);
            availableCars.remove(car);

            Trip trip = new Trip(request, driver, car, false,
                    false, calculatePayment(request));
            ongoingTrips.add(trip);
            logTripStart(trip);
            return Optional.of(trip);
        }
        return Optional.empty();
    }

    private Optional<Driver> findSuitableDriver(RouteRequest request) {
        return availableDrivers.stream()
                .filter(driver -> driver.getExperienceYears() >= 2)
                .filter(driver -> driver.getRequiredCargoType()
                        .equalsIgnoreCase(request.getCargo().getType()))
                .filter(driver -> compareDrivingSkills(driver.getDrivingSkillLevel(),
                        request.getCar().getControlComplexity())) // Виправлено тут
                .findFirst();
    }

    private boolean compareDrivingSkills(int driverSkill, String carComplexity) {
        return (carComplexity.equalsIgnoreCase("легкий") && driverSkill >= 1) ||
                (carComplexity.equalsIgnoreCase("середній") && driverSkill >= 3) ||
                (carComplexity.equalsIgnoreCase("важкий") && driverSkill >= 5);
    }

    private Optional<Car> findSuitableCar(Cargo cargo) {
        return availableCars.stream()
                .filter(car -> !car.isBroken())
                .filter(car -> car.getLoadCapacity() >= cargo.getQuantity())
                .findFirst();
    }

    private double calculatePayment(RouteRequest request) {
        return request.getCargo().getQuantity() * 10.0;
    }

    public void requestRepair(Trip trip) {
        if (ongoingTrips.contains(trip)) {
            trip.setCarBrokenDuringTrip(true);
            logRepairRequest(trip);
        }
    }

    public void completeTrip(Trip trip, String carCondition) {
        if (ongoingTrips.contains(trip)) {
            trip.setCompleted(true);
            trip.getCar().setBroken(carCondition.equalsIgnoreCase("зламаний"));
            availableDrivers.add(trip.getDriver());
            availableCars.add(trip.getCar());
            ongoingTrips.remove(trip);
            logTripCompletion(trip, carCondition);
        }

        statisticsService.updateStatistics(trip);
    }

    private void logTripStart(Trip trip) {
        String logMessage = "Розпочато рейс. Призначення: " + trip.getRequest().getDestination() +
                ", Водій: " + trip.getDriver().getName() +
                ", Автомобіль: " + trip.getCar().getModel() +
                ", Вантаж: " + trip.getRequest().getCargo();
        TripLogger.log(logMessage);
    }

    private void logRepairRequest(Trip trip) {
        String logMessage = "Заявка на ремонт. Рейс: " + trip.getRequest().getDestination() +
                ", Водій: " + trip.getDriver().getName() +
                ", Автомобіль: " + trip.getCar().getModel();
        TripLogger.log(logMessage);
    }

    private void logTripCompletion(Trip trip, String carCondition) {
        String logMessage = "Рейс завершено. Призначення: " + trip.getRequest().getDestination() +
                ", Водій: " + trip.getDriver().getName() +
                ", Автомобіль: " + trip.getCar().getModel() +
                ", Стан авто після рейсу: " + carCondition +
                ", Оплата: " + trip.getPayment();
        TripLogger.log(logMessage);
    }
}
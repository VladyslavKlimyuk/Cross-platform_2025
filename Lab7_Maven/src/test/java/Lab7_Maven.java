import org.example.DTOs.*;
import org.example.Services.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Lab7_Maven {

    private List<Driver> availableDrivers = new ArrayList<>(Arrays.asList(
            new Driver("Іван", 5, 3, "зерно"),
            new Driver("Петро", 3, 5, "цемент"),
            new Driver("Олег", 4, 2, "цегла")
    ));

    private List<Car> availableCars = new ArrayList<>(Arrays.asList(
            new Car("КамАЗ", 10000, "середній", false),
            new Car("Газель", 5000, "легкий", false)
    ));

    private DispatcherService dispatcherService = new DispatcherService(availableDrivers, availableCars);

    @Test
    void assignTrip_suitableDriverAndCar_tripAssigned() {
        RouteRequest request = new RouteRequest("Київ",
                new Cargo("зерно", 5000),
                new Car(null, 0, "середній", false));

        Optional<Trip> trip = dispatcherService.assignTrip(request);
        assertTrue(trip.isPresent());
        assertEquals("Київ", trip.get().getRequest().getDestination());
        assertEquals("Іван", trip.get().getDriver().getName());
        assertEquals("КамАЗ", trip.get().getCar().getModel());
        assertFalse(dispatcherService.getAvailableDrivers().contains(trip.get().getDriver()));
        assertFalse(dispatcherService.getAvailableCars().contains(trip.get().getCar()));
    }

    @Test
    void assignTrip_noSuitableDriver_tripNotAssigned() {
        RouteRequest request = new RouteRequest("Львів",
                new Cargo("скло", 1000),
                new Car(null, 0, "легкий", false));

        Optional<Trip> trip = dispatcherService.assignTrip(request);
        assertFalse(trip.isPresent());
    }

    @Test
    void assignTrip_noSuitableCar_tripNotAssigned() {
        RouteRequest request = new RouteRequest("Одеса",
                new Cargo("зерно", 15000),
                new Car(null, 0, "середній", false));

        Optional<Trip> trip = dispatcherService.assignTrip(request);
        assertFalse(trip.isPresent());
    }

    @Test
    void completeTrip_tripExists_driverAndCarBecomeAvailable() {
        RouteRequest request = new RouteRequest("Харків",
                new Cargo("цемент", 1500),
                new Car(null, 0, "середній", false));
        Optional<Trip> assignedTrip = dispatcherService.assignTrip(request);
        assertTrue(assignedTrip.isPresent());
        Trip trip = assignedTrip.get();

        dispatcherService.completeTrip(trip, "справний");

        assertTrue(dispatcherService.getAvailableDrivers().contains(trip.getDriver()));
        assertTrue(dispatcherService.getAvailableCars().contains(trip.getCar()));
        assertTrue(trip.isCompleted());
        assertFalse(trip.getCar().isBroken());
    }

    @Test
    void completeTrip_carBroken_carStatusUpdated() {
        RouteRequest request = new RouteRequest("Дніпро",
                new Cargo("зерно", 7000),
                new Car(null, 0, "середній", false));
        Optional<Trip> assignedTrip = dispatcherService.assignTrip(request);
        assertTrue(assignedTrip.isPresent());
        Trip trip = assignedTrip.get();

        dispatcherService.completeTrip(trip, "зламаний");

        assertTrue(trip.getCar().isBroken());
    }

    @Test
    void requestRepair_ongoingTrip_carBrokenStatusUpdated() {
        RouteRequest request = new RouteRequest("Львів",
                new Cargo("цегла", 3000),
                new Car(null, 0, "легкий", false));
        Optional<Trip> assignedTripOptional = dispatcherService.assignTrip(request);
        if (assignedTripOptional.isPresent()) {
            Trip assignedTrip = assignedTripOptional.get();
            Optional<Trip> activeTripOptional = dispatcherService.getOngoingTrips().stream()
                    .filter(trip -> trip.getDriver()
                            .equals(assignedTrip.getDriver()) && trip.getCar().equals(assignedTrip.getCar()))
                    .findFirst();

            if (activeTripOptional.isPresent()) {
                Trip activeTrip = activeTripOptional.get();
                dispatcherService.requestRepair(activeTrip);
                assertTrue(activeTrip.isCarBrokenDuringTrip());
            }

            else {
                fail("Активну подорож не знайдено в поточних поїздках");
            }
        }

        else {
            fail("Призначити подорож не вдалося");
        }
    }

    @Test
    void statisticsUpdatedOnTripCompletion() {
        RouteRequest request1 = new RouteRequest("Київ",
                new Cargo("зерно", 5000),
                new Car(null, 0, "середній", false));
        Optional<Trip> trip1 = dispatcherService.assignTrip(request1);
        assertTrue(trip1.isPresent());
        dispatcherService.completeTrip(trip1.get(), "справний");

        RouteRequest request2 = new RouteRequest("Львів",
                new Cargo("цемент", 2000),
                new Car(null, 0, "середній", false));
        Optional<Trip> trip2 = dispatcherService.assignTrip(request2);
        assertTrue(trip2.isPresent());
        dispatcherService.completeTrip(trip2.get(), "справний");

        StatisticsService statistics = dispatcherService.getStatisticsService();
        assertEquals(5000, statistics.getCargoCountByDriver().get(trip1.get().getDriver()));
        assertEquals(2000, statistics.getCargoCountByDriver().get(trip2.get().getDriver()));
        assertEquals(5000, statistics.getCargoCountByDestination().get("Київ"));
        assertEquals(2000, statistics.getCargoCountByDestination().get("Львів"));
    }
}
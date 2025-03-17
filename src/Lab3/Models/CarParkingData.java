package Lab3.Models;

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
}
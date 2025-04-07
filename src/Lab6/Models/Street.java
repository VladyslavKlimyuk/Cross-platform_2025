package Lab6.Models;

import Lab6.Interfaces.Building;
import Lab6.Enums.DepartmentType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Street {
    private String name;
    private List<Building> buildings;

    public Street() {}

    public Street(String name) {
        this.name = name;
        this.buildings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(name, street.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public void addBuilding(Building building) {
        this.buildings.add(building);
    }

    public void removeBuilding(String address) {
        this.buildings.removeIf(building -> building.getAddress().equalsIgnoreCase(address));
    }

    public void displayAllBuildingsInfo() {
        System.out.println("Інформація про будівлі на вулиці " + name);
        buildings.forEach(Building::displayInfo);
    }

    public List<Shop> findShopsWithDepartmentNearby(ResidentialBuilding residentialBuilding,
                                                    int vicinityRadius, DepartmentType departmentType) {
        List<Shop> nearbyShops = new ArrayList<>();
        try {
            int buildingNumber = Integer.parseInt(residentialBuilding.getAddress().split(" ")[1]);
            for (Building building : buildings) {
                if (building instanceof Shop) {
                    try {
                        int shopNumber = Integer.parseInt(building.getAddress().split(" ")[1]);
                        if (Math.abs(shopNumber - buildingNumber) <= vicinityRadius) {
                            Shop shop = (Shop) building;
                            if (shop.getDepartments().contains(departmentType)) {
                                nearbyShops.add(shop);
                            }
                        }
                    }

                    catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    }
                }
            }
        }

        catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Невірний формат адреси для житлового будинку: "
                    + residentialBuilding.getAddress());
        }

        return nearbyShops;
    }
}
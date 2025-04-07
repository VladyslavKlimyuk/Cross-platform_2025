package Lab6.Models;

import Lab6.Enums.DepartmentType;
import Lab6.Interfaces.Building;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StreetMenu {
    private Street street;
    private Scanner scanner;

    public StreetMenu() {}

    public StreetMenu(Street street) {
        this.street = street;
        this.scanner = new Scanner(System.in);
    }

    public Street getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StreetMenu that = (StreetMenu) o;
        return Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(street);
    }

    public void run() {
        while (true) {
            System.out.println("\nМеню " + street.getName());
            System.out.println("1. Додати будівлю");
            System.out.println("2. Видалити будівлю");
            System.out.println("3. Знайти магазини в околиці житлового будинку");
            System.out.println("4. Вивести інформацію про всі будівлі");
            System.out.println("0. Вийти");

            System.out.println("Введіть номер команди: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBuilding();
                    break;
                case 2:
                    removeBuilding();
                    break;
                case 3:
                    findShopsInVicinity();
                    break;
                case 4:
                    street.displayAllBuildingsInfo();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Невірний вибір.");
            }
        }
    }

    private void addBuilding() {
        System.out.print("Тип будівлі (residential, school, shop, hospital): ");
        String type = scanner.nextLine().trim().toLowerCase();

        try {
            switch (type) {
                case "residential":
                    addResidentialBuilding();
                    break;
                case "school":
                    addSchool();
                    break;
                case "shop":
                    addShop();
                    break;
                case "hospital":
                    addHospital();
                    break;
                default:
                    System.out.println("Невідомий тип будівлі.");
            }
        }

        catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private void addResidentialBuilding() {
        System.out.print("Адреса (вул. [номер], кількість мешканців): ");
        String data = scanner.nextLine();
        ResidentialBuilding residentialBuilding = new ResidentialBuilding();
        residentialBuilding.setFieldsFromString(data);
        street.addBuilding(residentialBuilding);
        System.out.println("Житловий будинок додано.");
    }

    private void addSchool() {
        System.out.print("Адреса (вул. [номер], рівень акредитації): ");
        String data = scanner.nextLine();
        School school = new School();
        school.setFieldsFromString(data);
        street.addBuilding(school);
        System.out.println("Школу додано.");
    }

    private void addShop() {
        System.out.print("Адреса (вул. [номер], відділи через ';'): ");
        String data = scanner.nextLine();
        Shop shop = new Shop();
        shop.setFieldsFromString(data);
        street.addBuilding(shop);
        System.out.println("Магазин додано.");
    }

    private void addHospital() {
        System.out.print("Адреса (вул. [номер], кількість ліжок, спеціалізація): ");
        String data = scanner.nextLine();
        Hospital hospital = new Hospital();
        hospital.setFieldsFromString(data);
        street.addBuilding(hospital);
        System.out.println("Лікарню додано.");
    }

    private void removeBuilding() {
        System.out.print("Адреса будівлі для видалення: ");
        String address = scanner.nextLine();
        street.removeBuilding(address);
        System.out.println("Будівлю видалено.");
    }

    private void findShopsInVicinity() {
        System.out.print("Адреса житлового будинку: ");
        String residentialAddress = scanner.nextLine();
        System.out.print("Радіус околиці: ");
        int vicinityRadius = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Тип відділу магазину: ");
        String departmentName = scanner.nextLine().trim().toUpperCase();

        ResidentialBuilding residentialBuilding = null;
        for (Building building : street.getBuildings()) {
            if (building instanceof ResidentialBuilding && building.getAddress()
                    .equalsIgnoreCase(residentialAddress)) {
                residentialBuilding = (ResidentialBuilding) building;
                break;
            }
        }

        if (residentialBuilding != null) {
            try {
                DepartmentType departmentType = DepartmentType.valueOf(departmentName);
                List<Shop> shops = street.findShopsWithDepartmentNearby
                        (residentialBuilding, vicinityRadius, departmentType);
                if (shops.isEmpty()) {
                    System.out.println("Магазини з вказаним відділом в околиці не знайдено.");
                } else {
                    System.out.println("Магазини в околиці:");
                    shops.forEach(Shop::displayInfo);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Невірний тип відділу.");
            }
        } else {
            System.out.println("Житловий будинок не знайдено.");
        }
    }
}
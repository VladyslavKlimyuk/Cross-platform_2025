package Lab6.Models;

import Lab6.Enums.DepartmentType;
import java.util.List;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Shop extends AbstractBuilding {
    private List<DepartmentType> departments;

    public Shop() {}

    public Shop(String address, List<DepartmentType> departments) {
        super(address);
        this.departments = departments;
    }

    public List<DepartmentType> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentType> departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(departments, shop.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(departments);
    }

    @Override
    public void setFieldsFromString(String data) throws IllegalArgumentException {
        String[] parts = data.split(",");
        if (parts.length < 1) {
            throw new IllegalArgumentException("Недостатньо даних для магазину.");
        }

        setAddress(parts[0].trim());
        if (parts.length > 1) {
            try {
                departments = Arrays.stream(parts[1].trim().split(";"))
                        .map(String::trim)
                        .map(DepartmentType::valueOf)
                        .collect(Collectors.toList());
            }

            catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Невірний формат відділів магазину.");
            }
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Тип: Магазин, Адреса: " + getAddress() + ", Відділи: " + departments);
    }
}
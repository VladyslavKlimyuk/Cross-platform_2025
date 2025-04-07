package Lab6.Models;

import java.util.Objects;

public class Hospital extends AbstractBuilding {
    private int numberOfBeds;
    private String specialization;

    public Hospital() {}

    public Hospital(String address, int numberOfBeds, String specialization) {
        super(address);
        this.numberOfBeds = numberOfBeds;
        this.specialization = specialization;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return numberOfBeds == hospital.numberOfBeds && Objects.equals(specialization, hospital.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfBeds, specialization);
    }

    @Override
    public void setFieldsFromString(String data) throws IllegalArgumentException {
        String[] parts = data.split(",");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Невірний формат для лікарні " +
                    "(адреса, кількість ліжок, спеціалізація).");
        }
        setAddress(parts[0].trim());
        try {
            setNumberOfBeds(Integer.parseInt(parts[1].trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невірний формат кількості ліжок.");
        }
        setSpecialization(parts[2].trim());
    }

    @Override
    public void displayInfo() {
        System.out.println("Тип: Лікарня, Адреса: " + getAddress()
                + ", Кількість ліжок: " + numberOfBeds + ", Спеціалізація: " + specialization);
    }
}
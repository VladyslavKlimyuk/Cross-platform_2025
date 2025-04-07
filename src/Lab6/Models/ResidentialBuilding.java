package Lab6.Models;

import java.util.Objects;

public class ResidentialBuilding extends AbstractBuilding {
    private int numberOfResidents;

    public ResidentialBuilding() {}

    public ResidentialBuilding(String address, int numberOfResidents) {
        super(address);
        this.numberOfResidents = numberOfResidents;
    }

    public int getNumberOfResidents() {
        return numberOfResidents;
    }

    public void setNumberOfResidents(int numberOfResidents) {
        this.numberOfResidents = numberOfResidents;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ResidentialBuilding that = (ResidentialBuilding) o;
        return numberOfResidents == that.numberOfResidents;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numberOfResidents);
    }

    @Override
    public void setFieldsFromString(String data) throws IllegalArgumentException {
        String[] parts = data.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException
                    ("Невірний формат для житлового будинку (адреса, кількість мешканців).");
        }

        setAddress(parts[0].trim());
        try {
            setNumberOfResidents(Integer.parseInt(parts[1].trim()));
        }

        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невірний формат кількості мешканців.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Тип: Житловий будинок, Адреса: "
                + getAddress() + ", Кількість мешканців: " + numberOfResidents);
    }
}
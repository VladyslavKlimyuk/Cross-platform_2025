package Lab6.Models;

import Lab6.Enums.AccreditationLevel;

import java.util.Objects;
import java.util.Random;

public class School extends AbstractBuilding {
    private int numberOfStudents;
    private AccreditationLevel level;

    public School() {}

    public School(String address, AccreditationLevel level) {
        super(address);
        this.level = level;
        this.numberOfStudents = generateRandomStudents(level);
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public AccreditationLevel getLevel() {
        return level;
    }

    public void setLevel(AccreditationLevel level) {
        this.level = level;
        this.numberOfStudents = generateRandomStudents(level);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return numberOfStudents == school.numberOfStudents && level == school.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfStudents, level);
    }

    @Override
    public void setFieldsFromString(String data) throws IllegalArgumentException {
        String[] parts = data.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Невірний формат для школи (адреса, рівень акредитації).");
        }

        setAddress(parts[0].trim());
        try {
            setLevel(AccreditationLevel.valueOf(parts[1].trim().toUpperCase()));
        }

        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Невірний рівень акредитації.");
        }
    }

    private int generateRandomStudents(AccreditationLevel level) {
        Random random = new Random();
        switch (level) {
            case GENERAL_EDUCATION:
                return random.nextInt(500) + 300;
            case GYMNASIUM:
                return random.nextInt(400) + 200;
            case LYCEUM:
                return random.nextInt(300) + 100;
            default:
                return 0;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Тип: Школа, Адреса: " + getAddress()
                + ", Рівень акредитації: " + level + ", Кількість учнів: " + numberOfStudents);
    }
}
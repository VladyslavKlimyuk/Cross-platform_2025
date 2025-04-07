package Lab6.Models;

public class Television {
    private String modelName;
    private int year;
    private double price;
    private double diagonal;
    private String manufacturer;

    public Television() {}

    public Television(String modelName, int year, double price, double diagonal, String manufacturer) {
        this.modelName = modelName;
        this.year = year;
        this.price = price;
        this.diagonal = diagonal;
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Television{" +
                "Модель = " + modelName +
                ", Рік випуску = " + year +
                ", Ціна = " + price +
                ", Діагональ екрану = " + diagonal +
                ", Виробник = " + manufacturer +
                '}';
    }
}
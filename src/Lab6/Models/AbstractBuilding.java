package Lab6.Models;

import Lab6.Interfaces.Building;

public abstract class AbstractBuilding implements Building {
    private String address;

    public AbstractBuilding() {}

    public AbstractBuilding(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public abstract void setFieldsFromString(String data) throws IllegalArgumentException;

    @Override
    public abstract void displayInfo();
}
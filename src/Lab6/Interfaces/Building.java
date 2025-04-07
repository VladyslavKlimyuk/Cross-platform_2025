package Lab6.Interfaces;

public interface Building {
    String getAddress();
    void setAddress(String address);
    void setFieldsFromString(String data) throws IllegalArgumentException;
    void displayInfo();
}

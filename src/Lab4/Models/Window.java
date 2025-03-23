package Lab4.Models;

import Lab4.Interfaces.IPart;

public class Window implements IPart {
    private boolean built = false;
    private int windowNumber;

    public Window(int windowNumber) {
        this.windowNumber = windowNumber;
    }

    @Override
    public void build() {
        System.out.println("Вікно " + windowNumber + " встановлено.");
        built = true;
    }

    @Override
    public boolean isBuilt() {
        return built;
    }

    @Override
    public String getDescription() {
        return "Вікно " + windowNumber;
    }
}

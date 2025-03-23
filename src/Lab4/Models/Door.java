package Lab4.Models;

import Lab4.Interfaces.IPart;

public class Door implements IPart {
    private boolean built = false;

    @Override
    public void build() {
        System.out.println("Двері встановлено.");
        built = true;
    }

    @Override
    public boolean isBuilt() {
        return built;
    }

    @Override
    public String getDescription() {
        return "Двері";
    }
}

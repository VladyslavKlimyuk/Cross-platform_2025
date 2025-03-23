package Lab4.Models;

import Lab4.Interfaces.IPart;

public class Wall implements IPart {
    private boolean built = false;
    private int wallNumber;

    public Wall(int wallNumber) {
        this.wallNumber = wallNumber;
    }

    @Override
    public void build() {
        System.out.println("Стіна " + wallNumber + " зведена.");
        built = true;
    }

    @Override
    public boolean isBuilt() {
        return built;
    }

    @Override
    public String getDescription() {
        return "Стіна " + wallNumber;
    }
}

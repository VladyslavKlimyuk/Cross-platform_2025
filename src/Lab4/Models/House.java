package Lab4.Models;

import Lab4.Interfaces.IPart;

public class House {
    private Basement basement;
    private Wall[] walls;
    private Door door;
    private Window[] windows;
    private Roof roof;

    public House() {
        basement = new Basement();
        walls = new Wall[4];
        for (int i = 0; i < 4; i++) {
            walls[i] = new Wall(i + 1);
        }
        door = new Door();
        windows = new Window[4];
        for (int i = 0; i < 4; i++) {
            windows[i] = new Window(i + 1);
        }
        roof = new Roof();
    }

    public IPart[] getParts() {
        return new IPart[]{basement, walls[0], walls[1], walls[2], walls[3], door, windows[0], windows[1], windows[2], windows[3], roof};
    }
}

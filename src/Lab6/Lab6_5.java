package Lab6;

import Lab6.Models.Street;
import Lab6.Models.StreetFactory;
import Lab6.Models.StreetMenu;

public class Lab6_5 {
    public static void main(String[] args) {
        Street street = StreetFactory.createTestStreet("вул. Херсонська");
        StreetMenu menu = new StreetMenu(street);
        menu.run();
    }
}

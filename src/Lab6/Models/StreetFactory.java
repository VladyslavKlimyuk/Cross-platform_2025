package Lab6.Models;

import Lab6.Enums.*;
import java.util.List;

public class StreetFactory {
    public static Street createTestStreet(String name) {
        Street street = new Street(name);
        street.addBuilding(new ResidentialBuilding("вул. Херсонська, 1", 50));
        street.addBuilding(new Shop("вул. Херсонська, 2", List.of(DepartmentType.FOOD, DepartmentType.HOUSEHOLD)));
        street.addBuilding(new School("вул. Херсонська, 3", AccreditationLevel.GYMNASIUM));
        street.addBuilding(new Hospital("вул. Херсонська, 4", 100, "Кардіологія"));
        street.addBuilding(new ResidentialBuilding("вул. Херсонська, 5", 120));
        street.addBuilding(new Shop("вул. Херсонська, 6", List.of(DepartmentType.CLOTHES, DepartmentType.BOOKS)));
        street.addBuilding(new School("вул. Херсонська, 7", AccreditationLevel.LYCEUM));
        street.addBuilding(new Hospital("вул. Херсонська, 8", 200, "Онкологія"));
        return street;
    }
}
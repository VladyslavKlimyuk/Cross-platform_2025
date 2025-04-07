package Lab6;

import Lab6.Models.Television;
import Lab6.Models.TelevisionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab6_4 {
    public static void main(String[] args) {
        List<Television> televisions = new ArrayList<>();
        televisions.add(new Television("Samsung QN90A", 2023, 55000,
                55, "Південна Корея"));
        televisions.add(new Television("LG OLED C2", 2022, 60000,
                65, "Південна Корея"));
        televisions.add(new Television("Sony Bravia XR A80J", 2021, 45000,
                55, "Японія"));
        televisions.add(new Television("Samsung AU7100", 2023, 20000,
                43, "Південна Корея"));
        televisions.add(new Television("Xiaomi Mi TV P1", 2022, 15000,
                50, "Китай"));
        televisions.add(new Television("Philips OLED 807", 2022, 50000,
                55, "Нідерланди"));
        televisions.add(new Television("Sony Bravia XR X90K", 2022, 40000,
                65, "Японія"));
        televisions.add(new Television("Samsung The Frame", 2023, 70000,
                55, "Південна Корея"));
        televisions.add(new Television("LG NanoCell NANO75", 2023, 25000,
                50, "Південна Корея"));
        televisions.add(new Television("Hisense U8G", 2021, 30000,
                55, "Китай"));
        televisions.add(new Television("KIVI Smart TV", 2023, 12000,
                32, "Китай"));
        televisions.add(new Television("Ergo LED", 2023, 8000,
                24, "Україна"));
        televisions.add(new Television("Samsung Q60B", 2022, 35000,
                40, "Південна Корея"));

        TelevisionService service = new TelevisionService(televisions);
        Scanner scanner = new Scanner(System.in);

        service.showAllTelevisions();
        service.showTelevisionsByDiagonal(55);
        service.showTelevisionsByManufacturer("Південна Корея");
        service.showTelevisionsByYearDiagonalAndPrice(scanner);
        service.showTelevisionsMoreExpensiveThanPrice(40000);
        service.showTelevisionsSortedByPriceAscending();
        service.showTelevisionsSortedByDiagonalDescending();
        service.showTelevisionsGroupedByManufacturer();
        service.showTopNExpensiveTelevisions(5);
        service.showTopNSmallestDiagonalTelevisions(3);
        service.showLastMostExpensiveTelevisionWithDiagonal(40);

        scanner.close();
    }
}

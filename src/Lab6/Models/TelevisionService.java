package Lab6.Models;

import java.util.*;
import java.util.stream.Collectors;

public class TelevisionService {
    private List<Television> televisions;

    public TelevisionService() {}

    public TelevisionService(List<Television> televisions) {
        this.televisions = televisions;
    }

    public List<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<Television> televisions) {
        this.televisions = televisions;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TelevisionService that = (TelevisionService) o;
        return Objects.equals(televisions, that.televisions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(televisions);
    }

    public void showAllTelevisions() {
        System.out.println("Усі телевізори:");
        televisions.forEach(System.out::println);
        System.out.println("\n");
    }

    public void showTelevisionsByDiagonal(double diagonal) {
        System.out.println("\nТелевізори з діагоналлю " + diagonal + " дюймів:");
        televisions.stream()
                .filter(tv -> tv.getDiagonal() == diagonal)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void showTelevisionsByManufacturer(String manufacturer) {
        System.out.println("\nУсі телевізори виробника " + manufacturer + ":");
        televisions.stream()
                .filter(tv -> tv.getManufacturer().equalsIgnoreCase(manufacturer))
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void showTelevisionsByYearDiagonalAndPrice(Scanner scanner) {
        System.out.println("\nТелевізори цього року з діагоналлю до 30 дюймів та ціною не менше ніж:");
        System.out.print("Введіть мінімальну ціну: ");
        double userPrice = scanner.nextDouble();
        int currentYear = java.time.Year.now().getValue();
        televisions.stream()
                .filter(tv -> tv.getYear() == currentYear && tv.getDiagonal() <= 30
                        && tv.getPrice() >= userPrice)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void showTelevisionsMoreExpensiveThanPrice(double price) {
        System.out.println("\nУсі телевізори дорожчі за " + price + " грн:");
        televisions.stream()
                .filter(tv -> tv.getPrice() > price)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void showTelevisionsSortedByPriceAscending() {
        System.out.println("\nУсі телевізори, відсортовані за ціною за зростанням:");
        televisions.stream()
                .sorted(Comparator.comparingDouble(Television::getPrice))
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void showTelevisionsSortedByDiagonalDescending() {
        System.out.println("\nУсі телевізори, відсортовані по діагоналі за зменшенням:");
        televisions.stream()
                .sorted(Comparator.comparingDouble(Television::getDiagonal).reversed())
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void showTelevisionsGroupedByManufacturer() {
        System.out.println("\nГрупи телевізорів за країною виробника:");
        Map<String, List<Television>> tvByCountry = televisions.stream()
                .collect(Collectors.groupingBy(Television::getManufacturer));
        tvByCountry.forEach((country, tvList) -> {
            System.out.println("Країна: " + country);
            tvList.forEach(System.out::println);
        });
        System.out.println("\n");
    }

    public void showTopNExpensiveTelevisions(int n) {
        System.out.println("\nТоп-" + n + " найдорожчих телевізорів:");
        televisions.stream()
                .sorted(Comparator.comparingDouble(Television::getPrice).reversed())
                .limit(n)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void showTopNSmallestDiagonalTelevisions(int n) {
        System.out.println("\n" + n + " телевізори з найменшою діагоналлю:");
        televisions.stream()
                .sorted(Comparator.comparingDouble(Television::getDiagonal))
                .limit(n)
                .forEach(System.out::println);
        System.out.println("\n");
    }

    public void showLastMostExpensiveTelevisionWithDiagonal(double diagonal) {
        System.out.println("\nОстанній найдорожчий телевізор з діагоналлю " + diagonal + " дюймів:");
        televisions.stream()
                .filter(tv -> tv.getDiagonal() == diagonal)
                .sorted(Comparator.comparingDouble(Television::getPrice).reversed())
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Телевізорів з діагоналлю "
                        + diagonal + " дюймів не знайдено."));
        System.out.println("\n");
    }
}
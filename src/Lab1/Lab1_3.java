package Lab1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lab1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> menu = createMenu();
        List<Order> orders = new ArrayList<>();

        while (true) {
            System.out.print("На скільки людей замовлення? (або 'Вихід' для завершення): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Вихід")) {
                break;
            }

            try {
                int numberOfPeople = Integer.parseInt(input);
                Order order = processOrder(scanner, menu, numberOfPeople);
                orders.add(order);
            } catch (NumberFormatException e) {
                System.out.println("Некоректний формат числа. Спробуйте ще раз.");
            }
        }

        printTotalOrder(orders);
        scanner.close();
    }

    private static Map<String, Double> createMenu() {
        Map<String, Double> menu = new HashMap<>();
        menu.put("Кава", 30.0);
        menu.put("Чай", 25.0);
        menu.put("Тістечко", 40.0);
        menu.put("Круасан", 35.0);
        menu.put("Сік", 28.0);
        return menu;
    }

    private static Order processOrder(Scanner scanner, Map<String, Double> menu, int numberOfPeople) {
        Order order = new Order();
        for (int i = 1; i <= numberOfPeople; i++) {
            System.out.println("\nЗамовлення для клієнта " + i + ":");
            double personTotal = 0;
            while (true) {
                System.out.println("\nМеню:");
                for (Map.Entry<String, Double> entry : menu.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue() + " грн.");
                }
                System.out.print("Виберіть страву (або 'Стоп' для завершення): ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("Стоп")) {
                    break;
                }

                if (menu.containsKey(choice)) {
                    personTotal += menu.get(choice);
                } else {
                    System.out.println("Такої страви немає в меню.");
                }
            }
            order.addPersonTotal(personTotal);
        }
        return order;
    }

    private static void printTotalOrder(List<Order> orders) {
        double total = 0;
        for (Order order : orders) {
            total += order.getTotal();
        }
        System.out.println("\nЗагальна сума замовлення: " + total + " грн.");
    }

    static class Order {
        private List<Double> personTotals = new ArrayList<>();

        public void addPersonTotal(double personTotal) {
            personTotals.add(personTotal);
        }

        public double getTotal() {
            return personTotals.stream().mapToDouble(Double::doubleValue).sum();
        }
    }
}

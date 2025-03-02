package Lab1;

import java.util.Scanner;

public class Lab1_4 {
    public static void main(String[] args) {
        int min = findMinPositive();
        if (min != Integer.MAX_VALUE) {
            System.out.println("Мінімальне додатне число: " + min);
        } else {
            System.out.println("Не було введено жодного додатного числа.");
        }
    }

    public static int findMinPositive() {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;

        while (true) {
            System.out.print("Введіть число (0 або <= 9 для завершення): ");
            int number = scanner.nextInt();

            if (number == 0 || number <= 9) {
                break;
            }

            if (number > 9 && number < min) {
                min = number;
            }
        }

        scanner.close();
        return min;
    }
}

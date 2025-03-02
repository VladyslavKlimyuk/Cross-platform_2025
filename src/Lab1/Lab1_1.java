package Lab1;

import java.util.Scanner;

public class Lab1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть перше число: ");
        int number1 = scanner.nextInt();

        System.out.println("Введіть друге число: ");
        int number2 = scanner.nextInt();

        System.out.println("Всі непарні числа у вказаному діапазоні: ");

        if(number1 > number2) {
            int number3 = number1;
            number1 = number2;
            number2 = number3;
        }

        for(int i = number1; i <= number2; i++) {
            if(i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
    }
}

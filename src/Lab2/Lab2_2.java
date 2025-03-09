package Lab2;

import java.util.Scanner;

public class Lab2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок: ");
        String textForSB = scanner.nextLine();
        StringBuilder sb = new StringBuilder(textForSB);

        System.out.println("Введіть початкову і кінцеву межу для визначення підрядка (subString): ");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        String substring = sb.substring(number1, number2);
        System.out.println("Підрядок (subString): " + substring);

        System.out.println("Введіть початкову і кінцеву межу для визначення підрядка (getChars): ");
        int number3 = scanner.nextInt();
        int number4 = scanner.nextInt();
        char[] chars = new char[number4 - number3];
        sb.getChars(number3, number4, chars, number3);
        System.out.println("Підрядок (getChars): " + new String(chars));

        System.out.println("Введіть текст, який хочете додати в кінець початкового тексту: ");
        scanner.nextLine();
        String appendText = scanner.nextLine();
        sb.append(appendText);
        System.out.println("Після додавання в кінець: " + sb);

        System.out.println("Введіть текст, який хочете додати в середину початкового тексту: ");
        String insertText = scanner.nextLine();
        System.out.println("Введіть положення курсора в тексті, де ви бажаєте додати текст: ");
        int number5 = scanner.nextInt();
        sb.insert(number5, insertText);
        System.out.println("Після додавання в середину: " + sb);

        System.out.println("Введіть межі видалення тексту: ");
        int number6 = scanner.nextInt();
        int number7 = scanner.nextInt();
        sb.delete(number6, number7);
        System.out.println("Після видалення: " + sb);

        System.out.println("Введіть текст, на який хочете замінити попередній: ");
        scanner.nextLine();
        String replaceText = scanner.nextLine();
        System.out.println("Введіть межі заміни тексту: ");
        int number8 = scanner.nextInt();
        int number9 = scanner.nextInt();
        sb.replace(number8, number9, replaceText);
        System.out.println("Після заміни: " + sb);

        scanner.close();
    }
}
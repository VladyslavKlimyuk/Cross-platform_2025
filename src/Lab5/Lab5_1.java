package Lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab5_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до першого файлу: ");
        String filePath1 = scanner.nextLine();

        System.out.print("Введіть шлях до другого файлу: ");
        String filePath2 = scanner.nextLine();

        try {
            List<String> lines1 = readFileLines(filePath1);
            List<String> lines2 = readFileLines(filePath2);

            compareLines(lines1, lines2);

        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    private static List<String> readFileLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static void compareLines(List<String> lines1, List<String> lines2) {
        int minSize = Math.min(lines1.size(), lines2.size());
        boolean equal = true;

        for (int i = 0; i < minSize; i++) {
            if (!lines1.get(i).equals(lines2.get(i))) {
                System.out.println("Рядки не збігаються на позиції " + (i + 1) + ":");
                System.out.println("Файл 1: " + lines1.get(i));
                System.out.println("Файл 2: " + lines2.get(i));
                equal = false;
            }
        }

        if (lines1.size() > minSize) {
            System.out.println("Файл 1 має додаткові рядки:");
            for (int i = minSize; i < lines1.size(); i++) {
                System.out.println("Файл 1: " + lines1.get(i));
                equal = false;
            }
        } else if (lines2.size() > minSize) {
            System.out.println("Файл 2 має додаткові рядки:");
            for (int i = minSize; i < lines2.size(); i++) {
                System.out.println("Файл 2: " + lines2.get(i));
                equal = false;
            }
        }

        if (equal) {
            System.out.println("Файли збігаються рядок в рядок.");
        }
    }
}

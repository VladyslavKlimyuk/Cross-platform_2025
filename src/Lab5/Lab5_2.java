package Lab5;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Lab5_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до каталогу з текстовими файлами: ");
        String directoryPath = scanner.nextLine();

        List<String> forbiddenWords = readForbiddenWords("src/Lab5/Files/ForbiddenWords.txt");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directoryPath), "*.txt")) {
            for (Path file : stream) {
                processFile(file, forbiddenWords, scanner);
            }
        } catch (IOException e) {
            System.err.println("Помилка обробки файлів: " + e.getMessage());
        }
    }

    private static List<String> readForbiddenWords(String filePath) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу з забороненими словами: " + e.getMessage());
        }
        return words;
    }

    private static void processFile(Path filePath, List<String> forbiddenWords, Scanner scanner)
            throws IOException {
        List<String> lines = Files.readAllLines(filePath);
        Map<String, Integer> foundWords = new HashMap<>();
        List<String> censoredLines = new ArrayList<>();

        for (String line : lines) {
            // String originalLine = line;
            String lowerCaseLine = line.toLowerCase();
            for (String word : forbiddenWords) {
                int index = lowerCaseLine.indexOf(word);
                while (index != -1) {
                    foundWords.merge(word, 1, Integer::sum);
                    StringBuilder censoredWord = new StringBuilder("*".repeat(word.length()));
                    line = line.substring(0, index) + censoredWord +
                            line.substring(index + word.length());
                    lowerCaseLine = line.toLowerCase();
                    index = lowerCaseLine.indexOf(word, index + censoredWord.length());
                }
            }
            censoredLines.add(line);
        }

        if (!foundWords.isEmpty()) {
            System.out.println("Файл: " + filePath.getFileName());
            foundWords.forEach((word, count) -> System.out.println("  " + word + ": " + count));

            System.out.print("Замінити заборонені слова в файлі " +
                    filePath.getFileName() + " на '*'? (так/ні): ");
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("так")) {
                Files.write(filePath, censoredLines);
                System.out.println("Файл " + filePath.getFileName() + " виправлено.");
            }
        }
    }
}

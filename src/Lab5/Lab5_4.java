package Lab5;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Lab5_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть шлях до каталогу з файлами: ");
        String sourceDirPath = scanner.nextLine();

        System.out.print("Введіть шлях до каталогу для копіювання файлів: ");
        String targetDirPath = scanner.nextLine();

        try {
            copyFiles(sourceDirPath, targetDirPath);
            System.out.println("Файли успішно скопійовані.");
        } catch (IOException e) {
            System.err.println("Помилка копіювання файлів: " + e.getMessage());
        }
    }

    private static void copyFiles(String sourceDirPath, String targetDirPath) throws IOException {
        Path sourceDir = Paths.get(sourceDirPath);
        Path targetDir = Paths.get(targetDirPath);

        // Створюємо каталог для копіювання, якщо він не існує
        if (!Files.exists(targetDir)) {
            Files.createDirectories(targetDir);
        }

        Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path targetFile = targetDir.resolve(sourceDir.relativize(file));
                Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path newTargetDir = targetDir.resolve(sourceDir.relativize(dir)); // Используем новую переменную
                if (!Files.exists(newTargetDir)) {
                    Files.createDirectories(newTargetDir);
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }
}

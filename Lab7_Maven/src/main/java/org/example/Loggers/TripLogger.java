package org.example.Loggers;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TripLogger {

    private static final String LOG_FILE = "trip_log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(LocalDateTime.now().format(FORMATTER) + " - " + message + "\n");
        } catch (IOException e) {
            System.err.println("Помилка запису до файлу логу: " + e.getMessage());
        }
    }
}
package Lab6.Enums;

import java.util.Random;

public enum AccreditationLevel {
    GENERAL_EDUCATION("Загальноосвітня школа", 300, 800),
    GYMNASIUM("Гімназія", 200, 600),
    LYCEUM("Ліцей", 100, 400);

    private final String displayName;
    private final int minStudents;
    private final int maxStudents;

    AccreditationLevel(String displayName, int minStudents, int maxStudents) {
        this.displayName = displayName;
        this.minStudents = minStudents;
        this.maxStudents = maxStudents;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int generateRandomStudents() {
        Random random = new Random();
        return random.nextInt(maxStudents - minStudents + 1) + minStudents;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
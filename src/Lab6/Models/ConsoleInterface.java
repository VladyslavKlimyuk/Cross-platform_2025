package Lab6.Models;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleInterface {
    private Scanner scanner = new Scanner(System.in);

    private DictionaryManager dictionaryManager;

    public ConsoleInterface() {}

    public ConsoleInterface(DictionaryManager dictionaryManager) {
        this.dictionaryManager = dictionaryManager;
    }

    public DictionaryManager getDictionaryManager() {
        return dictionaryManager;
    }

    public void setDictionaryManager(DictionaryManager dictionaryManager) {
        this.dictionaryManager = dictionaryManager;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleInterface that = (ConsoleInterface) o;
        return Objects.equals(dictionaryManager, that.dictionaryManager);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dictionaryManager);
    }

    public void run() {
        initializeDictionary();
        while (true) {
            displayMenu();
            int choice = userChoice();
            executeAction(choice);
        }
    }

    private void initializeDictionary() {
        System.out.println("Введіть початкові слова та їх переклади" +
                "(англійське слово - український переклад, розділені ' - ').");
        System.out.println("Для завершення введіть 'Кінець'.");
        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("Кінець")) {
            String[] parts = input.split(" - ");
            if (parts.length == 2) {
                dictionaryManager.addWord(parts[0].trim(), parts[1].trim());
            }

            else {
                System.out.println("Невірний формат введення. Спробуйте ще раз.");
            }
        }

        System.out.println("Початковий словник завантажено.");
    }

    private void displayMenu() {
        System.out.println("\nОберіть команду:");
        System.out.println("1. Показати переклад слова");
        System.out.println("2. Додати переклад до слова");
        System.out.println("3. Замінити переклад слова");
        System.out.println("4. Видалити переклад слова");
        System.out.println("5. Додати нове слово");
        System.out.println("6. Замінити існуюче слово (разом з перекладами)");
        System.out.println("7. Видалити слово");
        System.out.println("8. Показати топ-10 найпопулярніших слів");
        System.out.println("9. Показати топ-10 найменш популярних слів");
        System.out.println("0. Вийти");
    }

    private int userChoice() {
        System.out.print("Введіть номер команди: ");
        return scanner.nextInt();
    }

    private void executeAction(int choice) {
        scanner.nextLine();
        switch (choice) {
            case 1:
                displayTranslations();
                break;
            case 2:
                addTranslation();
                break;
            case 3:
                replaceTranslation();
                break;
            case 4:
                removeTranslation();
                break;
            case 5:
                addWord();
                break;
            case 6:
                replaceWord();
                break;
            case 7:
                removeWord();
                break;
            case 8:
                displayTopPopularWords();
                break;
            case 9:
                displayTopUnpopularWords();
                break;
            case 0:
                System.out.println("Програма завершена.");
                System.exit(0);
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
        }
    }

    private void displayTranslations() {
        System.out.print("Введіть англійське слово: ");
        String englishWord = scanner.nextLine().trim();
        List<String> translations = dictionaryManager.getTranslations(englishWord);
        if (translations != null) {
            System.out.println("Переклади для '" + englishWord + "': " + translations);
        }

        else {
            System.out.println("Слово '" + englishWord + "' не знайдено у словнику.");
        }
    }

    private void addTranslation() {
        System.out.print("Введіть англійське слово, до якого хочете додати переклад: ");
        String englishWord = scanner.nextLine().trim();
        if (dictionaryManager.checkWordExists(englishWord)) {
            System.out.print("Введіть новий український переклад: ");
            String newTranslation = scanner.nextLine().trim();
            dictionaryManager.addTranslation(englishWord, newTranslation);
            System.out.println("Переклад '" + newTranslation + "' додано до слова '" + englishWord + "'.");
        }

        else {
            System.out.println("Слово '" + englishWord + "' не знайдено у словнику.");
        }
    }

    private void replaceTranslation() {
        System.out.print("Введіть англійське слово, в якому потрібно замінити переклад: ");
        String englishWord = scanner.nextLine().trim();
        if (dictionaryManager.checkWordExists(englishWord)) {
            List<String> translations = dictionaryManager.getTranslations(englishWord);

            if (translations != null && !translations.isEmpty()) {
                System.out.println("Поточні переклади: " + translations);
                System.out.print("Введіть переклад, який потрібно замінити: ");
                String oldTranslation = scanner.nextLine().trim();
                System.out.print("Введіть новий переклад: ");
                String newTranslation = scanner.nextLine().trim();
                dictionaryManager.replaceTranslation(englishWord, oldTranslation, newTranslation);
                System.out.println("Переклад '" + oldTranslation + "' замінено на '" +
                        newTranslation + "' для слова '" + englishWord + "'.");
            }

            else {
                System.out.println("Для слова '" + englishWord + "' немає перекладів.");
            }
        }

        else {
            System.out.println("Слово '" + englishWord + "' не знайдено у словнику.");
        }
    }

    private void removeTranslation() {
        System.out.print("Введіть англійське слово, з якого потрібно видалити переклад: ");
        String englishWord = scanner.nextLine().trim();
        if (dictionaryManager.checkWordExists(englishWord)) {
            List<String> translations = dictionaryManager.getTranslations(englishWord);

            if (translations != null && !translations.isEmpty()) {
                System.out.println("Поточні переклади: " + translations);
                System.out.print("Введіть переклад, який потрібно видалити: ");
                String translationToRemove = scanner.nextLine().trim();
                dictionaryManager.removeTranslation(englishWord, translationToRemove);
                System.out.println("Переклад '" + translationToRemove + "' видалено зі слова '"
                        + englishWord + "'.");
            }

            else {
                System.out.println("Для слова '" + englishWord + "' немає перекладів.");
            }
        }

        else {
            System.out.println("Слово '" + englishWord + "' не знайдено у словнику.");
        }
    }

    private void addWord() {
        System.out.print("Введіть нове англійське слово: ");
        String newEnglishWord = scanner.nextLine().trim();
        if (!dictionaryManager.checkWordExists(newEnglishWord)) {
            System.out.print("Введіть український переклад для '" + newEnglishWord +
                    "' (через кому, якщо їх декілька): ");
            String translationsInput = scanner.nextLine().trim();
            dictionaryManager.addWord(newEnglishWord, translationsInput);
            System.out.println("Слово '" + newEnglishWord + "' та його переклади додано до словника.");
        }

        else {
            System.out.println("Слово '" + newEnglishWord + "' вже існує у словнику.");
        }
    }

    private void replaceWord() {
        System.out.print("Введіть англійське слово, яке потрібно замінити: ");
        String oldEnglishWord = scanner.nextLine().trim();
        if (dictionaryManager.checkWordExists(oldEnglishWord)) {
            System.out.print("Введіть нове англійське слово: ");
            String newEnglishWord = scanner.nextLine().trim();
            System.out.print("Введіть українські переклади для '" + newEnglishWord +
                    "' (через кому, якщо їх декілька): ");
            String translationsInput = scanner.nextLine().trim();
            dictionaryManager.replaceWord(oldEnglishWord, newEnglishWord, translationsInput);
            System.out.println("Слово '" + oldEnglishWord + "' замінено на '" + newEnglishWord + "'.");
        }

        else {
            System.out.println("Слово '" + oldEnglishWord + "' не знайдено у словнику.");
        }
    }

    private void removeWord() {
        System.out.print("Введіть англійське слово, яке потрібно видалити: ");
        String englishWordToRemove = scanner.nextLine().trim();
        if (dictionaryManager.checkWordExists(englishWordToRemove)) {
            dictionaryManager.removeWord(englishWordToRemove);
            System.out.println("Слово '" + englishWordToRemove + "' видалено зі словника.");
        }

        else {
            System.out.println("Слово '" + englishWordToRemove + "' не знайдено у словнику.");
        }
    }

    private void displayTopPopularWords() {
        List<Map.Entry<String, Integer>> topWords = dictionaryManager.getTopPopularWords(10);
        if (!topWords.isEmpty()) {
            System.out.println("\nТоп-10 найпопулярніших слів:");

            for (Map.Entry<String, Integer> entry : topWords) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " звернень");
            }
        }

        else {
            System.out.println("Словник порожній, або ще не було жодного звернення до слів.");
        }
    }

    private void displayTopUnpopularWords() {
        List<Map.Entry<String, Integer>> topWords = dictionaryManager.getTopUnpopularWords(10);
        if (!topWords.isEmpty()) {
            System.out.println("\nТоп-10 найменш популярних слів:");

            for (Map.Entry<String, Integer> entry : topWords) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " звернень");
            }
        }

        else {
            System.out.println("Словник порожній, або ще не було жодного звернення до слів.");
        }
    }
}
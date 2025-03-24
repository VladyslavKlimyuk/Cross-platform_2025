package Lab5;

import java.io.*;
import java.util.*;

import Lab5.Models.Employee;

public class Lab5_3 {
    static List<Employee> employees = new ArrayList<>();
    static String filePath = "./src/Lab5/Files/Employees.dat";
    static boolean dataChanged = false;

    public static void main(String[] args) {
        loadEmployeesFromFile();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати співробітника");
            System.out.println("2. Редагувати співробітника");
            System.out.println("3. Видалити співробітника");
            System.out.println("4. Пошук співробітника за прізвищем");
            System.out.println("5. Вивести всіх співробітників (за віком)");
            System.out.println("6. Вивести всіх співробітників (за літерою прізвища)");
            System.out.println("7. Зберегти звіт у файл");
            System.out.println("8. Зберегти зміни у файл");
            System.out.println("9. Вийти");

            System.out.println("Введіть номер команди: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    editEmployee(scanner);
                    break;
                case 3:
                    deleteEmployee(scanner);
                    break;
                case 4:
                    searchEmployee(scanner);
                    break;
                case 5:
                    printEmployeesByAge();
                    break;
                case 6:
                    printEmployeesByLetter(scanner);
                    break;
                case 7:
                    saveReportToFile(scanner);
                    break;
                case 8:
                    saveEmployeesToFile();
                    break;
                case 9:
                    exitProgram();
                    return;
                default:
                    System.out.println("Невірний вибір.");
            }
        }
    }

    private static void loadEmployeesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Файл не знайдено або пошкоджено. Створено новий список співробітників.");
        }
    }

    private static void saveEmployeesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employees);
            dataChanged = false;
            System.out.println("Дані збережено у файл.");
        } catch (IOException e) {
            System.err.println("Помилка збереження даних: " + e.getMessage());
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Введіть прізвище: ");
        String surname = scanner.nextLine();
        System.out.print("Введіть ім'я: ");
        String name = scanner.nextLine();
        System.out.print("Введіть вік: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введіть посаду: ");
        String position = scanner.nextLine();

        employees.add(new Employee(surname, name, age, position));
        dataChanged = true;
        System.out.println("Співробітника додано.");
    }

    private static void editEmployee(Scanner scanner) {
        System.out.print("Введіть прізвище співробітника для редагування: ");
        String surname = scanner.nextLine();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getSurname().equalsIgnoreCase(surname)) {
                System.out.println("Редагування співробітника: " + employees.get(i));
                System.out.print("Введіть нове ім'я: ");
                employees.get(i).setName(scanner.nextLine());
                System.out.print("Введіть новий вік: ");
                employees.get(i).setAge(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Введіть нову посаду: ");
                employees.get(i).setPosition(scanner.nextLine());
                dataChanged = true;
                System.out.println("Співробітника відредаговано.");
                return;
            }
        }
        System.out.println("Співробітника з таким прізвищем не знайдено.");
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Введіть прізвище співробітника для видалення: ");
        String surname = scanner.nextLine();

        employees.removeIf(employee -> employee.getSurname().equalsIgnoreCase(surname));
        dataChanged = true;
        System.out.println("Співробітника видалено.");
    }

    private static void searchEmployee(Scanner scanner) {
        System.out.print("Введіть прізвище для пошуку: ");
        String surname = scanner.nextLine();

        employees.stream()
                .filter(employee -> employee.getSurname().equalsIgnoreCase(surname))
                .forEach(System.out::println);
    }

    private static void printEmployeesByAge() {
        employees.stream()
                .sorted(Comparator.comparingInt(employee -> employee.getAge()))
                .forEach(System.out::println);
    }

    private static void printEmployeesByLetter(Scanner scanner) {
        System.out.print("Введіть першу літеру прізвища: ");
        String letter = scanner.nextLine().toUpperCase();

        employees.stream()
                .filter(employee -> employee.getSurname().toUpperCase().startsWith(letter))
                .forEach(System.out::println);
    }

    private static void saveReportToFile(Scanner scanner) {
        System.out.print("Введіть ім'я файлу для звіту: ");
        String reportFileName = scanner.nextLine();

        String folderPath = "src/Lab5/Files";

        File folder = new File(folderPath);

        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                System.err.println("Помилка створення папки: " + folderPath);
                return;
            }
        }

        File reportFile = new File(folder, reportFileName);

        try (PrintWriter writer = new PrintWriter(reportFile)) {
            employees.forEach(writer::println);
            System.out.println("Звіт збережено у файл: " + reportFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.err.println("Помилка збереження звіту: " + e.getMessage());
        }
    }

    private static void exitProgram() {
        if (dataChanged) {
            saveEmployeesToFile();
        }
        System.out.println("Програма завершена.");
    }
}

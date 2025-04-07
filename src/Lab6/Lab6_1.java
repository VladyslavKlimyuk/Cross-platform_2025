package Lab6;

import Lab6.Models.User;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Lab6_1 {

    private static Map<String, User> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = userChoice();
            executeAction(choice);
        }
    }

    private static void displayMenu() {
        System.out.println("\nОберіть команду:");
        System.out.println("1. Додати нового користувача");
        System.out.println("2. Видалити існуючого користувача");
        System.out.println("3. Перевірити чи існує користувач");
        System.out.println("4. Змінити логін існуючого користувача");
        System.out.println("5. Змінити пароль користувача");
        System.out.println("0. Вийти");
    }

    private static int userChoice() {
        System.out.print("Введіть номер команди: ");
        return scanner.nextInt();
    }

    private static void executeAction(int choice) {
        scanner.nextLine();
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                removeUser();
                break;
            case 3:
                checkUserExists();
                break;
            case 4:
                changeLogin();
                break;
            case 5:
                changePassword();
                break;
            case 0:
                System.out.println("Програма завершена.");
                System.exit(0);
            default:
                System.out.println("Невірний вибір. Спробуйте ще раз.");
        }
    }

    private static void addUser() {
        System.out.print("Введіть логін нового користувача: ");
        String login = scanner.nextLine();
        System.out.print("Введіть пароль для користувача " + login + ": ");
        String password = scanner.nextLine();
        if (users.containsKey(login)) {
            System.out.println("Користувач з таким логіном вже існує.");
        }

        else {
            User newUser = new User(login, password);
            users.put(login, newUser);
            System.out.println("Користувача " + login + " додано.");
        }
    }

    private static void removeUser() {
        System.out.print("Введіть логін користувача, якого потрібно видалити: ");
        String loginToRemove = scanner.nextLine();
        if (users.containsKey(loginToRemove)) {
            users.remove(loginToRemove);
            System.out.println("Користувача " + loginToRemove + " видалено.");
        }

        else {
            System.out.println("Користувача з таким логіном не знайдено.");
        }
    }

    private static void checkUserExists() {
        System.out.print("Введіть логін користувача для перевірки: ");
        String loginToCheck = scanner.nextLine();
        if (users.containsKey(loginToCheck)) {
            System.out.println("Користувач з логіном " + loginToCheck + " існує.");
        }

        else {
            System.out.println("Користувача з логіном " + loginToCheck + " не знайдено.");
        }
    }

    private static void changeLogin() {
        System.out.print("Введіть поточний логін користувача, який потрібно змінити: ");
        String oldLogin = scanner.nextLine();
        if (users.containsKey(oldLogin)) {
            System.out.print("Введіть новий логін: ");
            String newLogin = scanner.nextLine();

            if (users.containsKey(newLogin)) {
                System.out.println("Користувач з таким новим логіном вже існує.");
            }

            else {
                User userToUpdate = users.get(oldLogin);
                userToUpdate.setLogin(newLogin);
                users.remove(oldLogin);
                users.put(newLogin, userToUpdate);
                System.out.println("Логін користувача " + oldLogin + " змінено на " + newLogin + ".");
            }
        }

        else {
            System.out.println("Користувача з логіном " + oldLogin + " не знайдено.");
        }
    }

    private static void changePassword() {
        System.out.print("Введіть логін користувача, пароль якого потрібно змінити: ");
        String loginToChangePassword = scanner.nextLine();
        if (users.containsKey(loginToChangePassword)) {
            System.out.print("Введіть новий пароль для користувача " + loginToChangePassword + ": ");
            String newPassword = scanner.nextLine();
            User userToUpdate = users.get(loginToChangePassword);
            userToUpdate.setPassword(newPassword);
            System.out.println("Пароль користувача " + loginToChangePassword + " змінено.");
        }

        else {
            System.out.println("Користувача з логіном " + loginToChangePassword + " не знайдено.");
        }
    }
}
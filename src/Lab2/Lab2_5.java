package Lab2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab2_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть адреси електронної пошти: ");
        String email = scanner.nextLine();
        String result = removeRuEmails(email);
        System.out.println("Доступні адреси електронної пошти: " + result);
    }

    public static String removeRuEmails(String email) {
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.ru\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.replaceAll("");
    }
}

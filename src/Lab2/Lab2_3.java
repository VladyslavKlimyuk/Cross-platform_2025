package Lab2;

import java.util.Scanner;

public class Lab2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть пароль: ");
        String password = scanner.nextLine();
        if(isPasswordStrong(password) == true) {
            System.out.println("Чи сильний пароль? Так.");
        }
        else {
            System.out.println("Чи сильний пароль? Ні.");
        }
    }

    public static boolean isPasswordStrong(String password) {
        if (password == null && password.length() < 8) {
            return false;
        }

        boolean hasBigSymbol = false;
        boolean hasSmallSymbol = false;
        boolean hasNumber = false;
        boolean hasOtherSymbol = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasBigSymbol = true;
            } else if (Character.isLowerCase(c)) {
                hasSmallSymbol = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (c == '!' || c == '*' || c == '_') {
                hasOtherSymbol = true;
            }
        }

        return hasBigSymbol && hasSmallSymbol && hasNumber && hasOtherSymbol;
    }
}

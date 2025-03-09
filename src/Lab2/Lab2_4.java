package Lab2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть англійські слова, які закінчуються на 'tion' та знаками ( , | . | ! | : | ; ): ");
        String word = scanner.nextLine();
        String pattern = "[A-Z][a-zA-Z]{0,8}tion[,.!:;]";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(word);

        System.out.println("Слова, що відповідають умові відбору: ");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}

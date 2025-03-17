package Lab3;

import Lab3.Models.Person;
import Lab3.Models.Article;
import Lab3.Models.Magazine;
import Lab3.Enums.Frequency;

import java.time.LocalDate;

public class Lab3_2 {
    public static void main(String[] args) {
        LocalDate birthDate = LocalDate.of(1996, 7, 31);
        LocalDate releaseDate = LocalDate.of(2025, 3, 13);
        Person person = new Person("Коваленко", "Андрій", birthDate);
        Article[] article = {
                new Article(person, "Основи мови програмування Java", 4.93)
        };
        Magazine magazine = new Magazine("Програмування", Frequency.Monthly, releaseDate,
                1000, article);

        System.out.println("Інформація про людину: " + person);
        System.out.print("Інформація про статтю: ");
        for (Article articleItem : article) {
            System.out.println(articleItem.toString());
        }
        System.out.println("Інформація про журнал: " + magazine);
    }
}
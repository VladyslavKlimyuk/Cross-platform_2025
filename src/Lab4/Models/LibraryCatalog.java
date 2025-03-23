package Lab4.Models;

import Lab4.Interfaces.ILibraryItem;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class LibraryCatalog {
    private List<ILibraryItem> items;

    public LibraryCatalog() {
        items = new ArrayList<>();
    }

    // Тестова ініціалізація
    public void initializeTestData() {
        items.add(new Book("Маленький принц", "Антуан де Сент-Екзюпері", "Фентезі", 96));
        items.add(new Newspaper("Українська правда", "2023-10-27",
                List.of("Новини", "Політика", "Спорт")));
        items.add(new Almanac("Сучасна поезія", List.of(
                new Book("Вірші", "Ліна Костенко", "Поезія", 100),
                new Book("Вірші", "Тарас Шевченко", "Поезія", 120)
        )));
    }

    // Додавання об'єкта конкретного типу
    public void addItem(ILibraryItem item) {
        items.add(item);
    }

    // Додавання об'єкта випадкового типу
    public void addRandomItem() {
        Random random = new Random();
        int type = random.nextInt(3);
        switch (type) {
            case 0:
                items.add(new Book("Випадкова книга", "Випадковий автор",
                        "Випадковий жанр", random.nextInt(500) + 50));
                break;
            case 1:
                items.add(new Newspaper("Випадкова газета", "2023-10-27",
                        List.of("Випадковий заголовок 1", "Випадковий заголовок 2")));
                break;
            case 2:
                items.add(new Almanac("Випадковий альманах", List.of(
                        new Book("Випадкова книга 1", "Випадковий автор 1",
                                "Випадковий жанр 1", random.nextInt(500) + 50),
                        new Book("Випадкова книга 2", "Випадковий автор 2",
                                "Випадковий жанр 2", random.nextInt(500) + 50)
                )));
                break;
        }
    }

    // Видалення об'єкта за назвою
    public void removeItem(String title) {
        items.removeIf(item -> item.getTitle().equals(title));
    }

    // Виведення всього каталогу на екран
    public void displayCatalog() {
        for (ILibraryItem item : items) {
            System.out.println(item);
        }
    }

    // Пошук за назвою книги або газети
    public void searchByTitle(String title) {
        items.stream()
                .filter(item -> item.getTitle().equals(title))
                .forEach(System.out::println);
    }

    // Пошук за автором
    public void searchByAuthor(String author) {
        items.stream()
                .filter(item -> {
                    if (item instanceof Book) {
                        return item.getAuthor() != null && item.getAuthor().equals(author);
                    } else if (item instanceof Almanac) {
                        return ((Almanac) item).getWorks().stream()
                                .anyMatch(book -> book.getAuthor() != null && book.getAuthor().equals(author));
                    }
                    return false;
                })
                .forEach(System.out::println);
    }
}

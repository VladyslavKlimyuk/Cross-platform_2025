package Lab4;

import Lab4.Models.LibraryCatalog;

public class Lab4_3 {
    public static void main(String[] args) {
        LibraryCatalog catalog = new LibraryCatalog();
        catalog.initializeTestData();
        catalog.displayCatalog();

        System.out.println("\nДодаємо випадковий елемент:");
        catalog.addRandomItem();
        catalog.displayCatalog();

        System.out.println("\nВидаляємо книгу 'Маленький принц':");
        catalog.removeItem("Маленький принц");
        catalog.displayCatalog();

        System.out.println("\nШукаємо книгу за автором 'Ліна Костенко':");
        catalog.searchByAuthor("Ліна Костенко");
    }
}

package Lab4.Models;

import Lab4.Interfaces.ILibraryItem;
import java.util.List;

public class Book implements ILibraryItem {
    private String title;
    private String author;
    private String genre;
    private int pages;

    public Book(String title, String author, String genre, int pages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public int getPages() {
        return pages;
    }

    @Override
    public String getReleaseDate() {
        return null;
    }

    @Override
    public List<String> getHeadlines() {
        return null;
    }

    @Override
    public List<Book> getWorks() {
        return null;
    }

    @Override
    public String getType() {
        return "Книга";
    }

    @Override
    public String toString() {
        return String.format("Назва: %s, Автор: %s, Жанр: %s, Сторінки: %d",
                title, author, genre, pages);
    }
}

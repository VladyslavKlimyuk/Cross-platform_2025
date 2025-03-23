package Lab4.Models;

import Lab4.Interfaces.ILibraryItem;
import java.util.List;

public class Newspaper implements ILibraryItem {
    private String title;
    private String releaseDate;
    private List<String> headlines;

    public Newspaper(String title, String releaseDate, List<String> headlines) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.headlines = headlines;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public String getGenre() {
        return null;
    }

    @Override
    public int getPages() {
        return 0;
    }

    @Override
    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public List<String> getHeadlines() {
        return headlines;
    }

    @Override
    public List<Book> getWorks() {
        return null;
    }

    @Override
    public String getType() {
        return "Газета";
    }

    @Override
    public String toString() {
        return String.format("Газета: Назва: '%s', Дата виходу: '%s', Заголовки: %s",
                title, releaseDate, headlines);
    }
}

package Lab4.Models;

import Lab4.Interfaces.ILibraryItem;
import java.util.List;

public class Almanac implements ILibraryItem {
    private String title;
    private List<Book> works;

    public Almanac(String title, List<Book> works) {
        this.title = title;
        this.works = works;
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
        return null;
    }

    @Override
    public List<String> getHeadlines() {
        return null;
    }

    @Override
    public List<Book> getWorks() {
        return works;
    }

    @Override
    public String getType() {
        return "Альманах";
    }

    @Override
    public String toString() {
        return String.format("Альманах: Назва: '%s', Твори: %s",
                title, works);
    }
}

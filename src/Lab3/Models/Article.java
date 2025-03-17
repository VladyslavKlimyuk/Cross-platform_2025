package Lab3.Models;

public class Article {
    private Person author;
    private String articleName;
    private double articleRate;

    public Person getAuthor() {
        return author;
    }

    public String getArticleName() {
        return articleName;
    }

    public double getArticleRate() {
        return articleRate;
    }

    public Article() {}

    public Article(Person author, String articleName, double articleRate) {
        this.author = author;
        this.articleName = articleName;
        this.articleRate = articleRate;
    }

    @Override
    public String toString() {
        return author + ", " + articleName + ", " + articleRate;
    }
}
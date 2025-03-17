package Lab3.Models;

import Lab3.Enums.Frequency;

import java.time.LocalDate;

public class Magazine {
    private String magazineName;
    private Frequency magazinePublicationFrequency; // періодичність виходу журнала
    private LocalDate releaseDate; // дата виходу журнала
    private int circulation; // тираж журналу
    private Article[] articleList;

    public String getMagazineName() {
        return magazineName;
    }

    public Frequency getMagazinePublicationFrequency() {
        return magazinePublicationFrequency;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getCirculation() {
        return circulation;
    }

    public Article[] getArticleList() {
        return articleList;
    }

    public Magazine() {}

    public Magazine(String magazineName, Frequency magazinePublicationFrequency,
                    LocalDate releaseDate, int circulation, Article[] articleList) {
        this.magazineName = magazineName;
        this.magazinePublicationFrequency = magazinePublicationFrequency;
        this.releaseDate = releaseDate;
        this.circulation = circulation;
        this.articleList = articleList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(magazineName).append(", частота виходу: ").append(magazinePublicationFrequency)
                .append(", дата виходу: ").append(releaseDate).append(", тираж: ").append(circulation)
                .append(", наявні статті:\n");
        if (articleList != null) {
            for (Article article : articleList) {
                sb.append("- ").append(article.toString()).append("\n");
            }
        } else {
            sb.append("Статті відсутні.\n");
        }
        return sb.toString();
    }
}
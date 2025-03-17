package Lab3.Models;

public class MusicalInstrument {
    private String sound; // видає звук музичного інструменту
    private String show; // відображає назву музичного інструменту
    private String desc; // відображає опис музичного інструменту
    private String history; // відображає історію створення музичного інструменту

    public String getSound() {
        return sound;
    }

    public String getShow() {
        return show;
    }

    public String getDesc() {
        return desc;
    }

    public String getHistory() {
        return history;
    }

    public MusicalInstrument() {}

    public MusicalInstrument(String show, String desc, String sound, String history) {
        this.show = show;
        this.desc = desc;
        this.sound = sound;
        this.history = history;
    }

    public void Show() {
        System.out.println("Назва музичного інструменту: " + show);
    }

    public void Desc() {
        System.out.println("Опис музичного інструменту: " + desc);
    }

    public void Sound() {
        System.out.println("Звук музичного інструменту: " + sound);
    }

    public void History() {
        System.out.println("Історія створення музичного інструменту: " + history + "\n");
    }
}
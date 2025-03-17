package Lab3;

import Lab3.Models.Violin;
import Lab3.Models.Trombone;
import Lab3.Models.Ukulele;
import Lab3.Models.Cello;

public class Lab3_4 {
    public static void main(String[] args) {
        Violin violin = new Violin();
        violin.Show();
        violin.Desc();
        violin.Sound();
        violin.History();

        Trombone trombone = new Trombone();
        trombone.Show();
        trombone.Desc();
        trombone.Sound();
        trombone.History();

        Ukulele ukulele = new Ukulele();
        ukulele.Show();
        ukulele.Desc();
        ukulele.Sound();
        ukulele.History();

        Cello cello = new Cello();
        cello.Show();
        cello.Desc();
        cello.Sound();
        cello.History();
    }
}
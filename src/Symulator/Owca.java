package Symulator;

import java.awt.Color;

public class Owca extends Zwierze{
    public Owca(Swiat s, int x, int y) {
        swiat = s;
        sila = 4;
        this.x = x;
        this.y = y;
        inicjatywa = 4;
        poruszony = false;
        nowy=true;
        kolor = new Color(235, 235, 235);
        typ="owca";
        System.out.println("Owca się urodziła");
    }
}

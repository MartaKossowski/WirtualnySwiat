package Symulator;

import java.awt.Color;

public class Trawa extends Roslina{
    
     public Trawa(Swiat s, int x, int y) {
        swiat = s;
        sila = 0;
        this.x = x;
        this.y = y;
        inicjatywa = 0;
        poruszony = false;
        nowy=false;
        kolor = Color.GREEN;
        typ="trawa";
        System.out.println("Trawa wykiełkowała.");
    }
    
    @Override
    void kolizja(Organizm o) {
     o.kolizja(this);
    }
}
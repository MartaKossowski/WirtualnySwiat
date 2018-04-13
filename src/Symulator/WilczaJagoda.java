package Symulator;

import java.awt.Color;

public class WilczaJagoda extends Roslina{

    public WilczaJagoda(Swiat s, int x, int y) {
        swiat = s;
        sila = 99;
        this.x = x;
        this.y = y;
        inicjatywa = 0;
        poruszony = false;
        nowy=false;
        kolor = new Color(77, 0, 153);
        typ="jagoda";
        System.out.println("Wilcza jagoda wykiełkowała.");
    }
    
    @Override
    void kolizja(Organizm o){
        o.typ="martwy";
        typ="martwy";
    }  
}

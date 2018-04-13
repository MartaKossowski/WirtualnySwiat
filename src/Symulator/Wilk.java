package Symulator;

import java.awt.Color;

public class Wilk extends Zwierze {

    public Wilk(Swiat s, int x, int y) {
        swiat = s;
        sila = 4;
        this.x = x;
        this.y = y;
        inicjatywa = 5;
        poruszony = false;
        nowy=true;
        kolor = Color.GRAY;
        typ="wilk";
        System.out.println("Wilk się urodził");
    }    
}
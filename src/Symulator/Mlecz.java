package Symulator;

import java.awt.Color;

public class Mlecz extends Roslina {

    public Mlecz(Swiat s, int x, int y) {
        swiat = s;
        sila = 0;
        this.x = x;
        this.y = y;
        inicjatywa = 0;
        poruszony = false;
        nowy=false;
        kolor = Color.YELLOW;
        typ="mlecz";
        System.out.println("Mlecz wykiełkował.");
    }
    
    @Override
    void akcja() {
        
        for (int i=0; i<3; i++){
            super.akcja();
        }
    }
}
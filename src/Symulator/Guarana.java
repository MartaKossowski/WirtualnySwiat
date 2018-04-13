package Symulator;

import java.awt.Color;

public class Guarana extends Roslina {

    public Guarana(Swiat s, int x, int y) {
        swiat = s;
        sila = 0;
        this.x = x;
        this.y = y;
        inicjatywa = 0;
        poruszony = false;
        nowy=false;
        kolor = Color.RED;
        typ="guarana";
        System.out.println("Guarana wykiełkowała.");
    }
    
    @Override
    void kolizja(Organizm o){
        o.sila+=3;
        typ="martwy";
    }
}

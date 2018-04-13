package Symulator;

import Okna.OknoGry;

public class main {

    public static void main(String[] args) throws InterruptedException {

        Swiat swiat = new Swiat(20,20); // m szer, n wys
        OknoGry okno = new OknoGry(swiat);
        swiat.losuj();
        while (swiat.zwrocKoniec() == false) {
           okno.repaint();
           if (swiat.zwrocPauze() == false) {
                swiat.wykonajTure();             
            }            
            Thread.sleep(5);
        }
    }
}

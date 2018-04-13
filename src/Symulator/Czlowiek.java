package Symulator;

import java.awt.Color;
import java.util.Random;
import Okna.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Czlowiek extends Zwierze {

    OknoGry okno;
    private int szerokoscKroku = 1; 

    public Czlowiek(Swiat s, int x, int y, OknoGry o) {
        sila = 5;
        this.x = x;
        this.y = y;
        inicjatywa = 4;
        umiejetnosc = 5;
        swiat = s;
        poruszony = false;
        kolor = Color.PINK;
        okno = o;
        typ = "czlowiek";
        System.out.println("Człowiek się urodził");
    }
    
    public void setOkno(OknoGry o){
        this.okno=o;
    }
   
    public void sprawdzStanUmiejetnosci(){
     
        if(swiat.getTrwanieUmiejetnosci() >= 3){
            szerokoscKroku = 2;
        }else if (swiat.getTrwanieUmiejetnosci() == 0){
            szerokoscKroku = 1;
        }else if(swiat.getTrwanieUmiejetnosci() == 2 || swiat.getTrwanieUmiejetnosci() == 1){
            //ma 50% szansy na to że umiejetnosc zadziała
            Random r = new Random();
            int szansa = r.nextInt(1);
            
            if(szansa == 1){
                szerokoscKroku = 2;
            }else{
                szerokoscKroku = 1;
            }
        }
        
        if(swiat.getTrwanieUmiejetnosci() > -5){
            swiat.zmniejszCzasUmiejetnosci();
        }
    }
    
    public void akcja() { //implementacja ruchu
        boolean poruszone = false;
        
        if (okno != null) {
            okno.requestFocus();
        }
        
        while (!poruszone) {
            switch (swiat.zwrocKierunek()) {
                case 0:
                    if (x >= szerokoscKroku) {
                        swiat.przesunOrganizm(x, y, x - szerokoscKroku, y);
                        poruszone = true;
                    }
                    break;
                case 1:
                    if (x < swiat.getWysokosc() - szerokoscKroku) {
                        swiat.przesunOrganizm(x, y, x + szerokoscKroku, y);
                        poruszone = true;
                    }
                    break;
                case 2:
                    if (y >= szerokoscKroku) {
                        swiat.przesunOrganizm(x, y, x, y - szerokoscKroku);
                        poruszone = true;
                    }
                    break;
                case 3:
                    if (y < swiat.getSzerokosc() - szerokoscKroku) {
                        swiat.przesunOrganizm(x, y, x, y + szerokoscKroku);
                        poruszone = true;
                    }
                    break;
            }

            if (okno != null) {
                okno.repaint();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Czlowiek.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        sprawdzStanUmiejetnosci();
    }
}

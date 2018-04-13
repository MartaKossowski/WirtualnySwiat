package Symulator;

import java.awt.Color;
import java.util.Random;

public class Zolw extends Zwierze {

    public Zolw(Swiat s, int x, int y) {
        swiat = s;
        sila = 2;
        this.x = x;
        this.y = y;
        inicjatywa = 1;
        poruszony = false;
        nowy = true;
        kolor = new Color(153, 153, 0);
        typ = "zolw";
        System.out.println("Żółw się urodził.");
    }

    @Override
    public void akcja() { //implementacja ruchu
        Random r = new Random();
        if(r.nextInt(4)== 0){
            super.akcja();
        }
    }
    
    @Override
    public void kolizja(Organizm o) {
        if (this.typ.endsWith(o.typ)) {
            if (x > 0 && x < swiat.getWysokosc() - 1) {
                if (swiat.zwrocOrganizm(x + 1, y) == null) {
                    rozmnazanie(typ, x + 1, y);
                } else if (swiat.zwrocOrganizm(x - 1, y) == null) {
                    rozmnazanie(typ, x - 1, y);
                }
            } else if (x > 0) {
                if (swiat.zwrocOrganizm(x - 1, y) == null) {
                    rozmnazanie(typ, x - 1, y);
                }
            } else if (x < swiat.getWysokosc() - 1) {
                if (swiat.zwrocOrganizm(x + 1, y) == null) {
                    rozmnazanie(typ, x + 1, y);
                }
            } 
            else if (y > 0 && y < swiat.getSzerokosc() - 1) {
                if (swiat.zwrocOrganizm(x, y + 1) == null) {
                    rozmnazanie(typ, x, y + 1);
                } else if (swiat.zwrocOrganizm(x, y - 1) == null) {
                    rozmnazanie(typ, x, y - 1);
                }
            } else if (y > 0) {
                if (swiat.zwrocOrganizm(x, y - 1) == null) {
                    rozmnazanie(typ, x, y - 1);
                }
            } else if (y < swiat.getSzerokosc() - 1) {
                if (swiat.zwrocOrganizm(x, y + 1) == null) {
                    rozmnazanie(typ, x, y + 1);
                }
            }
        }
        else {
            if (o.sila<5){
                //zolw odpiera atak
            }
            else {
                int x_atakujacy=o.x;
                int y_atakujacy=o.y;
                int temp_x=x;
                int temp_y=y;
                
                KontenerOrganizmow kontener = swiat.zwrocKontener();
                
                kontener.usunOrganizm(x,y);
                kontener.wpiszOrganizm(x_atakujacy, y_atakujacy, temp_x, temp_y);
                Organizm organizm = kontener.zwrocOrganizm(temp_x,temp_y);
                organizm.setX(temp_x);
                organizm.setY(temp_y);
                kontener.usunOrganizm(x_atakujacy, y_atakujacy);
                
                if (temp_x -x_atakujacy <= -1 || temp_y - y_atakujacy <= -1) {
                } else {
                    organizm = kontener.zwrocOrganizm(temp_x,temp_y);
                    organizm.poruszony = true;
                }
            }
        }
    }
}

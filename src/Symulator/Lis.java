package Symulator;

import java.awt.Color;
import java.util.Random;

public class Lis extends Zwierze {

    public Lis(Swiat s, int x, int y) {
        swiat = s;
        sila = 3;
        this.x = x;
        this.y = y;
        inicjatywa = 7;
        poruszony = false;
        nowy = true;
        kolor = new Color(255, 198, 26);
        typ = "lis";
        System.out.println("Lis się urodził");
    }

    @Override
    public void akcja() { //implementacja ruchu
        boolean poruszone = false;
        Random r = new Random();

        while (!poruszone) {
            KontenerOrganizmow kontener = swiat.zwrocKontener();
            Organizm organizm = kontener.zwrocOrganizm(x,y);
            switch (r.nextInt(4)) {
                case 0:
                    if (x > 0) {
                       organizm = kontener.zwrocOrganizm(x-1,y);
                        if (organizm != null) {
                           
                            if (organizm.getSila() <= sila) {
                                swiat.przesunOrganizm(x, y, x - 1, y);
                                poruszone = true;
                            } else {
                                poruszone=true;
                            }
                        } else {
                            swiat.przesunOrganizm(x, y, x - 1, y);
                                poruszone = true;
                        }
                    }
                    break;
                case 1:
                    if (x < swiat.getWysokosc() - 1) {
                        organizm = kontener.zwrocOrganizm(x+1,y);
                        if (organizm != null) {
                            if (organizm.getSila() <= sila) {
                                swiat.przesunOrganizm(x, y, x + 1, y);
                                poruszone = true;
                            } else {
                                poruszone=true;
                            }
                        } else {
                            swiat.przesunOrganizm(x, y, x + 1, y);
                                poruszone = true;
                        }
                    }
                    break;
                case 2:
                    if (y > 0) {
                        organizm = kontener.zwrocOrganizm(x,y-1);
                       if (organizm != null) {
                            if (organizm.getSila() <= sila) {
                                swiat.przesunOrganizm(x, y, x, y-1);
                                poruszone = true;
                            } else {
                                poruszone=true;
                            }
                        } else {
                            swiat.przesunOrganizm(x, y, x, y-1);
                                poruszone = true;
                        }
                    }
                    break;
                case 3:
                    if (y < swiat.getSzerokosc() - 1) {
                        organizm = kontener.zwrocOrganizm(x,y+1);
                         if (organizm != null) {
                            if (organizm.getSila() <= sila) {
                                swiat.przesunOrganizm(x, y, x, y+1);
                                poruszone = true;
                            } else {
                                poruszone=true;
                            }
                        } else {
                            swiat.przesunOrganizm(x, y, x, y+1);
                                poruszone = true;
                        }
                    }
                    break;
            }
        }
    }
}
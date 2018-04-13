/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symulator;

import java.awt.Color;
import java.util.Random;

public class Antylopa extends Zwierze {
    
     public Antylopa(Swiat s, int x, int y) {
        swiat = s;
        sila = 4;
        this.x = x;
        this.y = y;
        inicjatywa = 4;
        poruszony = false;
        nowy=true;
        kolor = new Color(255,242,189);
        typ="antylopa";
        System.out.println("Antylopa się urodziła.");
    }
    
     @Override
    public void akcja() { //implementacja ruchu
        boolean poruszone = false;
        Random r = new Random();

        while (!poruszone) {
            switch (r.nextInt(4)) {
                case 0:
                    if (x > 1) {
                        swiat.przesunOrganizm(x, y, x - 2, y);
                        poruszone = true;
                    }
                    break;
                case 1:
                    if (x < swiat.getWysokosc() - 2) {
                        swiat.przesunOrganizm(x, y, x + 2, y);
                        poruszone = true;
                    }
                    break;
                case 2:
                    if (y > 1) {
                        swiat.przesunOrganizm(x, y, x, y - 2);
                        poruszone = true;
                    }
                    break;
                case 3:
                    if (y < swiat.getSzerokosc() - 2) {
                        swiat.przesunOrganizm(x, y, x, y + 2);
                        poruszone = true;
                    }
                    break;
            }
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
            } //
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
            Random r = new Random(); //szansa na ucieczkę
            if (sila>o.sila){
                if (r.nextInt(2)==0){ //szansa na ucieczkę
                KontenerOrganizmow kontener = swiat.zwrocKontener();
                kontener.usunOrganizm(o.x, o.y);
                }
                else{
                    if (x > 0 && x < swiat.getWysokosc() - 1) {
                if (swiat.zwrocOrganizm(x + 1, y) == null) {
                    swiat.przesunOrganizm(x, y, x + 1, y);
                } else if (swiat.zwrocOrganizm(x - 1, y) == null) {
                    swiat.przesunOrganizm(x, y, x - 1, y);
                }
            } else if (x > 0) {
                if (swiat.zwrocOrganizm(x - 1, y) == null) {
                    swiat.przesunOrganizm(x, y, x - 1, y);
                }
            } else if (x < swiat.getWysokosc() - 1) {
                if (swiat.zwrocOrganizm(x + 1, y) == null) {
                    swiat.przesunOrganizm(x, y, x + 1, y);
                }
            } //
            else if (y > 0 && y < swiat.getSzerokosc() - 1) {
                if (swiat.zwrocOrganizm(x, y + 1) == null) {
                    swiat.przesunOrganizm(x, y, x, y+1);
                } else if (swiat.zwrocOrganizm(x, y - 1) == null) {
                    swiat.przesunOrganizm(x, y, x, y-1);
                }
            } else if (y > 0) {
                if (swiat.zwrocOrganizm(x, y - 1) == null) {
                    swiat.przesunOrganizm(x, y, x, y-1);
                }
            } else if (y < swiat.getSzerokosc() - 1) {
                if (swiat.zwrocOrganizm(x, y + 1) == null) {
                    swiat.przesunOrganizm(x, y, x, y+1);
                }
            }
                }
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
                //nic
            } else {
                organizm = kontener.zwrocOrganizm(temp_x,temp_y);
                organizm.poruszony = true;
            }
            }
        }
    } 
}

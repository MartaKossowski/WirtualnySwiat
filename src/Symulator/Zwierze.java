package Symulator;

import java.util.Random;

public class Zwierze extends Organizm {
 
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
            KontenerOrganizmow kontener = swiat.zwrocKontener();
            Organizm organizm = kontener.zwrocOrganizm(o.x, o.y); 

             if (sila>=o.sila){
                organizm = kontener.zwrocOrganizm(o.x, o.y);
                organizm.setMartwy();
                //Tu przesuwanie sie
                swiat.przesunNaPustePole(this.x,this.y,o.x,o.y);
            }
            else {
                this.typ="martwy";
            }
        }
    }
    
    protected void rozmnazanie(String typ, int x, int y) {

            KontenerOrganizmow kontener = this.swiat.zwrocKontener();
            kontener.setOrganizm(typ, x, y, null, this.swiat);               
    }

    @Override
    public void akcja() { //implementacja ruchu
        boolean poruszone = false;
        Random r = new Random();

        while (!poruszone) {
            switch (r.nextInt(4)) {
                case 0:
                    if (x > 0) {
                        swiat.przesunOrganizm(x, y, x - 1, y);
                        poruszone = true;
                    }
                    break;
                case 1:
                    if (x < swiat.getWysokosc() - 1) {
                        swiat.przesunOrganizm(x, y, x + 1, y);
                        poruszone = true;
                    }
                    break;
                case 2:
                    if (y > 0) {
                        swiat.przesunOrganizm(x, y, x, y - 1);
                        poruszone = true;
                    }
                    break;
                case 3:
                    if (y < swiat.getSzerokosc() - 1) {
                        swiat.przesunOrganizm(x, y, x, y + 1);
                        poruszone = true;
                    }
                    break;
            }
        }
    }

    @Override
    void rysowanie() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
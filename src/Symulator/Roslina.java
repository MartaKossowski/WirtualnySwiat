package Symulator;

import java.util.Random;

public abstract class Roslina extends Organizm {

    @Override
    void kolizja(Organizm o) {
        o.kolizja(this);
    }

    @Override
    void akcja() {
        Random r = new Random();
        KontenerOrganizmow kontener = this.swiat.zwrocKontener();

        switch (r.nextInt(10)) {
            case 0:
                if (x > 0) {
                    if (kontener.czyPolePuste(x-1, y)) {
                        kontener.setOrganizm(typ, x-1, y, null, this.swiat); 
                    }
                }
                break;
            case 1:
                if (x < swiat.getWysokosc() - 1) {
                    if (kontener.czyPolePuste(x+1, y)) {
                        kontener.setOrganizm(typ, x+1, y, null, this.swiat); 
                    }
                }
                break;
            case 2:
                if (y > 0) {
                    if (kontener.czyPolePuste(x, y-1)) {
                        kontener.setOrganizm(typ, x, y-1, null, this.swiat); 
                    }
                }
                break;
            case 3:
                if (y < swiat.getSzerokosc() - 1) {
                    if (kontener.czyPolePuste(x, y+1)) {
                        kontener.setOrganizm(typ, x, y+1, null, this.swiat); 
                    }
                }
                break;
        }
    }

    @Override
    void rysowanie() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

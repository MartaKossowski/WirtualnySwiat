package Symulator;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

public class Swiat implements Serializable{

    private int wysokoscM;
    private int szerokoscN;
    private int kierunek;
    private boolean pauza;
    private boolean koniec;
    private KontenerOrganizmow kontener;
    private int trwanieUmiejetnosci = -5;

    public Swiat(int m, int n) {
        this.wysokoscM = m;
        this.szerokoscN = n;

        kontener = new KontenerOrganizmow(m, n);
        this.kierunek = -1;
        this.pauza = true;
        this.koniec = false;
    }
    
    public void setKontener(KontenerOrganizmow k){
        this.kontener = k;
    }

    public boolean zwrocKoniec(){
        return koniec;
    }
    
    public Color zwrocKolor(int x, int y) {
        return kontener.zwrocKolor(x,y);
    }
    
    public void ustawKierunek(int x){
        this.kierunek = x;
    }
    
    public int zwrocKierunek(){
        return this.kierunek;
    }
    
    public boolean zwrocPauze(){
        return this.pauza;
    }
    
    public void ustawPauze(boolean x){
        this.pauza = x;
    }

    public void wykonajTure() throws InterruptedException {
        for (int i = 7; i >= 0; i--) {
            for (int y = 0; y < this.szerokoscN; y++) {
                for (int x = 0; x < this.wysokoscM; x++) {
                    if (kontener.czyPolePuste(x, y)) {
                        continue;
                    } else {
                        Organizm zwroconyOrganizm = kontener.zwrocOrganizm(x, y);
                        if (zwroconyOrganizm.getInicjatywa() == i) {
                            if (zwroconyOrganizm.typ.equals("martwy") == false) {
                                if (zwroconyOrganizm.poruszony == false) {
                                    this.kierunek = -1;
                                    zwroconyOrganizm.akcja();
                                } else {
                                    zwroconyOrganizm.poruszony = false;
                                }
                            } else {
                                usunOrganizm(x, y);
                            }
                        }
                    }
                }
            }
        }
        this.pauza = true;
        while (this.pauza) {
            Thread.sleep(50);
        }
    }

    public void losuj() {
        Random r = new Random();
        int x, y;
        
        for (int i = 0; i < (this.wysokoscM * this.szerokoscN) / 5;) {
            x = r.nextInt(this.wysokoscM);
            y = r.nextInt(this.szerokoscN);
            if (kontener.czyPolePuste(x,y)) {
                int typ = r.nextInt(10);
                switch (typ) {
                    case 0:
                        this.kontener.stworzOrganizm(getSwiat(), x, y, "wilk", null);
                        i++;
                        break;
                    case 1:
                        this.kontener.stworzOrganizm(getSwiat(), x, y, "owca", null); 
                        i++;
                        break;
                    case 3:
                        this.kontener.stworzOrganizm(getSwiat(), x, y, "lis", null);
                        i++;
                        break;
                    case 4:
                        this.kontener.stworzOrganizm(getSwiat(), x, y, "zolw", null);
                        i++;
                        break;
                    case 5:
                        this.kontener.stworzOrganizm(getSwiat(), x, y, "antylopa", null);
                        i++;
                        break;
                    case 6:
                        this.kontener.stworzOrganizm(getSwiat(), x, y, "trawa", null);
                        i++;
                        break;
                    case 7:
                        this.kontener.stworzOrganizm(getSwiat(), x, y, "mlecz", null);
                        i++;
                        break;
                    case 8:
                        this.kontener.stworzOrganizm(getSwiat(), x, y, "guarana", null);
                        i++;
                        break;
                    case 9:
                        this.kontener.stworzOrganizm(getSwiat(), x, y, "jagoda", null);
                        i++;
                        break;
                }
            }
        }
             
        while (true) {
            x = r.nextInt(this.wysokoscM);
            y = r.nextInt(this.szerokoscN);
            if (kontener.czyPolePuste(x, y)) {
                this.kontener.stworzOrganizm(this, x, y, "czlowiek", null);
                break;
            }
        }
    }

    public Organizm zwrocOrganizm(int x, int y) {
        return kontener.zwrocOrganizm(x,y);
    }

    public void wlaczSpecjalnaUmiejetnosc(){
        if (trwanieUmiejetnosci <= -5){
            trwanieUmiejetnosci = 5;  
        }
    }
    
    public void zmniejszCzasUmiejetnosci(){
        trwanieUmiejetnosci--;
    }
    
    public int getTrwanieUmiejetnosci(){
        return this.trwanieUmiejetnosci;
    }
     
    public void przesunNaPustePole(int x1, int y1, int x2, int y2){
        
        kontener.wpiszOrganizm(x1, y1, x2, y2);
        Organizm zwroconyOrganizm2 = this.kontener.zwrocOrganizm(x2, y2);
        zwroconyOrganizm2.setX(x2);
        zwroconyOrganizm2.setY(y2);

        kontener.usunOrganizm(x1, y1);

        if (x2 - x1 <= -1 || y2 - y1 <= -1) {
        } else {
            zwroconyOrganizm2.poruszony = true;
        }
    }
    
    public void przesunOrganizm(int x1, int y1, int x2, int y2) {
        Organizm zwroconyOrganizm1 = this.kontener.zwrocOrganizm(x1, y1);
        Organizm zwroconyOrganizm2 = this.kontener.zwrocOrganizm(x2, y2);
        if (kontener.czyPolePuste(x2, y2)) {
            if(zwroconyOrganizm1 != null){ 
                przesunNaPustePole(x1,y1,x2,y2);
            } 
        } else {
                zwroconyOrganizm2 = this.kontener.zwrocOrganizm(x2, y2);
            if (zwroconyOrganizm2.nowy == false) {
                zwroconyOrganizm2.kolizja(zwroconyOrganizm1);
            } else {
                zwroconyOrganizm2.switchNowy(false);
            }
        }
    }

    public void usunOrganizm(int x, int y) {
        kontener.usunOrganizm(x, y);
    }

    public Swiat getSwiat() {
        return this;
    }
    
    public int getWysokosc(){
        return this.wysokoscM;
    }
    
    public int getSzerokosc(){
        return this.szerokoscN;
    }
    
    public KontenerOrganizmow zwrocKontener(){
        return this.kontener;
    }
}



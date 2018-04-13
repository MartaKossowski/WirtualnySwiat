package Symulator;

import java.awt.Color;
import java.io.Serializable;

public abstract class Organizm implements Serializable {

    protected Swiat swiat;
    protected int sila;
    protected int inicjatywa;
    protected int umiejetnosc;
    protected int x;
    protected int y;
    protected boolean poruszony;
    protected boolean nowy;
    protected int wiek =0;
    Color kolor;
    protected String typ;

    abstract void kolizja(Organizm o);

    abstract void akcja();

    abstract void rysowanie();

    public void switchPoruszony() {
        if (poruszony == true) {
            poruszony = false;
        } else {
            poruszony = true;
        }
    }

    public int getSila() {
        return sila;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }

    public void switchNowy(boolean b) {
        nowy = b;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTyp() {
        return typ;
    }

    public void setMartwy() {
        this.typ = "martwy";
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setSila(int x) {
        this.sila = x;
    }

    public void setWiek(int x) {
        this.wiek = x;
    }
    
    public int getWiek(){
        return this.wiek;
    }
}

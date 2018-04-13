package Symulator;
import Okna.OknoGry;
import java.awt.Color;
import java.io.Serializable;

public class KontenerOrganizmow implements Serializable{
    
    private int wysokosc;
    private int szerokosc;
    private Organizm[][] organizmy;
    
    public KontenerOrganizmow(int m, int n) {
        this.wysokosc = m;
        this.szerokosc = n;
        this.organizmy = new Organizm[m][n];
    }
     
    public Color zwrocKolor(int x, int y){
     
         return organizmy[x][y].kolor;
     }
     
    public Organizm zwrocOrganizm(int x, int y) {
        return organizmy[x][y];
    }
    
    public void usunOrganizm(int x, int y) {
        organizmy[x][y] = null;
    }
     
    public boolean czyPolePuste(int x, int y){
        if(organizmy[x][y] == null){
            return true;
        }
        return false;
    }  
    
    public Organizm zwrocZwierze(int x, int y){
        return organizmy[x][y];
    }
    
    public void stworzOrganizm(Swiat swiat, int x, int y, String jaki, OknoGry o){
        
        if(jaki.equals("czlowiek")){
            organizmy[x][y] = new Czlowiek(swiat, x, y, o);
        }else if(jaki.equals("wilk")){
            organizmy[x][y] = new Wilk(swiat, x, y);
        }else if(jaki.equals("owca")){
            organizmy[x][y] = new Owca(swiat, x, y);
        }else if(jaki.equals("lis")){
            organizmy[x][y] = new Lis(swiat, x, y);
        }else if(jaki.equals("zolw")){
            organizmy[x][y] = new Zolw(swiat, x, y);
        }else if(jaki.equals("antylopa")){
            organizmy[x][y] = new Antylopa(swiat, x, y);
        }else if(jaki.equals("trawa")){
            organizmy[x][y] = new Trawa(swiat, x, y);
        }else if(jaki.equals("mlecz")){
            organizmy[x][y] = new Mlecz(swiat, x, y);
        }else if(jaki.equals("guarana")){
            organizmy[x][y] = new Guarana(swiat, x, y);
        }else if(jaki.equals("jagoda")){
            organizmy[x][y] = new WilczaJagoda(swiat, x, y);
        }   
    }
    
    public void setOrganizm(String typ, int x, int y, OknoGry o, Swiat swiat) {
        if (typ.equals("czlowiek")) {
            organizmy[x][y] = new Czlowiek(swiat, x, y, o);
        } else if (typ.equals("wilk")) {
            organizmy[x][y] = new Wilk(swiat, x, y);
        } else if (typ.equals("owca")) {
            organizmy[x][y] = new Owca(swiat, x, y);
        } else if (typ.equals("lis")) {
            organizmy[x][y] = new Lis(swiat, x, y);
        } else if (typ.equals("zolw")) {
            organizmy[x][y] = new Zolw(swiat, x, y);
        } else if (typ.equals("antylopa")) {
            organizmy[x][y] = new Antylopa(swiat, x, y);
        } else if (typ.equals("trawa")) {
            organizmy[x][y] = new Trawa(swiat, x, y);
        } else if (typ.equals("mlecz")) {
            organizmy[x][y] = new Mlecz(swiat, x, y);
        } else if (typ.equals("guarana")) {
            organizmy[x][y] = new Guarana(swiat, x, y);
        } else if (typ.equals("jagoda")) {
            organizmy[x][y] = new WilczaJagoda(swiat, x, y);
        }
    }
    
    public int getSila(int x, int y){
        return organizmy[x][y].getSila();
    }
    
    public void wpiszOrganizm(int x1, int y1, int x2, int y2){
        organizmy[x2][y2] = organizmy[x1][y1];
    }
    
    public void usunOrganizmy(){
        
        for(int i = 0; i < wysokosc-1 ; i++){
            for(int j = 0 ; j < szerokosc-1; j++){
                organizmy[i][j] = null;
            }
        }
    }
    
    public void usmiercOrganizm(int x, int y){
        organizmy[x][y].setMartwy();  
    }
    
    public void usmiercOrganizmy(){
          for(int i = 0; i < wysokosc; i++){
            for(int j = 0 ; j < szerokosc; j++){
                if(organizmy[i][j] != null){
                    if (organizmy[i][j].getTyp().equals("czlowiek")){
                    }
                    usmiercOrganizm(i,j);
                }
            }
        }
    }
        
    public String getTyp(int x, int y){
        return organizmy[x][y].getTyp();
    }
    
    public Organizm getCzlowiek(){
        
        for(int i = 0; i < wysokosc; i++){
            for(int k = 0; k < szerokosc; k++){
                if(organizmy[i][k].getTyp().equals("czlowiek"))
                return organizmy[i][k];  
            }
        }
        return organizmy[0][0];
    }
}
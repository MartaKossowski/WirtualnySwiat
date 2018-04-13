package Okna;

public class Wyjatek extends Exception {
    public Wyjatek(){
        System.out.println("NIE MOŻNA POSTAWIĆ ORGANIZMU W ZAJĘTYM POLU!");
    }
}
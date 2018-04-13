package Okna;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import Symulator.*;

public class OknoGry extends JFrame{

    public Plansza plansza;
    public Strzalki st;
    public Swiat swiat;
    public OknoGry(Swiat s) {

        super("autor: Marta Kossowski");
        this.swiat = s;
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(50,50);
        panel.setMaximumSize(new Dimension(50,50));
        
        //plansza
        JPanel pPlansza = new JPanel();
        plansza = new Plansza(s);
        plansza.ustawPlansze();
        pPlansza.add(plansza);
        
        //przyciski
        Przyciski pPrzycisk= new Przyciski(s, this);
        pPrzycisk.ustawPrzyciski();
        
        //tekst informacyjny
        JLabel pOpis = new JLabel();
        pOpis.setText("<html>Wirtualny świat<br/><br/>"
                + "Organizmy (kwadraty):<br/>"
                + "- różowy - człowiek (Ty) - siła 5 - wcisnij 0 aby uruchomic specjalną umiejętność, szybkosć antylopy<br/>"
                + "- ciemny szary - wilk - siła 9<br/>"
                + "- ciemny zielony - żółw - siła 2 - odpiera ataki zwierząt o sile <5 - 25% szansy na zmienę położenia<br/>"
                + "- pomarańczowy - lis - siła 3 - nie atakuje organizmów silniejszych od niego<br/>"
                + "- jasny pomarańczowy - antylopa - siła 4 - skacze co 2 pola - 50% szansy na ucieczkę przed walką <br/>"
                + "- jasny szary - owca - siła 4<br/>"
                + "- zielony - trawa - siła 0<br/>"
                + "- żółty - mlecz - siła 0 - podejmuje trzy próbu rozprzestrzenienia się w jednej turze<br/>"
                + "- czerwony - guarana - siła 0 - po zjedzeniu przez zwięrzę zwiększa siłę o 3<br/>"
                + "- fioletowy - wilcza jagoda - siła 99 - przynosi śmierć<br/>"
                + "<br/>"
                + "Jak grać?<br/>"
                + "Aby rozpocząć grę należy wcisnąć przycisk Runda. "
                + "Następnie wybrać w jakim kierunku poruszy się człowiek, poprzez wciśnięcie strzałki na klawiaturze. "
                + "Każdorazowo po wciśnięciu strzałki, należy nacisnąć przycisk Runda, "
                + "żeby pozwolić wszystkim organizmom na wykonanie ruchu. "
                + "Organizmy mogą zjadać siebie nazwajem, rozmnażać się/ rozsiewać się z pewnym prawdopodobieństwem. "
                + "Większość z nich posiada specjalne umiejętności. "
                + "Możliwe jest również zapisane stanu gry (przycisk Zapisz),"
                + " i odtworzenie do po kilku rundach (przycisk Otwórz).</html>");
        
        st = new Strzalki(s);
        addKeyListener(st);
        setFocusable(true);    
        setSize(20 * swiat.getWysokosc() + 100, 20 * swiat.getSzerokosc() + 450);
        setResizable(false);        
        setMinimumSize(new Dimension(swiat.getWysokosc()*20 + 200,swiat.getSzerokosc()*20 + 100));
        setMaximumSize(new Dimension(swiat.getWysokosc()*20 + 200,swiat.getSzerokosc()*20 + 100));

        panel.add(pPrzycisk, BorderLayout.PAGE_START);
        panel.add(pPlansza, BorderLayout.CENTER);
        panel.add(pOpis, BorderLayout.SOUTH);
       
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

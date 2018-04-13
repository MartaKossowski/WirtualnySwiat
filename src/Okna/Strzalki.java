
package Okna;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Symulator.*;
import java.io.Serializable;


public class Strzalki implements KeyListener, Serializable {
    private Swiat swiat;
    public Strzalki(Swiat s){
        this.swiat=s.getSwiat();
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
       
    }

    @Override
    public void keyPressed(KeyEvent ke) {
      if (ke.getKeyCode()==KeyEvent.VK_LEFT)
          swiat.ustawKierunek(0);
      else if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
          swiat.ustawKierunek(1);
      else if(ke.getKeyCode()==KeyEvent.VK_UP)
          swiat.ustawKierunek(2);
      else if (ke.getKeyCode()==KeyEvent.VK_DOWN)
          swiat.ustawKierunek(3);
      else if (ke.getKeyCode()==KeyEvent.VK_0){
          swiat.wlaczSpecjalnaUmiejetnosc();
          System.out.println("UMIEJETNOSC: szybkosc antylopy");
      }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        swiat.ustawKierunek(-1);
    }
}

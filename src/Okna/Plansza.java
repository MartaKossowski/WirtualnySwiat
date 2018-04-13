package Okna;

import Symulator.Swiat;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Symulator.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Plansza extends JPanel implements MouseListener {

    private Swiat swiat;

    public Plansza(Swiat s) {
        swiat = s.getSwiat();
    }

    public void ustawPlansze() {
        Dimension rozmiarPlanszy = new Dimension(20 * swiat.getWysokosc() + 1, 20 * swiat.getSzerokosc() + 1); 
        this.setSize(rozmiarPlanszy);
        this.setMinimumSize(rozmiarPlanszy);
        this.setMaximumSize(rozmiarPlanszy);
        this.setPreferredSize(rozmiarPlanszy);
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Random rand = new Random();
        super.paintComponent(g);
        Graphics2D gr = (Graphics2D) g;
        gr.setColor(new Color(235, 235, 235));
        for (int i = 0; i < swiat.getWysokosc(); i++) { 
            for (int k = 0; k < swiat.getSzerokosc(); k++) { 
                gr.drawRect(i * 20, k * 20, 20, 20);
            }
        }
        for (int j = 0; j < swiat.getSzerokosc(); j++) { 
            for (int i = 0; i < swiat.getWysokosc(); i++) { 
                if (swiat.zwrocOrganizm(i, j) != null) {
                    Organizm temp = swiat.zwrocOrganizm(i, j);
                    if (temp.getTyp().endsWith("martwy") == false) {
                        Rectangle2D rect = new Rectangle2D.Double(20 * i, 20 * j, 20, 20);
                        gr.setPaint(swiat.zwrocKolor(i, j));
                        gr.fill(rect);
                        gr.draw(rect);
                    } else {
                        swiat.usunOrganizm(i, j);
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me){
        int m_x = me.getX();
        int m_y = me.getY();
        m_x = m_x / 20;
        m_y = m_y / 20;
        if (swiat.zwrocOrganizm(m_x, m_y) == null) {
            String typ;
            String[] typy = new String[]{"wilk", "owca", "lis", "zolw", "antylopa","trawa", "mlecz", "guarana", "jagoda", "czlowiek"};
            JFrame frame = new JFrame();
            typ = (String) JOptionPane.showInputDialog(frame, "Wybierz organizm", "Wstawianie organizmu", JOptionPane.QUESTION_MESSAGE,
                    null, typy, "Titan");
            if (typ!=null) {
                    KontenerOrganizmow kontener = this.swiat.zwrocKontener();
                    kontener.setOrganizm(typ, m_x, m_y, null, this.swiat);
                    repaint();
            }
        } else
            try {
                throw new Wyjatek();
        } catch (Wyjatek ex) {
            Logger.getLogger(Plansza.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

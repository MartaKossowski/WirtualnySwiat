package Okna;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import Symulator.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Przyciski extends JPanel implements ActionListener {

    OknoGry okno;
    Swiat swiat;
    JButton runda;
    JButton zapisz;
    JButton otworz;

    public Przyciski(Swiat s, OknoGry o) {
        swiat = s.getSwiat();
        okno = o;
    }
    
    public void ustawPrzyciski() {
        setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.lightGray, null, null));
        setLayout(new FlowLayout(FlowLayout.CENTER));

        runda = new JButton();
        zapisz = new JButton();
        otworz = new JButton();
        runda.setText("Runda");
        zapisz.setText("Zapisz");
        otworz.setText("Otworz");
        runda.addActionListener(this);
        zapisz.addActionListener(this);
        otworz.addActionListener(this);
        runda.addKeyListener(okno.st);
        runda.setFocusable(true);
        add(runda);
        add(zapisz);
        add(otworz);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == runda) {
            swiat.ustawPauze(false);
            okno.repaint();
            okno.requestFocus();
        } else if (source == zapisz) {
            System.out.println("ZAPIS");
            KontenerOrganizmow f = swiat.zwrocKontener();
            FileOutputStream fileOut;
            ObjectOutputStream out;
            try {
                fileOut = new FileOutputStream("./serializacja.ser");
                out = new ObjectOutputStream(fileOut);
                out.writeObject(f);
                out.close();
                fileOut.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Przyciski.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Przyciski.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (source == otworz) {

            FileInputStream fileIn;
            ObjectInputStream in;

            try {
                fileIn = new FileInputStream("./serializacja.ser");
                in = new ObjectInputStream(fileIn);
                KontenerOrganizmow k = swiat.zwrocKontener();
                k = (KontenerOrganizmow) in.readObject();

                //wyzerowac
                KontenerOrganizmow istniejacyKontener = swiat.zwrocKontener();
                istniejacyKontener.usmiercOrganizmy();
                istniejacyKontener = swiat.zwrocKontener();
                Organizm wzorOrganizm = k.zwrocOrganizm(0, 0);

                //glowna petla
                for (int i = 0; i < swiat.getWysokosc(); i++) {
                    for (int j = 0; j < swiat.getSzerokosc(); j++) {
                        wzorOrganizm = k.zwrocOrganizm(i, j);
                        if (wzorOrganizm != null) {
                            //x,y stworz organizm
                            istniejacyKontener.stworzOrganizm(swiat, i, j, wzorOrganizm.getTyp(), okno);
                            Organizm powstalyOrganizm = istniejacyKontener.zwrocOrganizm(i, j);
                            //przypisz sile i wiek
                            powstalyOrganizm.setSila(wzorOrganizm.getSila());
                            powstalyOrganizm.setWiek(wzorOrganizm.getWiek());
                        }else{
                            //jesli wzorOrganizm jest nulem to
                            istniejacyKontener.usunOrganizm(i, j);
                        }
                    }
                }
                in.close();
                fileIn.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Przyciski.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Przyciski.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Przyciski.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            swiat.ustawPauze(false);
            okno.repaint();
            okno.requestFocus();
        }
    }
}
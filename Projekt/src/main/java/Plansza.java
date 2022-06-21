import javax.swing.*;
import java.awt.*;
/**
 *Klasa odpowiedzialna za prawidłowe wyświetlanie symulacji okienkowej.
 */
public class Plansza extends JFrame{

    JPanel p;
    JLabel ilePszczol;
    JLabel ileSzerszeni;

    Main object = new Main();
    /**
     *zmienna pobierająca liczbę pszczół z klasy Main
     */
    int x = object.liczbaPszczol;
    /**
     *zmienna pobierająca liczbę szerszeni z klasy Main
     */
    int y = object.liczbaSzerszeni;
    /**
     *zmienna określająca kolor w symulacji okienkowej
     */
    protected static Color kolorLawenda;
    /**
     *zmienna określająca kolor w symulacji okienkowej
     */
    protected static Color kolorKrokus;
    /**
     *zmienna określająca kolor w symulacji okienkowej
     */
    protected static Color kolorPszczola;
    /**
     *zmienna określająca kolor w symulacji okienkowej
     */
    protected static Color kolorSzerszen;
    /**
     *zmienna określająca kolor w symulacji okienkowej
     */
    protected static Color kolorLaki;
    /**
     *zmienna określająca kolor w symulacji okienkowej
     */
    protected static Color kolorKwiata;
    /**
     *zmienna określająca kolor w symulacji okienkowej
     */
    protected static Color kolorUl;

    /**
     *metoda odpowiedzialna za ustawienie wymiarów, położenia okna symulacji oraz nadanie konkrentych kolorów do zmiennych
     */
    public Plansza(){
        setSize(900,700);
        setLocation(300,100);
        setTitle("LAKA PROJEKT");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        kolorLawenda = new Color(123, 104, 238);
        kolorKrokus = new Color(148, 0, 211);
        kolorPszczola = new Color(255, 255, 0);
        kolorSzerszen = new Color(255, 127, 80);
        kolorLaki = new Color(0,153,0);
        kolorKwiata = new Color(255,0,255);
        kolorUl = new Color(255,0,0);

        p = new JPanel();
        add(p);
    }

    /**
     *metoda przysłaniająca, odpowiedzialna za wygląd wnętrza okna symulacji
     */
    @Override
    public void paint(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(0, 0, 900, 700);

        Font f = new Font("TimesRoman",Font.BOLD,18);
        g.setFont(f);
        g.setColor(Color.black);
        g.drawString("Pszczol jest: \n"+object.liczbaPszczol, 650 , 200);
        g.drawString(" Szerszeni jest: "+object.liczbaSzerszeni, 650 , 300);

        for (int i = 0; i < Laka.getRozmiarLaki(); i++) {
            for (int j = 0; j < Laka.getRozmiarLaki(); j++) {
                if ((Laka.planszaKwiatow[i][j]) == null) {
                    g.setColor(kolorLaki);
                    g.fillRect(100 + (100 * i), 50 + (100 * j), 100, 100);
                } else if ((Laka.planszaKwiatow[i][j]).getIloscNektaru() == 2) {
                    g.setColor(kolorKrokus);
                    g.fillRect(100 + (100 * i), 50 + (100 * j), 100, 100);
                } else if ((Laka.planszaKwiatow[i][j]).getIloscNektaru() == 3) {
                    g.setColor(kolorLawenda);
                    g.fillRect(100 + (100 * i), 50 + (100 * j), 100, 100);
                } else {
                    g.setColor(kolorKwiata);
                    g.fillRect(100 + (100 * i), 50 + (100 * j), 100, 100);
                }
            }
        }

        for (int i = 0; i < Laka.getRozmiarLaki(); i++) {
            for (int j = 0; j < Laka.getRozmiarLaki(); j++) {
                if ((Laka.planszaOwadow[i][j]) == null) {
                } else if ((Laka.planszaOwadow[i][j]).getSzybkoscPoruszania() == 2) {
                    g.setColor(kolorSzerszen);
                    g.fillOval(110 + (100 * i), 60 + (100 * j), 80, 80);
                } else if ((Laka.planszaOwadow[i][j]).getSzybkoscPoruszania() == 1) {
                    g.setColor(kolorPszczola);
                    g.fillOval(110 + (100 * i), 60 + (100 * j), 80, 80);
                }
            }
        }
        g.setColor(kolorUl);
        g.fillRect(300, 250, 100, 100);


        //legenda
        g.setColor(kolorUl);
        g.fillRect(175, 575, 50, 50);

        g.setColor(kolorLawenda);
        g.fillRect(275, 575, 50, 50);

        g.setColor(kolorKrokus);
        g.fillRect(375, 575, 50, 50);

        g.setColor(kolorKwiata);
        g.fillRect(475, 575, 50, 50);

        g.setColor(kolorLaki);
        g.fillRect(575, 575, 50, 50);

        g.setColor(kolorPszczola);
        g.fillOval(675, 575, 50, 50);

        g.setColor(kolorSzerszen);
        g.fillOval(775, 575, 50, 50);


        Font k = new Font("TimesRoman",Font.ITALIC, 18);
        g.setFont(k);
        g.setColor(Color.black);
        g.drawString("Legenda:", 50 , 600);

        Font h = new Font("TimesRoman",Font.ITALIC, 12);
        g.setFont(h);
        g.setColor(Color.black);
        g.drawString("Ul", 190 , 650);
        g.drawString("Lawenda", 275 , 650);
        g.drawString("Krokus", 380 , 650);
        g.drawString("Kwiat", 483 , 650);
        g.drawString("bez nektaru", 465 , 665);
        g.drawString("Trawa", 582 , 650);
        g.drawString("Pszczola", 675 , 650);
        g.drawString("Szerszen", 775 , 650);
    }
}

import javax.swing.*;
import java.io.Serializable;
import java.util.Random;

public class Laka extends JFrame implements Serializable {
    private static int rozmiarLaki;
    public static int spisPszczol[][];
    public static int spisSzerszeni[][];
    public static int planszaKwiatow[][];
    public static int planszaOwadow[][];

/*
    private Integer szerokoscOkna = 100*rozmiarLaki;
    private Integer wysokoscOkna = 100*rozmiarLaki;
    private Pole[][] kwadraty;

    protected static Color kolorPlanszy1;
    protected static Color kolorLawenda;
    protected static Color kolorKrokus;
    protected static Color kolorPszczola;
    protected static Color kolorSzerszen;
*/
    protected static boolean symulacjaRozpoczeta;


    public int getRozmiarLaki(){
        return rozmiarLaki;
    }
    public void setRozmiarLaki(int rozmiarLaki){
        this.rozmiarLaki = rozmiarLaki;
    }

    //wypelnienie tablicy zerami oraz nadanie jej rozmiaru
    public static int[][] tworzenieLaki(int rozmiarLaki){
        for (int j = 0; j < rozmiarLaki; j++)
            for (int i = 0; i < rozmiarLaki; i++) {
                planszaKwiatow[i][j] = 0;
            }
        symulacjaRozpoczeta = false;
        return planszaKwiatow;
    }

/*
    public Laka() {
        spisPszczol = new int[5][5];
        spisSzerszeni = new int[5][5];

        kwadraty = new Pole[5][5];
        symulacjaRozpoczeta = false;

        setSize(szerokoscOkna, wysokoscOkna);
        setLocationRelativeTo(planszaKwiatow);
        setLocationRelativeTo(planszaOwadow);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        kolorPlanszy1 = new Color(255, 248, 220);
        kolorLawenda = new Color(123, 104, 238);
        kolorKrokus = new Color(148, 0, 211);
        kolorPszczola = new Color(255, 255, 0);
        kolorSzerszen = new Color(255, 127, 80);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                kwadraty[i][j] = new Pole(this, i, j);
                add(Pole[i][j]);
            }
        }
        setVisible(true);
    }
*/

    private void wypelnijLake() {
       //dodawanie lawendy - lawenda w tablicy ma wartosc 1
        for (int k = 0; k < rozmiarLaki; k++){
            Random random = new Random();
            int los1 = random.nextInt(rozmiarLaki);
            Random random2 = new Random();
            int los2 = random2.nextInt(rozmiarLaki);
                if(planszaKwiatow[los1][los2] == 0){
                    planszaKwiatow[los1][los2] = 1;
                }
                else{
                    k=k-1;
                }
            }
        //dodawanie krokusa - krokus w tablicy ma wartosc -1
        for (int l = 0; l < 5; l++){
            Random random = new Random();
            int los1 = random.nextInt(rozmiarLaki);
            Random random2 = new Random();
            int los2 = random2.nextInt(rozmiarLaki);
            if(planszaKwiatow[los1][los2] == 0){
                planszaKwiatow[los1][los2] = -1;
            }
            else{
                l=l-1;
            }
        }

        // umieszczenie ula - Ul będzie w tablicy oznaczony jako 2
        int x; //wspolrzedna x Ula
        int y; //wspolrzedna y Ula
        do{
            Random random = new Random();
            x = random.nextInt(rozmiarLaki);
            Random random2 = new Random();
            y = random2.nextInt(rozmiarLaki);
        }
        while(planszaKwiatow[x][y]==0);

        planszaKwiatow[x][y]=2;
        symulacjaRozpoczeta = false;
    }

    private void ustawOwady() {
        //stworzenie tablicy zer i jedynek, jedynka oznacza pszczołę
        Main object = new Main();
        int a = object.getLiczbaPszczol();
        for (int j = 0; j < rozmiarLaki; j++)
            for (int i = 0; i < rozmiarLaki; i++) {
                spisPszczol[i][j] = 0;
            }
        for (int m = 0; m < a; m++){
            Random random = new Random();
            int x = random.nextInt(rozmiarLaki);
            Random random2 = new Random();
            int y = random2.nextInt(rozmiarLaki);
            if(spisPszczol[x][y] == 0){
                spisPszczol[x][y] = 1;
            }
            else{
                m=m-1;
            }
        }


    // stworzenie tablicy szerszeni - (-1) oznacza szerszenia, zero oznacza jego brak
        Main object2 = new Main();
        int b = object2.getLiczbaSzerszeni();
        for (int j = 0; j < rozmiarLaki; j++)
            for (int i = 0; i < rozmiarLaki; i++) {
                spisSzerszeni[i][j] = 0;
            }
        for (int n = 0; n < b; n++){
            Random random = new Random();
            int x = random.nextInt(rozmiarLaki);
            Random random2 = new Random();
            int y = random2.nextInt(rozmiarLaki);
            //jeśli w danym miejscu nie ma pszczoły (czyli jest 0 w tablicy z pszczołami) stawiamy tam szerszenia, jeśli nie losujemy miejsce ponownie
            if(spisPszczol[x][y] == 0){
                spisSzerszeni[x][y] = -1;
            }
            else{
                n=n-1;
            }
        }

        //połączenie spisu pszczół i szerszeni w planszę owadów (tablice dwuwymiarowa)
        for (int j = 0; j < rozmiarLaki; j++)
            for (int i = 0; i < rozmiarLaki; i++) {
                planszaOwadow[i][j] = 0;
            }
        for (int j = 0; j < rozmiarLaki; j++)
            for (int i = 0; i < rozmiarLaki; i++) {
                if(spisPszczol[i][j] == 1){
                    planszaOwadow[i][j]=spisPszczol[i][j];
                }
                else if(spisSzerszeni[i][j]==-1){
                    planszaOwadow[i][j]=spisSzerszeni[i][j];
                }
            }
        symulacjaRozpoczeta = true;
        }

    // metoda tworzy tablice obiektów typu pszczola
    public void tablicaPszczol(){
            Main object = new Main();
            int a = object.getLiczbaPszczol();
            Pszczola[] listaPszczol = new Pszczola[a];
            for(int i =0; i<a; i++){
                Pszczola pszczola = new Pszczola();
                listaPszczol[i]=pszczola;
            }
    }
    
    // metoda tworzy tablice obiektów typu szerszen
    public void tablicaSzerszeni(){
        Main object = new Main();
        int b = object.getLiczbaSzerszeni();
        Szerszen[] listaSzerszeni = new Szerszen[b];
        for(int i =0; i<b; i++){
            Szerszen szerszen = new Szerszen();
            listaSzerszeni[i]=szerszen;
        }
    }

/*  @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(10, 40, 505, 505);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                g2d.setColor(kolorPlanszy1);
                g2d.fillRect(11 + 63 * i, 41 + 63 * j, 62, 62);
            }
        }
        for (int j = 0; j < 5; j++){
            for (int i = 0; i < 5; i++) {
                if (spisKwiatow[i][j] == 1) {
                    g2d.setColor(kolorLawenda);
                }
                else if (spisKwiatow[i][j] == -1) {
                    g2d.setColor(kolorKrokus);
                    }
            }}

        g2d.setColor(Color.BLACK);
        g2d.drawRect(550, 493, 50, 50);
        g2d.drawString(Pole.tmp, 570, 535);

    }
*/
}

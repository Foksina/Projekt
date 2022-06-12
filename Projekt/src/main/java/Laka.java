import java.util.Random;
import java.util.LinkedList;
import java.util.List;
public class Laka {
    private static int rozmiarLaki = 5;
    public static List<Pszczola> spisPszczol = new LinkedList();
    public static List<Szerszen> spisSzerszeni = new LinkedList();
    public static Kwiat planszaKwiatow[][];
    public static Owad planszaOwadow[][];
    public static Ul planszaUl[][];
    public static double a;
    public static double b; // wspólrzędne Ula w tablicy planszaUl
    public static Ul object = new Ul();
    public static Main object2 = new Main();

    public static int getRozmiarLaki(){
        return rozmiarLaki;
    }
    public void setRozmiarLaki(int rozmiarLaki){
        this.rozmiarLaki = rozmiarLaki;
    }

    private static void tworzenieLaki(){  //nadanie rozmiaru wszystkim tablicom oraz wypelnienie obiektami typu null
        for (int j = 0; j < rozmiarLaki; j++)
            for (int i = 0; i < rozmiarLaki; i++) {
                planszaKwiatow[i][j] = null;
                planszaOwadow[i][j] = null;
                planszaUl[i][j] = null;
            }
    }

    private void ustawUl() {
        if(rozmiarLaki%2 ==0){
            a = ((double)rozmiarLaki/2) - 1;
            b = ((double)rozmiarLaki/2) - 1;
        }
        else {
            a = ((double)rozmiarLaki/2) - 0.5;
            b = ((double)rozmiarLaki/2) - 0.5;
        }
        planszaUl[(int)a][(int)b]=object;
    }

    private void wypelnijLake() {
        int x,y; //zmienne do losowania wspolrzednych kwiatow
       //dodawanie lawnedy do tablicy planszaKwiatow
        for (int i = 0; i < rozmiarLaki; i++){
            Random random = new Random();
            x = random.nextInt(rozmiarLaki);
            Random random2 = new Random();
            y = random2.nextInt(rozmiarLaki);
            if((planszaKwiatow[x][y] == null) && (x != (int)a) && (y != (int)b)){
               Lawenda object3 = new Lawenda();
               planszaKwiatow[x][y] = object3;
            }
            else{
                i=i-1;
            }
        }
        //dodawanie krokusa do tablicy planszaKwiatow
        for (int i = 0; i < 5; i++){
            Random random = new Random();
            x = random.nextInt(rozmiarLaki);
            Random random2 = new Random();
            y = random2.nextInt(rozmiarLaki);
            if((planszaKwiatow[x][y] == null) && (x != (int)a) && (y != (int)b)){
                Krokus object = new Krokus();
                planszaKwiatow[x][y] = object;}
            else{
                i=i-1;}
        }
    }

    private void ustawOwady() {
        //stworzenie listy obiektów typu pszczola
        int n = object2.getLiczbaPszczol();
        for (int i = 0; i < n; i++) {
                Pszczola object4 = new Pszczola();
                spisPszczol.add(object4);
            }

        //stworzenie listy obiektów typu szerszen
        int m = object2.getLiczbaSzerszeni();
        for (int i = 0; i < m; i++) {
                Szerszen object5 = new Szerszen();
                spisSzerszeni.add(object5);
            }

        int x,y; //zmienne do losowania pozycji pszczol i szerszeni
        //wypelnienie tablicy owadow obiektami typu pszczola
        for (int i = 0; i < n; i++){
            Random random = new Random();
            x = random.nextInt(rozmiarLaki);
            Random random2 = new Random();
            y = random2.nextInt(rozmiarLaki);
            if((planszaOwadow[x][y] == null) && (x != (int)a) && (y != (int)b)){
               planszaOwadow[x][y] = spisPszczol.get(i);
               int [] pomocniczna = new int[2];
               pomocniczna[0]=x;
               pomocniczna[1]=y;
                (spisPszczol.get(i)).setWspolrzedne(pomocniczna);
            }
            else{
                i=i-1;
            }
        }

        //wypelnienie tablicy owadow obiektami typu szerszen
        for (int i = 0; i < m; i++){
            Random random3 = new Random();
            x = random3.nextInt(rozmiarLaki);
            Random random4 = new Random();
            y = random4.nextInt(rozmiarLaki);
            if((planszaOwadow[x][y] == null) && (x != (int)a) && (y != (int)b)){
                planszaOwadow[x][y] = spisSzerszeni.get(i);
                int [] pomocniczna = new int[2];
                pomocniczna[0]=x;
                pomocniczna[1]=y;
                (spisSzerszeni.get(i)).setWspolrzedne(pomocniczna);
            }
            else{
                i=i-1;
            }
        }
    }
}

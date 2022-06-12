import java.util.Random;
import java.util.LinkedList;
import java.util.List;
public class Laka {
    private static int rozmiarLaki = 5;
    public List<Pszczola> spisPszczol = new LinkedList();
    public List<Szerszen> spisSzerszeni = new LinkedList();
    public static Kwiat planszaKwiatow[][];
    public static Owad planszaOwadow[][];
    public static Ul planszaUl[][];
    double a,b; // wspólrzędne Ula w tablicy planszaUl

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
        Ul object = new Ul();
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
               Lawenda object = new Lawenda();
               planszaKwiatow[x][y] = object;
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
        Main object = new Main();
        int n = object.getLiczbaPszczol();
        for (int i = 0; i < n; i++) {
                Pszczola object2 = new Pszczola();
                spisPszczol.add(object2);
            }

        //stworzenie listy obiektów typu szerszen
        Main object3 = new Main();
        int m = object3.getLiczbaSzerszeni();
        for (int i = 0; i < m; i++) {
                Szerszen object4 = new Szerszen();
                spisSzerszeni.add(object4);
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
            }
            else{
                i=i-1;
            }
        }
    }
}

import java.util.Random;
import java.util.LinkedList;
import java.util.List;
/**
 *Klasa odpowiedzialna za tworzenie planszy (łąki) symulacji, obiektów znajdujących się na planszy oraz odpowiednie ich rozmieszczenie.
 */
public class Laka {
    /**
     *zmienna określająca długość boku kwadratowej planszy
     */
    private static int rozmiarLaki = 5;
    /**
     *lista obiektów typu pszczoła przechowująca wszystkie istniejąca w danym momencie symulacji obiekty tego typu
     */
    public static List<Pszczola> spisPszczol = new LinkedList();
    /**
     *lista obiektów typu szerszeń przechowująca wszystkie istniejąca w danym momencie symulacji obiekty tego typu
     */
    public static List<Szerszen> spisSzerszeni = new LinkedList();
    /**
     *tablica określająca położenie obiektów typu kwiat
     */
    public static Kwiat planszaKwiatow[][];
    /**
     *tablica określająca położenie obiektów typu owad
     */
    public static Owad planszaOwadow[][];
    /**
     *tablica określająca położenie obiektów typu ul
     */
    public static Ul planszaUl[][];
    /**
     *zmienne określająca współrzędne Ula w tablicy
     */
    public static double a,b;
    /**
     *obiekt typu Ul odpowiedzialny za gromadzenie nektaru oraz tworzenie nowych obiektów typu pszczoła
     */
    public static Ul object = new Ul();
    public static Dane object2 = new Dane();
    public static Main object3 = new Main();
    /**
     *metoda pozwalająca na pobranie długości boku kwadratowej planszy
     */
    public static int getRozmiarLaki(){
        return rozmiarLaki;
    }
    /**
     *metoda pozwalająca na ustawienie długości boku kwadratowej planszy
     */
    public void setRozmiarLaki(int rozmiarLaki){
        this.rozmiarLaki = rozmiarLaki;
    }

    /**
     *metoda odpowiedzialna za wywołania metod tworzenia planszy, tworzenia obiektów znajdujących się na planszy oraz ich rozlokowania dla paramterów początkowych symulacji
     */
    public void ustawieniaPoczatkowe(){
        tworzenieLaki();
        ustawUl();
        wypelnijLake();
        ustawOwady();
    }
    /**
     *metoda zadająca rozmiary tablicom odpowiednich obiektów oraz wypełniająca wszystkie ich pola wartościom null
     */
    private static void tworzenieLaki(){  //nadanie rozmiaru wszystkim tablicom oraz wypelnienie obiektami typu null
        planszaKwiatow = new Kwiat[rozmiarLaki][rozmiarLaki];
        planszaOwadow = new Owad[rozmiarLaki][rozmiarLaki];
        planszaUl = new Ul[rozmiarLaki][rozmiarLaki];
        for (int j = 0; j < rozmiarLaki; j++)
            for (int i = 0; i < rozmiarLaki; i++) {
                planszaKwiatow[i][j] = null;
                planszaOwadow[i][j] = null;
                planszaUl[i][j] = null;
            }
    }

    /**
     *metoda obliczająca współrzędne ula (środek planszy) oraz ustawiająca ul w odpowiednim miejscu
     */
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

    /**
     *metoda tworząca obiekty typu kwiat, losująca ich położenie oraz umieszczająca obiekty w odpowiednich miejscach tablicy
     */
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
                int [] pomocniczna = new int[2];
                pomocniczna[0]=x;
                pomocniczna[1]=y;
                object3.setWspolrzedne(pomocniczna);
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
                Krokus object6 = new Krokus();
                planszaKwiatow[x][y] = object6;
                int [] pomocniczna = new int[2];
                pomocniczna[0]=x;
                pomocniczna[1]=y;
                object6.setWspolrzedne(pomocniczna);
            }
            else{
                i=i-1;}
        }
    }
    /**
     *metoda tworząca obiekty typu owad, wpisująca je na odpowiednią listę obiektów, losująca ich współrzędne w tablicy oraz ustawiająca je w odpowiednim miejscu
     */
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
            if((planszaOwadow[x][y] == null) && !(x == (int)a && y == (int)b)){
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
            if((planszaOwadow[x][y] == null) && !(x == (int)a && y == (int)b)){
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

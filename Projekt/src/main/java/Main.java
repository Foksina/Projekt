import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * @author Dominika Nurek, Kinga Foksińska
 * @version 1
 */

/**
 * Główna klasa projektu odpowiada za wywoływanie metod i zmiennych z innych klas w odpowiedniej kolejności zgodnej z założeniami symulacji.
 * W klasie zapisujemy również uzyskane wyniki do pliku txt.
 */
public class Main {
    /**
     * zmienna okreslajaca aktualna liczbę pszczół na planszy
     */
    public static int liczbaPszczol;
    /**
     * zmienna okreslajaca aktualna liczbę szerszeni na planszy
     */
    public static int liczbaSzerszeni;
    /**
     * zmienna odpowiedzialna za prawidłowe wyświetlanie symulacji
     */
    public static Plansza plansza;

    /**
     * Metoda służąca do spowolnienia działania programu, dzięki czemu wyświetlanie symulacji jest bardziej przejrzyste. Stworzenie osobnej metody pozwoliło na zrezygnowanie z tworzenia większej ilości wątków.
     */
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    /**
     * Metoda stanowi główne ciało klasy i odpowiada za tworzenie obiektów innych klas i używanie ich metod w odpowiedniej kolejności.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Dane object2 = new Dane(); //stworzenie obiektu typu Dane
        object2.sprawdzDane(); //sprawdzenie poprawności danych podanych przez użytkownika
        PrintWriter zapis = new PrintWriter("symulacja.txt"); //stworzenie pliku do którego zostaną zapisane wyniki symulacji

        liczbaPszczol = object2.getLiczbaPszczol(); //pobranie ilości pszczól
        liczbaSzerszeni = object2.getLiczbaSzerszeni(); //pobranie ilości szerszeni
        zapis.println("Liczba pszczół wynosi: "+Integer.toString(liczbaPszczol)+ ". Liczba szerszeni wynosi: "+Integer.toString(liczbaSzerszeni)); //zapis początkowych paramterów symulacji do pliku

        plansza = new Plansza(); //stworzenie planszy z warunków początkowych
        plansza.setVisible(true); // ustawienie widoczności planszy

        (object2.object).ustawieniaPoczatkowe();  // wywołanie metody z klasy Laka służącej do stworzenie łąki o początkowych paramterach

        while(liczbaPszczol>0 && liczbaSzerszeni>0){ //pętla działająca tak długo, aż któryś z gatunków (pszczoła lub szerszenie) wyginą

            for(int i=0; i<(object2.object.spisPszczol).size();i++){ //pętla odpowiedzialna za ruchy pszczół
                ((object2.object.spisPszczol).get(i)).kolejkaPszczoly(); //ruch pojedynczej pszczoły
                liczbaPszczol = object2.getLiczbaPszczol(); //zaktualizowanie liczby pszczół
                liczbaSzerszeni = object2.getLiczbaSzerszeni(); //zaktualizowanie liczby szerszeni
                zapis.println("Liczba pszczół wynosi: "+Integer.toString(liczbaPszczol)+ ". Liczba szerszeni wynosi: "+Integer.toString(liczbaSzerszeni)); //zapis do pliku po każdym ruchu pszczoły
                plansza.repaint(); //ponowne narysowanie planszy po ruchu pszczóły
                wait(1000); //wywołanie metody spowalniającej symulację
            }

            for(int j=0; j<(object2.object.spisSzerszeni).size(); j++){ //pętla odpowiedzialna za ruchy szerszeni
                ((object2.object.spisSzerszeni).get(j)).kolejkaSzerszenia(); //ruch pojedynczego szerszenia
                liczbaPszczol = object2.getLiczbaPszczol(); //zaktualizowanie liczby pszczol
                liczbaSzerszeni = object2.getLiczbaSzerszeni(); //zaktualizwoanie liczby szerszeni
                zapis.println("Liczba pszczół wynosi: "+Integer.toString(liczbaPszczol)+ ". Liczba szerszeni wynosi: "+Integer.toString(liczbaSzerszeni)); //zapis do pliku po każdym ruchu szerszenia
                plansza.repaint(); //ponowne narysowanie planszy po ruchu szerszenia
            }
        }

        plansza.repaint(); //ponowne narysowanie planszy po wyginięciu jednego z gatunków

        //wypisanie na konsoli odpowiedniego komunikatu kończącego sumulację
        if(liczbaPszczol==0){
            System.out.println("Liczba pszczol wynosi 0. Szerszenie wygraly!\nLiczba szerszeni wynosi "+ liczbaSzerszeni);
        }
        else if(liczbaSzerszeni==0){
            System.out.println("Liczba szerszeni wynosi 0. Pszczoly wygraly!\nLiczba pszczol wynosi "+ liczbaPszczol);
        }
        else{
            System.out.println("Symulacja zakonczyla sie niepowodzeniem!");
        }

        zapis.close(); //zamknięcie pliku txt z zapisanymi danymi
    }
}

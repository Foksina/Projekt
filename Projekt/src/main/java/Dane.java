import java.util.Scanner;
/**
 * Klasa odpowiada za pobranie danych od użytkownika i sprawdzenie ich poprawności.
 */
public class Dane {
    /**
     * zmienna określająca liczbę pszczół zadaną przez użytkownika
     */
    private static int liczbaPszczol;
    /**
     * zmienna określająca liczbę szerszeni zadaną przez użytkownika
     */
    private static int liczbaSzerszeni;
    /**
     * obiekt odpowiedzialny za rozmieszczenie pszczół i szerszeni na planszy
     */
    public Laka object = new Laka();
    /**
     *metoda do pobrania liczby pszczół zadanej przez użytkownika
     */
    public int getLiczbaPszczol(){
        return liczbaPszczol;
    }
    /**
     *metoda do ustawienia liczby pszczół
     */
    public void setLiczbaPszczol(int liczbaPszczol){
        this.liczbaPszczol = liczbaPszczol;
    }
    /**
     *metoda do pobrania liczby szerszeni zadanej przez użytkownika
     */
    public int getLiczbaSzerszeni(){
        return liczbaSzerszeni;
    }
    /**
     *metoda do ustawienia liczby szerszeni
     */
    public void setLiczbaSzerszeni(int liczbaSzerszeni){
        this.liczbaSzerszeni = liczbaSzerszeni;
    }

    /**
     *metoda odpowiedzialna za pobrania danych od użytkownika oraz sprawdzenia ich poprawności (zgodności z założeniami symulacji)
     */
    public void sprawdzDane(){
        while(true){
            System.out.println("Podaj liczbe pszczol: ");
            Scanner odczyt = new Scanner(System.in);
            liczbaPszczol = odczyt.nextInt();
            if(liczbaPszczol <0){
                System.out.println("Liczba pszczol nie moze być ujemna!");
            }
            else if (liczbaPszczol > (0.8*(object.getRozmiarLaki()*object.getRozmiarLaki()))) {
                System.out.println("Liczba pszczol jest zbyt duza!\nPszczol moze byc maksymalnie "+(int)(0.8*(object.getRozmiarLaki()*object.getRozmiarLaki())));
            }
            else {
                break;
            }
        }

        while(true){
            System.out.println("Podaj liczbe szerszeni: ");
            Scanner odczyt2 = new Scanner(System.in);
            liczbaSzerszeni = odczyt2.nextInt();
            if(liczbaSzerszeni <0){
                System.out.println("Liczba szerszeni nie moze byc ujemna!");
            }
            else if (liczbaSzerszeni > ((object.getRozmiarLaki()*object.getRozmiarLaki())- liczbaPszczol-1)) {
                System.out.println("Liczba szerszeni jest zbyt duza!\nSzerszeni moze byc maksymalnie "+(int)((object.getRozmiarLaki()*object.getRozmiarLaki())-liczbaPszczol-1));
            }
            else {
                break;
            }
        }
    }
}

import java.util.Scanner;

public class Main {
    private static int liczbaPszczol;
    private static int liczbaSzerszeni;
    public int getLiczbaPszczol(){
        return liczbaPszczol;
    }
    public void setLiczbaPszczol(int liczbaPszczol){
        this.liczbaPszczol = liczbaPszczol;
    }

    public int getLiczbaSzerszeni(){
        return liczbaSzerszeni;
    }
    public void setLiczbaSzerszeni(int liczbaSzerszeni){
        this.liczbaSzerszeni = liczbaSzerszeni;
    }

    public static void main(String[] args) {
        Main object2 = new Main();
        Laka object = new Laka();

        boolean sprawdzam = false;
        while(sprawdzam == false){
            System.out.println("Podaj liczbę pszczół: ");
            Scanner odczyt = new Scanner(System.in);
            liczbaPszczol = odczyt.nextInt();
            if(liczbaPszczol <0){
                System.out.println("Liczba pszczół nie może być ujemna!");
            }
            else if (liczbaPszczol > (0.5*(object.getRozmiarLaki()*object.getRozmiarLaki()))) {
                System.out.println("Liczba pszczół jest zbyt duża!\nPszczół może być maksymalnie "+(int)(0.5*(object.getRozmiarLaki()*object.getRozmiarLaki())));
            }
            else {
                break;
            }
        }

        while(sprawdzam == false){
            System.out.println("Podaj liczbę szerszeni: ");
            Scanner odczyt2 = new Scanner(System.in);
            liczbaSzerszeni = odczyt2.nextInt();
            if(liczbaSzerszeni <0){
                System.out.println("Liczba szerszeni nie może być ujemna!");
            }
            else if (liczbaSzerszeni > ((object.getRozmiarLaki()*object.getRozmiarLaki())- liczbaPszczol-1)) {
                System.out.println("Liczba szerszeni jest zbyt duża!\nSzerszeni może być maksymalnie "+(int)((object.getRozmiarLaki()*object.getRozmiarLaki())-liczbaPszczol-1));
            }
            else {
                sprawdzam = true;
            }
        }

    }
}

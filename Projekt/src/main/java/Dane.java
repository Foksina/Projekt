import java.util.Scanner;

public class Dane {
    private static int liczbaPszczol;
    private static int liczbaSzerszeni;
    public Laka object = new Laka();
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

    public void sprawdzDane(){
        while(true){
            System.out.println("Podaj liczbę pszczół: ");
            Scanner odczyt = new Scanner(System.in);
            liczbaPszczol = odczyt.nextInt();
            if(liczbaPszczol <0){
                System.out.println("Liczba pszczół nie może być ujemna!");
            }
            else if (liczbaPszczol > (0.8*(object.getRozmiarLaki()*object.getRozmiarLaki()))) {
                System.out.println("Liczba pszczół jest zbyt duża!\nPszczół może być maksymalnie "+(int)(0.8*(object.getRozmiarLaki()*object.getRozmiarLaki())));
            }
            else {
                break;
            }
        }

        while(true){
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
                break;
            }
        }
    }
}

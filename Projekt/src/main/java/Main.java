import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Main {
    public static int liczbaPszczol;
    public static int liczbaSzerszeni;
    public static Plansza plansza;

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

    public static void main(String[] args) throws FileNotFoundException  {
        Dane object2 = new Dane();
        object2.sprawdzDane();
        PrintWriter zapis = new PrintWriter("symulacja.txt");

        liczbaPszczol = object2.getLiczbaPszczol();
        liczbaSzerszeni = object2.getLiczbaSzerszeni();
        zapis.println("Liczba pszczol wynosi: "+Integer.toString(liczbaPszczol)+ ". Liczba szerszeni wynosi: "+Integer.toString(liczbaSzerszeni));

        plansza = new Plansza();
        plansza.setVisible(true);

        (object2.object).ustawieniaPoczatkowe();
        while(liczbaPszczol>0 && liczbaSzerszeni>0){

            for(int i=0; i<(object2.object.spisPszczol).size();i++){
                ((object2.object.spisPszczol).get(i)).kolejkaPszczoly();
                liczbaPszczol = object2.getLiczbaPszczol();
                liczbaSzerszeni = object2.getLiczbaSzerszeni();
                zapis.println("Liczba pszczol wynosi: "+Integer.toString(liczbaPszczol)+ ". Liczba szerszeni wynosi: "+Integer.toString(liczbaSzerszeni));
                plansza.repaint();
                wait(1000);
            }

            for(int j=0; j<(object2.object.spisSzerszeni).size(); j++){
                ((object2.object.spisSzerszeni).get(j)).kolejkaSzerszenia();
                liczbaPszczol = object2.getLiczbaPszczol();
                liczbaSzerszeni = object2.getLiczbaSzerszeni();
                zapis.println("Liczba pszczol wynosi: "+Integer.toString(liczbaPszczol)+ ". Liczba szerszeni wynosi: "+Integer.toString(liczbaSzerszeni));
                plansza.repaint();
                //wait(1000);
            }
        }

        plansza.repaint();

        if(liczbaPszczol==0){
            System.out.println("Liczba pszczol wynosi 0. Szerszenie wygraly!\nLiczba szerszeni wynosi "+ liczbaSzerszeni);
        }
        else if(liczbaSzerszeni==0){
            System.out.println("Liczba szerszeni wynosi 0. Pszczoly wygraly!\nLiczba pszczol wynosi "+ liczbaPszczol);
        }
        else{
            System.out.println("Symulacja zakonczyla sie niepowodzeniem!");
        }
        zapis.close();
    }
}

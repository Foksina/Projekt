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

    public static void main(String[] args) {
        Dane object2 = new Dane();
        object2.sprawdzDane();

        liczbaPszczol = object2.getLiczbaPszczol();
        liczbaSzerszeni = object2.getLiczbaSzerszeni();

        plansza = new Plansza();
        plansza.setVisible(true);

        (object2.object).ustawieniaPoczatkowe();
        while(liczbaPszczol>0 && liczbaSzerszeni>0){

            for(int i=0; i<(object2.object.spisPszczol).size();i++){
                ((object2.object.spisPszczol).get(i)).kolejkaPszczoly();
                liczbaPszczol = object2.getLiczbaPszczol();
                liczbaSzerszeni = object2.getLiczbaSzerszeni();
                plansza.repaint();
                wait(1000);
            }

            for(int j=0; j<(object2.object.spisSzerszeni).size(); j++){
                ((object2.object.spisSzerszeni).get(j)).kolejkaSzerszenia();
                liczbaPszczol = object2.getLiczbaPszczol();
                liczbaSzerszeni = object2.getLiczbaSzerszeni();
                plansza.repaint();
                //wait(1000);
            }
        }

        plansza.repaint();

        if(liczbaPszczol==0){
            System.out.println("Liczba pszczół wynosi 0. Szerszenie wygrały!\nLiczba szerszeni wynosi "+ liczbaSzerszeni);
        }
        else if(liczbaSzerszeni==0){
            System.out.println("Liczba szerszeni wynosi 0. Pszczoły wygrały!\nLiczba pszczół wynosi "+ liczbaPszczol);
        }
        else{
            System.out.println("Symulacja zakończyła się niepowodzeniem!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Dane object2 = new Dane();
        object2.sprawdzDane();

        int liczbaPszczol = object2.getLiczbaPszczol();
        int liczbaSzerszeni = object2.getLiczbaSzerszeni();

        (object2.object).ustawieniaPoczatkowe();
        while(liczbaPszczol>0 && liczbaSzerszeni>0){

            for(int i=0; i<(object2.object.spisPszczol).size();i++){
                ((object2.object.spisPszczol).get(i)).kolejkaPszczoly();
            }

            for(int j=0; j<(object2.object.spisSzerszeni).size(); j++){
                ((object2.object.spisSzerszeni).get(j)).kolejkaSzerszenia();
            }

            liczbaPszczol = object2.getLiczbaPszczol();
            liczbaSzerszeni = object2.getLiczbaSzerszeni();
        }

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

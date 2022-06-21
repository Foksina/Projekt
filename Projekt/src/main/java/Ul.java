import java.util.Random;
/**
 *Klasa odpowiedzialna za przetrzymywanie i zliczanie nektaru oraz tworzenie obiektów typu pszczoła.
 */
public class Ul {
    /**
     *zmienna przechowująca ilość nektaru w obiekcie
     */
    private int sumaNektaru = 0;

    /**
     *metoda sprawdzająca aktualny stan nektaru i wywołująca tworzenie pszczoły
     */
    public void liczNektar(){
        if(sumaNektaru >= 5){
            tworzeniePszczoly();
            sumaNektaru -= 5;
        }
    }
    /**
     *metoda pozwalająca na pobranie aktualnej sumy nektaru w ulu
     */
    public int getSumaNektaru() {
        return sumaNektaru;
    }
    /**
     *metoda pozwalająca na dodanie nektaru do ula
     */
    public void setSumaNektaru(int nowyNektar) {
        sumaNektaru += nowyNektar;
    }

    /**
     *metoda odpowiedzialna za tworzenie obiektu typu pszczoła, dopisanie go do listy obiektów i umieszczenie go na planszy
     */
    private void tworzeniePszczoly(){
        Pszczola object = new Pszczola();
        (Laka.spisPszczol).add(object);
        System.out.println("Powstala nowa pszczola!");
        int x,y;
        boolean n = true;
        while(n == true){
            Random random = new Random();
            x = random.nextInt(Laka.getRozmiarLaki());
            Random random2 = new Random();
            y = random2.nextInt(Laka.getRozmiarLaki());
            if((Laka.planszaOwadow[x][y] == null) && (x != (int)Laka.a) && (y != (int)Laka.b)){
                Laka.planszaOwadow[x][y] = object;
                int [] pomocniczna = new int[2];
                pomocniczna[0]=x;
                pomocniczna[1]=y;
                object.setWspolrzedne(pomocniczna);
                break;
            }
        }

        (Laka.object2).setLiczbaPszczol(((Laka.object2).getLiczbaPszczol()+1));
    }
}

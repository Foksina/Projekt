import java.util.Random;
public class Ul {
    private int sumaNektaru = 0;

    public void liczNektar(){
        if(sumaNektaru >= 5){
            tworzeniePszczoly();
            sumaNektaru -= 5;
        }
    }

    public int getSumaNektaru() {
        return sumaNektaru;
    }
    public void setSumaNektaru(int nowyNektar) {
        sumaNektaru += nowyNektar;
    }

    private void tworzeniePszczoly(){
        Pszczola object = new Pszczola();
        (Laka.spisPszczol).add(object);
        System.out.println("Powstała nowa pszczoła!");
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

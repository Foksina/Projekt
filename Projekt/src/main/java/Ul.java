public class Ul {
    private int sumaNektaru = 0;
    public int iloscPszczol;

    private void liczNektar(int zebranyNektar){
        sumaNektaru += zebranyNektar;
        if(sumaNektaru >= 50){
            tworzeniePszczoly();
            sumaNektaru -= 50;
        }
    }
    private void tworzeniePszczoly(){

    }
}

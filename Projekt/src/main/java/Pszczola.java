public class Pszczola extends Owad{
    private int zebranyNektar;
    Laka object = new Laka();
    public int[][] spisPszczol = object.spisPszczol;
    
    public Pszczola(){
        this.szybkoscPoruszania = 2;
    }

    public int getZebranyNektar() {
        return zebranyNektar;
    }
}

public class Pszczola extends Owad{
    private int zebranyNektar;

    public Pszczola(){
        this.szybkoscPoruszania = 1;
    }

    public int getZebranyNektar() {
        return zebranyNektar;
    }

    public void setZebranyNektar(int nektar) {
        this.zebranyNektar = zebranyNektar;
    }

    public void walka(){
        if(szerszeniWokol >0){
            int x = (Laka.spisSzerszeni).indexOf(listaSzerszeniWokol.get(0));
            (Laka.spisSzerszeni.get(x)).walka();
        }
    }

    public void Nektar(){
        if(zebranyNektar>0){
            int[] x;
            x = getWspolrzedne();
            int [] noweWspolrzedne = new int[2];
            noweWspolrzedne[0] = (int)Laka.a;
            noweWspolrzedne[1] = (int)Laka.b;
            setWspolrzedne(noweWspolrzedne);

            (Laka.object).setSumaNektaru(zebranyNektar);
            zebranyNektar = 0;

            setWspolrzedne(x);
        }
    }

}

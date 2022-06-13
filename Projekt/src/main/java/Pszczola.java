public class Pszczola extends Owad{
    private int zebranyNektar;

    public Pszczola(){
        this.szybkoscPoruszania = 1;
    }

    public void kolejkaPszczoly(){
        boolean p = sprawdzKwiat();
        if(p==true){
            nektarDoUla();
            (Laka.object).liczNektar();
        }
        else{
            ruch(szybkoscPoruszania);
            sprawdzOtoczenie();
            walka();
        }
    }

    private boolean sprawdzKwiat() {
        if(Laka.planszaKwiatow[getWspolrzedne()[0]][getWspolrzedne()[1]] != null){
            setZebranyNektar((Laka.planszaKwiatow[getWspolrzedne()[0]][getWspolrzedne()[1]]).getIloscNektaru());
            (Laka.planszaKwiatow[getWspolrzedne()[0]][getWspolrzedne()[1]]).setIloscNektaru((byte)0);
            return true;
        }
        else{
            return false;
        }
    }

    public int getZebranyNektar() {
        return zebranyNektar;
    }

    public void setZebranyNektar(int nektar) {
        this.zebranyNektar += nektar;
    }

    private void walka(){
        if(szerszeniWokol >0){
            int x = (Laka.spisSzerszeni).indexOf(listaSzerszeniWokol.get(0));
            (Laka.spisSzerszeni.get(x)).walka();
        }
    }

    private void nektarDoUla(){
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

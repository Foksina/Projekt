/**
 *Klasa dziedzicząca po klasie Owad. Odpowiedzialna za ustawienie szybkości pszczoły, określająca kolejność ruchów, symulację walki oraz zbierania nektaru i jego transportu do ula.
 */
public class Pszczola extends Owad{
    /**
     *zmienna przechowująca ilość nektaru zebranego z kwiata
     */
    private int zebranyNektar;

    /**
     *metoda ustawiająca szybkosc poruszania pszczoly
     */
    public Pszczola(){
        this.szybkoscPoruszania = 1;
    }

    /**
     *metoda definująca kolejność zachowań pszczoły w jej ruchu
     */
    public void kolejkaPszczoly(){
        boolean p = sprawdzKwiat();
        if(p==true){
            nektarDoUla();
            (Laka.object).liczNektar();
        }
        else{
            ruch(szybkoscPoruszania);

            ((Laka.object3).plansza).repaint();
            (Laka.object3).wait(1000);

            sprawdzOtoczenie();
            walka();
        }
    }
    /**
     *metoda pozwalająca sprawdzić, czy na polu na którym jest pszczoła jest kwiat mający nektar
     */
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
    /**
     *metoda pozwalająca na pobranie ilosci zebranego nektaru
     */
    public int getZebranyNektar() {
        return zebranyNektar;
    }
    /**
     *metoda pozwalająca na nadanie ilosci zebranego nektaru
     */
    public void setZebranyNektar(int nektar) {
        this.zebranyNektar += nektar;
    }
    /**
     *metoda definiująca warunki otoczenia do odbycia się walki oraz wywołująca walkę
     */
    private void walka(){
        if(szerszeniWokol >0){
            int x = (Laka.spisSzerszeni).indexOf(listaSzerszeniWokol.get(0));
            (Laka.spisSzerszeni.get(x)).walka();
        }
    }

    /**
     *metoda okreslająca ruch pszczoły do ula, zostawienie tam nektaru oraz powrót na wcześniejszą pozycję
     */
    private void nektarDoUla(){
        if(zebranyNektar>0){
            int[] x;
            x = getWspolrzedne();
            int [] noweWspolrzedne = new int[2];
            noweWspolrzedne[0] = (int)Laka.a;
            noweWspolrzedne[1] = (int)Laka.b;
            setWspolrzedne(noweWspolrzedne);
            Laka.planszaOwadow[noweWspolrzedne[0]][noweWspolrzedne[1]] = this;

            (Laka.object).setSumaNektaru(zebranyNektar);
            zebranyNektar = 0;

            setWspolrzedne(x);
            Laka.planszaOwadow[noweWspolrzedne[0]][noweWspolrzedne[1]] = null;
            Laka.planszaOwadow[x[0]][x[1]] = this;
        }
    }

}

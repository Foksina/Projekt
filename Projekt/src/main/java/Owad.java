public class Owad {
    private int [][] wspolrzedne;
    protected int liczbaGatunku;  //zmienna, która zlicza ile jest owadow danego gatunku
    protected byte szybkoscPoruszania;

    protected void ruch (byte szybkoscPoruszania){

    }

    protected void walka(){

    }

    public int[][] getWspolrzedne() {
        return wspolrzedne;
    }

    public void setWspolrzedne(int[][] wspolrzedne) {
        this.wspolrzedne = wspolrzedne;
    }
    public byte getSzybkoscPoruszania() {
        return szybkoscPoruszania;
    }
}

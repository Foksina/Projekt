/**
 *Klasa potrzebna do tworzenia obiektów, po której dziedziczy Lawenda oraz Krokus. Zawiera współrzędne obiektów oraz zmienną odpowiedzialną za ilość nektaru w obiekcie.
 */
public class Kwiat {
    /**
     *zmienna współrzędnych obiektu
     */
    private int [] wspolrzedne;
    /**
     *zmienna określająca ilość nektaru w obiekcie w danym momencie symulacji
     */
    protected byte iloscNektaru;

    /**
     *metoda pozwalająca na pobranie współrzędnych obiektu
     */
    public int[] getWspolrzedne() {
        return wspolrzedne;
    }

    /**
     *metoda pozwalająca na nadanie współrzednych obiektu
     */
    public void setWspolrzedne(int[] wspolrzedne) {
        this.wspolrzedne = wspolrzedne;
    }
    /**
     *metoda pozwalająca na pobranie ilosci nektaru
     */
    public byte getIloscNektaru() {
        return iloscNektaru;
    }
    /**
     *metoda pozwalająca na nadanie ilosci nektaru
     */
    public void setIloscNektaru(byte iloscNektaru) {
        this.iloscNektaru = iloscNektaru;
    }
}

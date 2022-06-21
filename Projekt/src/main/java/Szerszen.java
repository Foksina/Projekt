/**
 *Klasa dziedzicząca po klasie Owad. Odpowiedzialna za ustawienie szybkości szerszenia, określająca kolejność ruchów oraz symulację walki.
 */
public class Szerszen extends Owad{
    /**
     *metoda ustawiająca szybkosc poruszania szerszenia
     */
    public Szerszen(){
        this.szybkoscPoruszania = 2;
    }
    /**
     *metoda definująca kolejność zachowań szerszenia w jego ruchu
     */
    public void kolejkaSzerszenia(){
            ruch(szybkoscPoruszania);
        ((Laka.object3).plansza).repaint();
        (Laka.object3).wait(1000);
            sprawdzOtoczenie();
            walka();
    }
    /**
     *metoda definiująca warunki otoczenia do odbycia się walki oraz wywołująca walkę - usunięcie konkretnego obiektu w zależności od warunków
     */
    public void walka(){
        if(pszczolWokol == 1){
            Owad pszcz = listaPszczolWokol.get(0);
            (Laka.spisPszczol).remove(pszcz);
            Laka.planszaOwadow[listaPszczolWokol.get(0).getWspolrzedne()[0]][listaPszczolWokol.get(0).getWspolrzedne()[1]] = null;

            (Laka.object2).setLiczbaPszczol(((Laka.object2).getLiczbaPszczol()-1));
            System.out.println("Zabito pszczole!");
        }
        else if (pszczolWokol>1){
            Owad szer = Laka.planszaOwadow[getWspolrzedne()[0]][getWspolrzedne()[1]];
            (Laka.spisSzerszeni).remove(szer);
            Laka.planszaOwadow[getWspolrzedne()[0]][getWspolrzedne()[1]] = null;

            (Laka.object2).setLiczbaSzerszeni(((Laka.object2).getLiczbaSzerszeni()-1));
            System.out.println("Zabito szerszenia!");
        }
    }
}

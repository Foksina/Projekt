import java.util.Random;
import java.util.LinkedList;
/**
 *Klasa po której dziedziczy Pszczola oraz Szerszen. Definiująca obiektów po planszy w zależności od szybkości poruszania, sprawdzająca otoczenie obiektu na planszy, przechowująca zmienne obiektów jak np. wspolrzedne.
 */
public class Owad {
    /**
     *zmienna definiująca wspólrzędne obiektu na dwuwymiarowej tablicy
     */
    private int[] wspolrzedne = new int[2];
    /**
     *zmienna definiująca szybkosc poruszania obiektu po planszy
     */
    protected byte szybkoscPoruszania;
    /**
     *zmienna określająca ilośc pszczół wokół obiektu na planszy
     */
    public int pszczolWokol;
    /**
     *zmienna określająca ilość szerszeni wokół obiektu na planszy
     */
    public int szerszeniWokol;
    /**
     *zmienna przechowująca wszystkie możliwe ruchy (współrzędne po wykonaniu ruchu) dla konkretnego obiektu w ciągu jednego ruchu
     */
    public int mozliwosci[][];
    /**
     *zmienna przechowująca obiekty typu Pszczola, które znajdują się wokół obiektu na planszy
     */
    public LinkedList<Owad> listaPszczolWokol = new LinkedList<>();
    /**
     *zmienna przechowująca obiekty typu Szerszen, które znajdują się wokół obiektu na planszy
     */
    public LinkedList<Owad> listaSzerszeniWokol = new LinkedList<>();

    /**
     *metoda okreslająca ruch obiektu w zależności od szybkosci poruszania
     */
    protected void ruch (byte szybkoscPoruszania){
       //tworzenie tablicy możliwych ruchów
        if(szybkoscPoruszania==1){
            mozliwosci = new int[8][2];
        }
        else if(szybkoscPoruszania==2){
            mozliwosci = new int[24][2];
        }

        int k =0;
        for(int i =(-1 * szybkoscPoruszania); i<= szybkoscPoruszania; i++){
            for(int j =(-1 * szybkoscPoruszania); j<= szybkoscPoruszania; j++){
                if(i!=0 || j!=0){
                    if((wspolrzedne[0]+i)>=0 && (wspolrzedne[1]+j)>=0){
                        if((wspolrzedne[0]+i)<Laka.getRozmiarLaki()){
                            mozliwosci[k][0] = wspolrzedne[0]+i;
                        }
                        else{
                            mozliwosci[k][0] = wspolrzedne[0];
                        }

                        if((wspolrzedne[1]+j)<Laka.getRozmiarLaki()){
                            mozliwosci[k][1] = wspolrzedne[1]+j;
                        }
                        else{
                            mozliwosci[k][1] = wspolrzedne[1];
                        }
                        k=k+1;
                    }
                }
            }
        }
        // losowanie ruchu w możliwych ruchów na liście
        Random random = new Random();
        int x = random.nextInt(k); //losowanie nr indeksu tablicy mozliwosci
        if(Laka.planszaOwadow[mozliwosci[x][0]][mozliwosci[x][1]]==null && !(mozliwosci[x][0]== Laka.a && mozliwosci[x][1]== Laka.b)){
            Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]]=null;
            wspolrzedne[0] = mozliwosci[x][0];  //ruch w poziomie
            wspolrzedne[1] = mozliwosci[x][1];  //ruch w pionie
            Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]] = this;
        }

    }

    /**
     *metoda sprawdzająca otoczenie obiektu na planszy
     */
    public void sprawdzOtoczenie(){
       pszczolWokol = 0;
       szerszeniWokol =0;
       listaPszczolWokol.clear();
       listaSzerszeniWokol.clear();

        if((wspolrzedne[0] < (Laka.getRozmiarLaki()-1))) //pole "pod"
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]])){
                pszczolWokol = pszczolWokol+1;
                listaPszczolWokol.add(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]]);
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]])){
                szerszeniWokol = szerszeniWokol +1;
                listaSzerszeniWokol.add(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]]);
            }
        }

        if((wspolrzedne[0] < (Laka.getRozmiarLaki()-1))&&(wspolrzedne[1] > 0)) //pole na ukos na dole po lewej
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]-1])){
                pszczolWokol = pszczolWokol+1;
                listaPszczolWokol.add(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]-1]);
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]-1])){
                szerszeniWokol = szerszeniWokol +1;
                listaSzerszeniWokol.add(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]-1]);
            }
        }

        if(wspolrzedne[1] > 0) //pole po lewej
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]-1])){
                pszczolWokol = pszczolWokol+1;
                listaPszczolWokol.add(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]-1]);
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]-1])){
                szerszeniWokol = szerszeniWokol +1;
                listaSzerszeniWokol.add(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]-1]);
            }
        }
        if((wspolrzedne[0] > 0 )&&(wspolrzedne[1] > 0)) //pole na ukos po lewej u góry
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]-1])){
                pszczolWokol = pszczolWokol+1;
                listaPszczolWokol.add(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]-1]);
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]-1])){
                szerszeniWokol = szerszeniWokol +1;
                listaSzerszeniWokol.add(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]-1]);
            }
        }

        if(wspolrzedne[0] > 0) //pole "nad"
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]])){
                pszczolWokol = pszczolWokol+1;
                listaPszczolWokol.add(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]]);
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]])){
                szerszeniWokol = szerszeniWokol +1;
                listaSzerszeniWokol.add(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]]);
            }
        }

        if((wspolrzedne[0] > 0)&&(wspolrzedne[1] < (Laka.getRozmiarLaki()-1))) //pole na ukos po prawej u góry
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]+1])){
                pszczolWokol = pszczolWokol+1;
                listaPszczolWokol.add(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]+1]);
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]+1])){
                szerszeniWokol = szerszeniWokol +1;
                listaSzerszeniWokol.add(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]+1]);
            }
        }

        if(wspolrzedne[1] < (Laka.getRozmiarLaki()-1)) //pole po prawej
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]+1])){
                pszczolWokol = pszczolWokol+1;
                listaPszczolWokol.add(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]+1]);
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]+1])){
                szerszeniWokol = szerszeniWokol +1;
                listaSzerszeniWokol.add(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]+1]);
            }
        }

        if((wspolrzedne[0] < (Laka.getRozmiarLaki()-1))&&(wspolrzedne[1] < (Laka.getRozmiarLaki()-1))) //pole na ukos po prawej na dole
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]+1])){
                pszczolWokol = pszczolWokol+1;
                listaPszczolWokol.add(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]+1]);
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]+1])){
                szerszeniWokol = szerszeniWokol +1;
                listaSzerszeniWokol.add(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]+1]);
            }
        }
    }

    /**
     *metoda pozwalający pobrać wspolrzedne obiektu
     */
    public int[] getWspolrzedne() {
        return wspolrzedne;
    }
    /**
    *metoda pozwalający nadać wspolrzedne obiektu
    */
    public void setWspolrzedne(int[] wspolrzedne) {
        this.wspolrzedne = wspolrzedne;
    }
    /**
     *metoda pozwalający pobrać szybkosc obiektu
     */
    public byte getSzybkoscPoruszania() {
        return szybkoscPoruszania;
    }
}

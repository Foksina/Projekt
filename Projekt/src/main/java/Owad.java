import java.util.Random;
public class Owad {
    private int[] wspolrzedne;
    protected int liczbaGatunku;  //zmienna, która zlicza ile jest owadow danego gatunku
    protected byte szybkoscPoruszania;
    public int pszczolWokol;
    public int szerszeniWokol;
    public int mozliwosci[][];

    protected void ruch (byte szybkoscPoruszania){
       //tworzenie listy możliwych ruchów
        int k =0;
        for(int i =(-1 * szybkoscPoruszania); i<= szybkoscPoruszania; i++){
            for(int j =(-1 * szybkoscPoruszania); j<= szybkoscPoruszania; j++){
                if(i!=0 || j!=0){
                    if((wspolrzedne[0]+i)>=0 && (wspolrzedne[1]+j)>=0){
                        mozliwosci[k][0] = wspolrzedne[0]+i;
                        mozliwosci[k][1] = wspolrzedne[1]+j;
                        k=k+1;
                    }
                }
            }
        }
        // losowanie ruchu w możliwych ruchów na liście
        Random random = new Random();
        int x = random.nextInt(k+1); //losowanie nr indeksu tablicy mozliwosci
        wspolrzedne[0] = mozliwosci[x][0];  //ruch w poziomie
        wspolrzedne[1] = mozliwosci[x][1];  //ruch w pionie
    }

    public void sprawdzOtoczenie(){
       pszczolWokol = 0;
       szerszeniWokol =0;
        if((wspolrzedne[0] < (Laka.getRozmiarLaki()-1))) //pole "pod"
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]])){
                pszczolWokol = pszczolWokol+1;
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]])){
            szerszeniWokol = szerszeniWokol +1;
            }
        }

        if((wspolrzedne[0] < (Laka.getRozmiarLaki()-1))&&(wspolrzedne[1] > 0)) //pole na ukos na dole po lewej
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]-1])){
                pszczolWokol = pszczolWokol+1;
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]-1])){
                szerszeniWokol = szerszeniWokol +1;
            }
        }

        if(wspolrzedne[1] > 0) //pole po lewej
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]-1])){
                pszczolWokol = pszczolWokol+1;
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]-1])){
                szerszeniWokol = szerszeniWokol +1;
            }
        }
        if((wspolrzedne[0] > 0 )&&(wspolrzedne[1] > 0)) //pole na ukos po lewej u góry
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]-1])){
                pszczolWokol = pszczolWokol+1;
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]-1])){
                szerszeniWokol = szerszeniWokol +1;
            }
        }

        if(wspolrzedne[0] > 0) //pole "nad"
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]])){
                pszczolWokol = pszczolWokol+1;
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]])){
                szerszeniWokol = szerszeniWokol +1;
            }
        }

        if((wspolrzedne[0] > 0)&&(wspolrzedne[1] < (Laka.getRozmiarLaki()-1))) //pole na ukos po prawej u góry
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]+1])){
                pszczolWokol = pszczolWokol+1;
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]-1][wspolrzedne[1]+1])){
                szerszeniWokol = szerszeniWokol +1;
            }
        }

        if(wspolrzedne[1] < (Laka.getRozmiarLaki()-1)) //pole po prawej
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]+1])){
                pszczolWokol = pszczolWokol+1;
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]+1])){
                szerszeniWokol = szerszeniWokol +1;
            }
        }

        if((wspolrzedne[0] < (Laka.getRozmiarLaki()-1))&&(wspolrzedne[1] < (Laka.getRozmiarLaki()-1))) //pole na ukos po prawej na dole
        {
            if((Laka.spisPszczol).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]+1])){
                pszczolWokol = pszczolWokol+1;
            }
            else if ((Laka.spisSzerszeni).contains(Laka.planszaOwadow[wspolrzedne[0]+1][wspolrzedne[1]+1])){
                szerszeniWokol = szerszeniWokol +1;
            }
        }
    }

    public int getLiczbaGatunku() {
        return liczbaGatunku;
    }

    public void setLiczbaGatunku(int liczbaGatunku) {
        this.liczbaGatunku = liczbaGatunku;
    }

    public int[] getWspolrzedne() {
        return wspolrzedne;
    }

    public void setWspolrzedne(int[] wspolrzedne) {
        this.wspolrzedne = wspolrzedne;
    }
    public byte getSzybkoscPoruszania() {
        return szybkoscPoruszania;
    }
}

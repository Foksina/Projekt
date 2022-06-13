import java.util.Random;
import java.util.LinkedList;
public class Owad {
    private int[] wspolrzedne = new int[2];
    protected byte szybkoscPoruszania;
    public int pszczolWokol;
    public int szerszeniWokol;
    public int mozliwosci[][];
    public LinkedList<Owad> listaPszczolWokol = new LinkedList<>();
    public LinkedList<Owad> listaSzerszeniWokol = new LinkedList<>();


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
        if(Laka.planszaOwadow[mozliwosci[x][0]][mozliwosci[x][1]]==null){
            Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]]=null;
            wspolrzedne[0] = mozliwosci[x][0];  //ruch w poziomie
            wspolrzedne[1] = mozliwosci[x][1];  //ruch w pionie
            Laka.planszaOwadow[wspolrzedne[0]][wspolrzedne[1]] = this;
        }

    }

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

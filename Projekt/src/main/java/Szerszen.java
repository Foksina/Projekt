public class Szerszen extends Owad{

    public Szerszen(){
        this.szybkoscPoruszania = 2;
    }
    public void walka(){
        if(pszczolWokol == 1){
            (Laka.spisPszczol).remove(listaPszczolWokol.get(0));
            Laka.planszaOwadow[listaPszczolWokol.get(0).getWspolrzedne()[0]][listaPszczolWokol.get(0).getWspolrzedne()[1]] = null;

            (Laka.object2).setLiczbaPszczol(((Laka.object2).getLiczbaPszczol()-1));
        }
        else if (pszczolWokol>1){
            (Laka.spisSzerszeni).remove(Laka.planszaOwadow[getWspolrzedne()[0]][getWspolrzedne()[1]]);
            Laka.planszaOwadow[getWspolrzedne()[0]][getWspolrzedne()[1]] = null;

            (Laka.object2).setLiczbaSzerszeni(((Laka.object2).getLiczbaSzerszeni()-1));
        }
    }
}

public class Main {
    private int liczbaPszczol = 4;
    private int liczbaSzerszeni = 2;

    public int getLiczbaPszczol(){
        return liczbaPszczol;
    }
    public void setLiczbaPszczol(int liczbaPszczol){
        this.liczbaPszczol = liczbaPszczol;
    }

    public int getLiczbaSzerszeni(){
        return liczbaSzerszeni;
    }
    public void setLiczbaSzerszeni(int liczbaSzerszeni){
        this.liczbaSzerszeni = liczbaSzerszeni;
    }

    public static int main(String[] args) {
        new Łąka();
        return 0;
    }
}

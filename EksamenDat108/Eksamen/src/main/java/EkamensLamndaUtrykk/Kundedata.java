package EkamensLamndaUtrykk;

public class Kundedata {
    private String navn;
    private int forbruk;

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getForbruk() {
        return forbruk;
    }

    public void setForbruk(int forbruk) {
        this.forbruk = forbruk;
    }

    public Kundedata(String navn, int forbruk) {
        this.navn = navn;
        this.forbruk = forbruk;
    }
}

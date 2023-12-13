package EkamensLamndaUtrykk;

public class Bil {
    private String skilt;
    private String bilMerke;

    public String getSkilt() {
        return skilt;
    }

    public void setSkilt(String skilt) {
        this.skilt = skilt;
    }

    public String getBilMerke() {
        return bilMerke;
    }

    public void setBilMerke(String bilMerke) {
        this.bilMerke = bilMerke;
    }

    public Bil(String skilt, String bilMerke) {
        this.skilt = skilt;
        this.bilMerke = bilMerke;
    }
}

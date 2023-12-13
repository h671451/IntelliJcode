public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {
    private int antall;
    private BinaerTreNode<T> rot;
    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }

    // … get- og set metoder kan du anta
    public String toString() {
        return toString(rot);
    }
    private String toString(BinaerTreNode<T> p) {
        String Listen = null;
        if (p == null){
            return "";
        } else{
            return toString(p.getVenstre()) + "/n" + p.getElement() + toString(p.getHoyre());
        }



    }
    public static <T extends Comparable<T>> boolean
    verifiserBSTre(BinaerTre<T> detAndre) {
        return verifiserBSTre(detAndre.getRot());
    }
    private static <T extends Comparable<T>> boolean verifiserBSTre(BinaerTreNode<T> p){
        if (p == null){
            return true;
        }
        if (p.getVenstre().getElement().compareTo(p.getElement()) >=0){
            return false;
        }

        if (p.getHoyre().getElement().compareTo(p.getElement()) < 0){
            return false;
        }

        return verifiserBSTre(p.getVenstre()) && verifiserBSTre(p.getHoyre());

    }
// … andre metoder
}
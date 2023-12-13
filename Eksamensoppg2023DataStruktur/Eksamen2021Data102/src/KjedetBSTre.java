public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {
    private int antall;
    private BinaerTreNode<T> rot;
    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }

    // … get- og set metoder kan du anta
    public T finnMinste() {
        if(antall == 0) return null;
        BinaerTreNode<T> temp = rot;
        if (temp.getVenstre() == null){
            return temp.getElement();
        } else{
            while (temp.getVenstre() != null){
                temp = temp.getVenstre();


            }

        }
        return temp.getElement();
    }
    public int antallBlad() {
        return antallBladRek(rot);
    }
    private int antallBladRek(BinaerTreNode<T> p) {
       int teller = 0;
        if(p == null){
            return 0;
        } else if (p.getVenstre() == null && p.getHoyre()==null) {
            return 1;
        } else {
            return antallBladRek(p.getVenstre()) + antallBladRek(p.getHoyre());
        }
    }
    // … andre metoder
}

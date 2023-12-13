public class KjedetBSTreOving<T extends Comparable<T>>
        implements BSTreADT<T>, Iterable<T> {
    private int antall;
    private BinaerTreNode<T> rot;
    public KjedetBSTreOving() {
        antall = 0;
        rot = null;
    }
    public KjedetBSTreOving(T element) {
    rot = new BinaerTreNode<>(element);
    antall = 1;
    }
    //set- og get-metoder kan du anta
    public int antall() {
        return antall;
    }
    public boolean erTom() {
        return (antall == 0);
    }
    public T finnMin() {
        BinaerTreNode<T> temp = rot;
        if (erTom()){
            return null;
        } else {
            while (temp.getVenstre() != null) {
                temp = temp.getVenstre();
            }
            return temp.getElement();
        }

    }
    public void skrivInorden() {
        skrivInorden (rot);
    }
    private void skrivInorden(BinaerTreNode<T> p) {
        if (p != null){
            skrivInorden(p.getVenstre());
            System.out.print(p.getElement() + " ");
            skrivInorden(p.getHoyre());
        }
    }
    public int antallNoder() {
        return antallNoder(rot);
    }
    private int antallNoder(BinaerTreNode<T> p) {
    int teller = 0;
    if (p == null){
        return 0;
    }else {
        return 1 + antallNoder(p.getVenstre()) + antallNoder(p.getHoyre());
    }
    }
    public BinaerTreNode<T> tabTilBS(T[] tab){
        BinaerTreNode<T> rot = tabTilBS(tab, 0, tab.length-1);
        return rot;
    }
    private BinaerTreNode<T> tabTilBS(T tab[], int start, int siste) {
//e) Fyll ut
    }
}

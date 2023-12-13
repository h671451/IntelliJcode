import java.util.NoSuchElementException;

public abstract class KjedetBSTre<T extends Comparable<T>>
        implements BSTreADT<T>, Iterable<T> {
    private int antall;
    private BinaerTreNode<T> rot;
    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }
    public KjedetBSTre(T element) {
    rot = new BinaerTreNode<T>(element);
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
        if (erTom() == true) return null;
        BinaerTreNode<T> temp = rot;
        if (temp.getVenstre() == null){
            return temp.getElement();
        } else{
            while(temp.getVenstre() != null){
                temp = temp.getVenstre();
            }
        }
        return temp.getElement();
    }
    public void skrivInorden() {
        skrivInorden (rot);
    }
    private void skrivInorden(BinaerTreNode<T> p) {
        if (p != null){
            skrivInorden(p.getVenstre());
            System.out.print(p.getElement() + "");
            skrivInorden(p.getHoyre());
        }

    }
    public int antallNoder() {
        return antallNoder(rot);
    }
    private int antallNoder(BinaerTreNode<T> p) {
        if(p == null)
            return 0;
        return 1+ antallNoder(p.getVenstre()) + antallNoder(p.getHoyre());
    }
    public BinaerTreNode<T> tabTilBS(T[] tab){
        BinaerTreNode<T> rot = tabTilBS(tab, 0, tab.length-1);
        return rot;
    }
    private BinaerTreNode<T> tabTilBS(T tab[], int start, int siste) {
//e) Fyll ut
    }

    public static <T extends Comparable<T>> void fletteSort(T[] tabell,
                                                            int forste, int siste) {
        if (forste < siste) { // minst to element
            int midten = (forste + siste) / 2;
            // Sorter venstre halvdel tabell[forste,midten];
            fletteSort(tabell, forste, midten);
            // Sorter høyre halvdel tabell[midten+1...siste]
            fletteSort(tabell, midten + 1, siste);
            // Fletter de to halvdelene
            flette(tabell, forste, midten, siste);
        }
    }
}



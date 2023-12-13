package Oppgave2;

public class KjedetBSTre<T extends Comparable<T>> implements BSTreADT<T> {
    private int antall;
    private BinaerTreNode<T> rot;
    public KjedetBSTre() {
        antall = 0;
        rot = null;
    }
    //..andre metoder
    public void visPostorden() {
        visRekPostorden(rot);
        System.out.println();
    }
    private void visRekPostorden() {
        visRekPostorden(this.rot);
    }
    private void visRekPostorden(BinaerTreNode<T> p) {
        if(p !=null){
            visRekPostorden(p.getVenstre());
            visRekPostorden(p.getHoyre());
            System.out.print(p.getElement() + " ");
        }
    }

    public T finn(T element) {
        return finnRek(element, rot);
    }
    private T finnRek(T element, BinaerTreNode<T> p) {
        if (p == null) { // base case: element not found
            return null;
        } else if (element.compareTo(p.getElement()) == 0) { // base case: element found
            return p.getElement();
        } else if (element.compareTo(p.getElement()) < 0) { // recursive case: element is in left subtree
            return finnRek(element, p.getVenstre());
        } else { // recursive case: element is in right subtree
            return finnRek(element, p.getHoyre());
        }
    }
    public boolean erIdentisk(KjedetBSTre<T> t){
        return erIdentiskRek(rot, t.rot);
    }

    private boolean erIdentiskRek(BinaerTreNode<T> t1, BinaerTreNode<T> t2) {
        if (t1 == null && t2 == null) { // base case: both trees are empty
            return true;
        } else if (t1 == null || t2 == null) { // base case: only one tree is empty
            return false;
        } else if (t1.getElement().compareTo(t2.getElement()) != 0) { // base case: elements do not match
            return false;
        } else { // recursive case: check left and right subtrees for identity
            return erIdentiskRek(t1.getVenstre(), t2.getVenstre()) && erIdentiskRek(t1.getHoyre(), t2.getHoyre());
        }
    }
}


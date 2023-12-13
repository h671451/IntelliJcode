public class KjedetUordnetListe<T extends Comparable<T>> implements
        UordnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste;

    public KjedetUordnetListe() {
        antall = 0;
        foerste = null;
    }

    public String toString() {
        return toString(foerste);
    }

    private String toString(LinearNode<T> p) {
        if (p == null) {
            return "";
        } else {
            return p.getElement() + "/n" + toString(p.getNeste());
        }
    }

    public void settInn(T el) {
        LinearNode<T> nyNode = new LinearNode<>(el);
        if (antall == 0) {
            foerste.setNeste(nyNode);
        } else {
            nyNode.setNeste(foerste);
            foerste = nyNode;
        }
        antall++;
    }

    public void settInnOving(T el) {
        LinearNode<T> nyNode = new LinearNode<>(el);
        if (antall == 0) {
            foerste.setNeste(nyNode);
        } else {
            nyNode.setNeste(foerste);
            foerste = nyNode;
        }
        antall++;
    }

    public void flyttFoersteTilSiste() {
        if (antall < 1) {
            LinearNode<T> siste = foerste;
            foerste = foerste.getNeste();
            LinearNode<T> temp = foerste;

            while (siste.getNeste() != null) {
                siste = siste.getNeste();
            } // finner man det siste elementet
            siste.setNeste(temp);
            temp.setNeste(null);
        }
    }

    public void flyttFoersteTilSisteOving() {
        LinearNode<T> siste = foerste;
        LinearNode<T> tempF = foerste;
        foerste = foerste.getNeste();
        if (antall > 1) {
            while (siste.getNeste() != null) {
                siste = siste.getNeste();
            }
            siste.setNeste(tempF);
            tempF.setNeste(null);
        }
    }

    public T finnNesteMinsteOving() {
        LinearNode<T> minste = foerste;
        LinearNode<T> nestMinste = foerste.getNeste();
        if (antall < 2) {
            return null;
        } else {
            while (nestMinste.getNeste() != null) {
                if (nestMinste.getElement().compareTo(minste.getElement()) < 0) {
                    LinearNode<T> temp = minste;
                    minste = nestMinste;
                    nestMinste = temp;
                } else if (nestMinste.getElement().compareTo(minste.getElement()) > 0) {
                    nestMinste = nestMinste.getNeste();
                } else {
                    nestMinste = nestMinste.getNeste();
                }

            }
            return nestMinste.getElement();
        }
    }

    public T finnNestMinste() {
        T svar = null;
        if (antall >= 2) {
            LinearNode<T> minste = foerste;
            LinearNode<T> nestMinste = foerste;
            LinearNode<T> denne = foerste.getNeste();
            while (denne != null) {
                if (denne.getElement().compareTo(minste.getElement()) < 0) {
                    nestMinste = minste;
                    minste = denne;
                } else {
                    if (denne.getElement().compareTo(nestMinste.getElement()) < 0) {
                        nestMinste = denne;
                    }
                    denne = denne.getNeste();
                }
                svar = nestMinste.getElement();
            }

        }
        return svar;
    }
}
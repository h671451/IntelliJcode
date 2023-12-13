public class KjedetOrdnetListe<T extends Comparable<T>>
        implements OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste;
    private LinearNode<T> siste;

    // get – og set-metoder kan du anta
    public int antall() {
        return antall;
    }
    public boolean erTom() {
        return antall == 0;
    }
    public KjedetOrdnetListe(T minVerdi, T maksVerdi){
        foerste = new LinearNode<>(minVerdi);
        siste = new LinearNode<>(maksVerdi);
        antall = 0;
    }

    public T finnMaks() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste tom");

        if (erTom()) return null;

        LinearNode<T> maksNode = foerste;

        while (maksNode.getNeste() != siste ){
            maksNode = maksNode.getNeste();
        }
        return maksNode.getElement();
    }

    public boolean fjernAlle(T el) {
        if (erTom())
            throw new EmptyCollectionException("tom ordnet liste");

        boolean resultat = false;

        LinearNode<T> AlleELSomSlettes = foerste.getNeste();
        LinearNode<T> FraOgMedElSomSlettes = foerste;

        while (el.compareTo(AlleELSomSlettes.getElement()) > 0){
            FraOgMedElSomSlettes = AlleELSomSlettes;
            AlleELSomSlettes = AlleELSomSlettes.getNeste();
        }

        if (el.equals(AlleELSomSlettes.getElement())){ //funnet EL
            resultat = true;
            int teller = 1;
            AlleELSomSlettes = AlleELSomSlettes.getNeste();
            while (el.equals(AlleELSomSlettes.getElement())){
            AlleELSomSlettes = AlleELSomSlettes.getNeste();
            teller++;
            }
            FraOgMedElSomSlettes.setNeste(AlleELSomSlettes);
            antall = antall - teller;
        }
        return resultat;

    }

    private boolean erLikRek(LinearNode<T> p1, LinearNode<T> p2){
        if (p1 == null && p2 == null){
            return true;
        } else if (p1 == null || p2 == null){
            return false;
        } else if (p1.getElement().equals(p2.getElement())) {
            return erLikRek(p1.getNeste(),p2.getNeste());
        }else {
            return false;
        }

    }
    public void snu() {
// fyll inn

        LinearNode<T> temp = foerste;
        LinearNode<T> n;
        siste = foerste;
        LinearNode<T> tempFoerste = null;

        while (temp.getNeste() != null){
            n = temp;
            n.setNeste(tempFoerste);
            temp = temp.getNeste();
            tempFoerste = n;

        }
        foerste = tempFoerste;

    }

    //Denne metoden deller opp tabellen sånn at alle elementene i tabellen
    // ligger i en egen tabellen,
    // deretter sorteres den ut i stigenene rekkefølge

    public void fletteSort(T[] tabell, int forste, int siste){
        if(forste < siste){
            int midIndex = tabell.length/2;
            fletteSort(tabell,forste,midIndex);
            fletteSort(tabell,midIndex+1,siste);

            flette(tabell,forste,midIndex,siste);

        }

    }








}

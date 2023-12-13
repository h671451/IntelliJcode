public class KjedetOrdnetListeOving<T extends Comparable<T>> implements
        OrdnetListeADT<T> {
    private int antall;
    private LinearNode<T> foerste, siste;

    // kan anta du har get- & set-metoder, antall() og erTom() om du trenger
    public KjedetOrdnetListeOving() {
        antall = 0;
        foerste = null;
        siste = null;
    }
    public T fjernFoerste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");
        T tempF = foerste.getElement();
        if (antall == 1){
            foerste = null;
            siste = null;
        }else {
            foerste = foerste.getNeste();
        }
        antall--;
        if (antall == 0){
            siste = null;
        }
        return tempF;
    }

    public void leggTil(T element) {
       LinearNode<T> newNode = new LinearNode<>(element);
       if (antall == 0){
           foerste = newNode;
           siste = newNode;
       } else if (newNode.getElement().compareTo(foerste.getElement()) < 0) {
           newNode.setNeste(foerste);
           foerste = newNode;
       } else if (newNode.getElement().compareTo(siste.getElement()) > 0) {
           siste.setNeste(newNode);
           siste = newNode;
       } else {
           LinearNode<T> gjeldene = foerste;
           while(gjeldene.getNeste() != null){
               if (gjeldene.getNeste().getElement().compareTo(newNode.getElement()) <= 0){
                   newNode.setNeste(gjeldene.getNeste());
                   gjeldene.setNeste(newNode);
               }
              gjeldene = gjeldene.getNeste();
           }
       }
       antall++;
    }
    public KjedetOrdnetListe<T> leggTilListe(KjedetOrdnetListe<T> denAndre) {
//d)- Er oppgitt
    }
    //hjelpemetode som legget et nytt el bak i listen

    public KjedetOrdnetListe<T> fletteTilListe(KjedetOrdnetListe<T> denAndre) {
        KjedetOrdnetListe OrdnetListe = new KjedetOrdnetListe<T>();
        LinearNode<T> denneFoerste,andreFoerste;
        denneFoerste = foerste;
        andreFoerste = denAndre.foerste;
        T el = null;

        while (denneFoerste != null && andreFoerste != null){
            if (denneFoerste.getElement().compareTo(andreFoerste.getElement()) < 0){
                el = denneFoerste.getElement();
                denneFoerste = denneFoerste.getNeste();
            } else {
                el = andreFoerste.getElement();
                andreFoerste = andreFoerste.getNeste();
            }
            OrdnetListe.leggTilBak(el);
        }

        while (denneFoerste !=null){
            el = denneFoerste.getElement();
            denneFoerste = denneFoerste.getNeste();
            OrdnetListe.leggTilBak(el);
        }

        while (andreFoerste !=null){
            el = andreFoerste.getElement();
            andreFoerste = andreFoerste.getNeste();
            OrdnetListe.leggTilBak(el);
        }
        return OrdnetListe;

    }

    public void leggTilBak(T el){
        LinearNode<T> nyNode = new LinearNode<>(el);
        if (antall == 0){
            foerste = nyNode;
            siste = nyNode;
        } else{
            siste.setNeste(nyNode);
            siste= nyNode;
        }
        antall++;
    }
}

public class KjedetOrdnetListe<T  extends Comparable<T>> implements
        OrdnetListeADT<T>  {
    private int antall;
    public LinearNode<T> foerste;
    private LinearNode<T> siste;

    // kan anta du har get- & set-metoder, antall() og erTom() om du trenger
    public KjedetOrdnetListe() {
        foerste = null;
        siste = null;
        antall = 0;
    }
    public T fjernFoerste() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");

        T slettetfoerste = foerste.getElement();

        LinearNode<T> nyFoerste = foerste.getNeste();
        foerste.setElement(null);
        foerste = nyFoerste;
        antall--;
        if (antall == 0) {
            siste = null;
        }

        return slettetfoerste;
    }

    public T fjernFoersteOving() {
        if (erTom())
            throw new EmptyCollectionException("ordnet liste");
        //b) … Fyll ut
        T temp = foerste.getElement();

        if (foerste == siste){
            foerste = null;
            siste = null;
        } else {
            LinearNode<T> nyfoerste = foerste.getNeste();
            foerste.setElement(null);
            foerste = nyfoerste;
        }

        antall--;
        return temp;

    }






    public void leggTil(T element) {
        LinearNode<T> nyNode = new LinearNode<>(element);

        if (antall == 0){
            foerste = nyNode;
            siste = nyNode;
        } else if (element.compareTo(foerste.getElement()) <= 0){
            nyNode.setNeste(foerste);
            foerste = nyNode;
        } else if (element.compareTo(siste.getElement()) >= 0){
            nyNode.setNeste( siste);
            siste = nyNode;
        } else {
            LinearNode <T> gjeldene = foerste;
            while(gjeldene.getNeste() != null && element.compareTo(gjeldene.getNeste()) >0){
                gjeldene = gjeldene.getNeste();
            }
            nyNode.setNeste(gjeldene.getNeste());
            gjeldene.setNeste(nyNode);
        }
        antall++;

    }

    public void leggTilOving(T element) {
        LinearNode nyNode = new LinearNode<>(element);
        if (antall == 0){
            foerste = nyNode;
            siste = nyNode;
        } else if (element.compareTo(foerste.getElement()) <= 0){//betyr at verdien er mindre, = negativt tall
            nyNode.setNeste(foerste);
            foerste = nyNode;
            antall++;
        } else if (element.compareTo(siste.getElement()) >= 0) {
            siste.setNeste(nyNode);
            siste = nyNode;
        } else {
            LinearNode<T> gjeldene = foerste;

            while (gjeldene.getNeste() == null && element.compareTo(gjeldene.getNeste().getElement()) <= 0){
                gjeldene = gjeldene.getNeste();

                }
                nyNode.setNeste(gjeldene.getNeste());
                gjeldene.setNeste(nyNode);
            }
        antall++;
        }



    public KjedetOrdnetListe<T> leggTilListe(KjedetOrdnetListe<T> denAndre) {
//d)- Er oppgitt
    }
    public KjedetOrdnetListe<T> fletteTilListe(KjedetOrdnetListe<T> denAndre) {
    KjedetOrdnetListe<T> nyListe = new KjedetOrdnetListe<T>();
    LinearNode<T> p,q;
    p = foerste;
    q = denAndre.foerste;
    T el = null;

    while (p != null && q != null){
        if (p.getElement().compareTo(q.getElement()) < 0){
            el = p.getElement();
            p = p.getNeste();
        } else {
            el = q.getElement();
            q = q.getNeste();
        }
        nyListe.leggTilBak(el);

    }

    while (p != null){
        el = p.getElement();
        p = p.getNeste();
        nyListe.leggTilBak(el);

    }

    while (q != null){
        el = q.getElement();
        q = q.getNeste();
        nyListe.leggTilBak(el);
    }

    return nyListe;
    }
    //hjelpemetode
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


    public statoc <T extends Comparable<T>> int binaerSok(T[] data, int min,int maks,T el){
        if(min>maks) {
            return -1;
        }
        int midtpunkt = (min + maks)/2;
        int resultat =el.compareTo(data[midtpunkt]);
        if (resultat ==0){
            return midtpunkt;
        }
        if(resultat <0){
            return binaerSok(data, min, midtpunkt-1, el);
        }else {
            return binaerSok(data, midtpunkt+1, maks, el);
        }
    }
}

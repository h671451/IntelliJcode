public class BinaerTre<T extends Comparable<T>> {
    private BinaerTreNode<T> rot;
    private int antall;
    public BinaerTre() {
        rot = null;
        antall = 0;
    }
    public BinaerTre(T element) {
        rot = new BinaerTreNode<T>(element);
        antall = 1;
    }
    public BinaerTreNode<T> getRot() {
        return rot;
    }
    //… andre … get- og set metoder kan du anta
}
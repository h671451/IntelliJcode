package Oppgave5;

public class Oppgave5c {
    public static void main(String[] args) {
        int numNodes = 8191;
        int numTrees = 100;
        int totalHeight = 0;

        for (int i = 0; i < numTrees; i++) {
            BinarySearchTree<Integer> tree = new BinarySearchTree<>();
            for (int j = 0; j < numNodes; j++) {
                tree.addTo((int) (Math.random() * Integer.MAX_VALUE));
            }
            totalHeight += tree.height();
        }

        double averageHeight = (double) totalHeight / numTrees;
        System.out.println("Average height for n = " + numNodes + ": " + averageHeight);
    }
}

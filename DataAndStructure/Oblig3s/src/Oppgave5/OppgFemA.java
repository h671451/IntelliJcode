package Oppgave5;

public class OppgFemA {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.addTo(5);
        tree.addTo(3);
        tree.addTo(7);
        tree.addTo(2);
        tree.addTo(4);
        tree.addTo(6);
        tree.addTo(8);

        int height = tree.height(tree.root);
        System.out.println("Height of tree: " + height);


    }
}

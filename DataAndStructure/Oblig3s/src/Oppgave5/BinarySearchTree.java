package Oppgave5;

public class BinarySearchTree<T extends Comparable<T>> {
     Node root;


    class Node{
        private T value;
        Node left;
        Node right;

        public Node (T value){
            this.value=value;
        }
    }

    public int height() {
        return height(root);
    }

    public int height(Node root) {
        if (root == null) {
            return -1;
        } else {
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public void addTo(T value) {
        root = addTo(root, value);
    }


    private Node addTo(Node node, T value) {
        if (node == null) { // hvis noden er null,
            // så vil det si at det er ingen noder i binær treet og da vil vi lage en ny node som vil da være roten til binær treet
            return new Node(value);
        } else if (value.compareTo(node.value) < 0) {//hvis compareTo returner negativt vil noden bli plasert til venstre siden, dette vil skjer rekursivt helt til den finner en tom plass
         node.left = addTo(node.left, value);
        } else if (value.compareTo(node.value) > 0) {//hvis compareTo returner postivt vil noden bli plasert til hoyre siden,dette vil skjer rekursivt helt til den finner en tom plass
            node.right = addTo(node.right, value);
        } else {
            // key already exists, do nothing
        }
        return node;
    }
}

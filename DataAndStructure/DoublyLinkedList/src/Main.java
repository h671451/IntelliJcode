public class Main {

    public static void main(String[] args) {

        DoublyLinkedList myDLL = new DoublyLinkedList(3);
        myDLL.append(4);
        myDLL.append(5);
        myDLL.append(6);


        System.out.println(myDLL.get(3).value + "\n");

        myDLL.printList();


        /*
            EXPECTED OUTPUT:
            ----------------
            3

        */

    }

}
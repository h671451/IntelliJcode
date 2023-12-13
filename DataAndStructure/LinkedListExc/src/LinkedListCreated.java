public class LinkedListCreated {
    private Node head;
    private Node tail;
    private int length;
    class Node {
        int value;
        LinkedListCreated.Node next;

        Node(int value) {
            this.value = value;
        }
    }
    public LinkedListCreated ( int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend (int value){
        Node newNode = new Node(value);
        if (length == 0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeLast (){

        if (length == 0) return null;

            Node temp = head;
            Node prev = head;
            while (temp.next != null){
                prev = temp;
                temp = temp.next;
            }
        tail = prev;
        tail.next = null;
        length--;

        if (length == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node removeFirst (){
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0){
            head = null;
            tail = null;
        }

        return  temp;
    }

    public boolean insert(int index, int value){
        if (index < 0 || index > length){
            return false;
        }
        if (index == 0){
            prepend(value);
        }
    }


}

package dataStructure.linkedList;

public class Node {

    private Object data;
    private Node next;

    public Node(Object data) {
        this.data = data;
    }

    public void add(Object data){
        Node tail = this;
        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = new Node(data);
    }

    public void print(){
        Node head = this;
        while (head.next != null){
            System.out.println("data = " + head.data);
            head = head.next;
        }
        System.out.println("data = " + head.data);
    }

}

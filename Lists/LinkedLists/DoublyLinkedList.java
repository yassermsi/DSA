package LinkedLists;

public class DoublyLinkedList {
       static class Node {
              int data;
              Node prev;
              Node next;

              Node(int data) {
                     this.data = data;
                     this.prev = null;
                     this.next = null;
              }
       }

       public static void main(String[] args) {
              Node node1 = new Node(3);
              Node node2 = new Node(5);
              Node node3 = new Node(13);
              Node node4 = new Node(2);

              node1.next = node2;

              node2.prev = node1;
              node2.next = node3;

              node3.prev = node2;
              node3.next = node4;

              node4.prev = node3;

              Node current = node1;
              System.out.print("Forward: ");
              while (current != null) {
                     System.out.print(current.data + " -> ");
                     current = current.next;
              }
              System.out.println("null");

              current = node4;
              System.out.print("Backward: ");
              while (current != null) {
                     System.out.print(current.data + " -> ");
                     current = current.prev;
              }
              System.out.println("null");
       }
}

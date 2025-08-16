package LinkedLists;

public class Operations {
       static class Node {
              int data;
              Node next;

              Node(int data) {
                     this.data = data;
                     this.next = null;
              }
       }

       public static Node insertNode(Node head, Node toInsert, int pos) {
              if (pos == 1) {
                     toInsert.next = head;
                     return toInsert;
              }
              Node current = head;
              for (int i = 1; i < pos - 1 && current != null; i++)
                     current = current.next;
              if (current != null) {
                     toInsert.next = current.next;
                     current.next = toInsert;
              }
              return head;
       }

       public static Node deleteNode(Node head, Node toDelete) {
              if (head == toDelete) 
                     return head.next;
              Node current = head;
              while (current.next != null && current.next != toDelete)
                     current = current.next;
              if (current.next == toDelete)
                     current.next = toDelete.next;
              return head;
       }

       public static int findSmallestValue(Node head) {
              int min = head.data;
              Node current = head.next;
              while (current != null) {
                     if (current.data < min)
                            min = current.data;
                     current = current.next;
              }
              return min;
       }

       public static void traverse(Node head) {
              Node current = head;
              while (current != null) {
                     System.out.print(current.data + " -> ");
                     current = current.next;
              }
              System.out.println("null");
       }

       public static void main(String[] args) {
              Node node1 = new Node(7);
              Node node2 = new Node(11);
              Node node3 = new Node(3);
              Node node4 = new Node(2);
              Node node5 = new Node(9);

              node1.next = node2;
              node2.next = node3;
              node3.next = node4;
              node4.next = node5;

              traverse(node1);
              System.out.println("The smallest value in the linked list is: " + findSmallestValue(node1));
              node1 = deleteNode(node1, node4);
              traverse(node1);
              node1 = insertNode(node1, node4, 4);
              traverse(node1);
       }
}

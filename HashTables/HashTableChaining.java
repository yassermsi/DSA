public class HashTableChaining<E extends Integer> {
       private static final int INIL_CAP = 10;
       private Node<E> theData[];
       private int capacity;

       public HashTableChaining() {
              capacity = INIL_CAP;
              theData = new Node[capacity];
       }

       public HashTableChaining(int cap) {
              capacity = (cap <= 0) ? INIL_CAP : cap;
              theData = new Node[capacity];
       }

       private static class Node<E> {
              private E data;
              private Node<E> next;

              public Node(E item) {
                     data = item;
                     next = null;
              }
       }

       public int capacity() {
              return capacity;
       }

       public void insertKey(E key) {
              int loc = (Integer) key % capacity;
              Node<E> node = new Node<>(key);
              if (theData[loc] == null)
                     theData[loc] = node;
              else {
                     node.next = theData[loc];
                     theData[loc] = node;
              }
       }

       public int search(E key) {
              int loc = (Integer) key % capacity;
              Node<E> node = theData[loc];
              while (node != null)
                     if (node.data.equals(key))
                            return loc;
                     else 
                            node = node.next;
              return -1;
       }

       public String toString(int i) {
              if (i < 0 || i >= capacity)
                     return null;
              Node<E> temp = theData[i];
              String str = "";
              while (temp != null) {
                     str += temp.data + " ";
                     temp = temp.next;
              }
              return str;
       }

       public boolean removeChaining(E item) {
              int loc = (Integer) item % capacity;
              Node<E> node = theData[loc];
              if (node == null)
                     return false;
              if (node.data.equals(item)) {
                     theData[loc] = node.next;
                     return true;
              }
              Node<E> prev = node;
              node = node.next;
              while (node != null) 
                     if (node.data.equals(item)) {
                            prev.next = node.next;
                            node = null;
                            return true;
                     } else {
                            prev = node;
                            node = node.next;
                     }
              return false;
       }
}

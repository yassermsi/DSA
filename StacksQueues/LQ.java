import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedQueue<E> {
       private Node<E> front;
       private Node<E> rear;
       int size;

       private static class Node<E> {
              private E data;
              private Node<E> next;

              public Node(E dataItem) {
                     data = dataItem;
                     next = null;
              }

              public Node(E dataItem, Node<E> nodeRef) {
                     data = dataItem;
                     next = nodeRef;
              }
       }

       public LinkedQueue() {
              front = null;
              rear = null;
              size = 0;
       }

       public boolean offer(E item) {
              if (front == null) {
                     rear = new Node<>(item);
                     front = rear;
              } else {
                     rear.next = new Node<>(item, rear.next);
                     rear = rear.next;
              }
              size++;
              return true;
       }

       public E poll() {
              if (front == null)
                     return null;
              else {
                     E removed = front.data;
                     front = front.next;
                     size--;
                     return removed;
              }
       }

       public E peek() {
              if (front == null)
                     return null;
              else
                     return front.data;
       }

       public boolean isEmpty() {
              return front == null;
       }

       public int size() {
              return size;
       }

       public Iterator<E> iterator() {
              return new Iter();
       }

       private class Iter implements Iterator<E> {
              private Node<E> nextItem;

              public Iter() {
                     nextItem = front;
              }

              public boolean hasNext() {
                     return nextItem != null;
              }

              public E next() {
                     if (!hasNext())
                            throw new NoSuchElementException();
                     E item = nextItem.data;
                     nextItem = nextItem.next;
                     return item;
              }

              public void remove() {
                     throw new UnsupportedOperationException();
              }
       }
}

public class LQ {

}

import java.util.*;

public class LS<E> implements StackInt<E> {
       Node<E> topOfStack;

       private static class Node<E> {
              private E data;
              private Node<E> next;

              private Node(E data) {
                     this.data = data;
                     next = null;
              }

              private Node(E data, Node<E> refNode) {
                     this.data = data;
                     next = refNode;
              }
       }

       public LS() {
              topOfStack = null;
       }

       public LS(LS<E> other) {
              if (other.isEmpty())
                     topOfStack = null;
              else {
                     Node<E> ptr = new Node<>(other.topOfStack.data);
                     topOfStack = ptr;
                     Node<E> ptr1 = other.topOfStack.next;
                     Node<E> ptr2 = topOfStack;
                     while (ptr1 != null) {
                            ptr = new Node<>(ptr1.data);
                            ptr2 = ptr;
                            ptr1 = ptr1.next;
                            ptr2 = ptr2.next;
                     }
              }
       }

       @Override
       public E push(E obj) {
              topOfStack = new Node<>(obj, topOfStack);
              return obj;
       }

       @Override
       public E pop() {
              if (isEmpty())
                     throw new NoSuchElementException();
              E removed = topOfStack.data;
              topOfStack.data = null;
              topOfStack = topOfStack.next;
              return removed;
       }

       @Override
       public E peek() {
              if (isEmpty())
                     throw new NoSuchElementException();
              return topOfStack.data;
       }

       @Override
       public boolean isEmpty() {
              return topOfStack == null;
       }
}

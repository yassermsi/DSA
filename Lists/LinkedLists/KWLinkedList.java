package LinkedLists;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class KWLinkedList<E> {
       private Node<E> head;
       private Node<E> tail;
       int size;

       public KWLinkedList() {
              head = null;
              tail = null;
              size = 0;
       }

       private static class Node<E> {
              private E data;
              private Node<E> next;
              private Node<E> prev;

              private Node(E data) {
                     this.data = data;
                     next = null;
                     prev = null;
              }
       }

       public void addFirst(E item) {
              Node<E> temp = new Node<>(item);
              if (head == null) {
                     head = temp;
                     tail = temp;
              } else {
                     temp.next = head;
                     head.prev = temp;
                     head = temp;
              }
              size++;
       }

       public void addLast(E item) {
              Node<E> temp = new Node<>(item);
              if (tail != null) {
                     temp.prev = tail;
                     tail.next = temp;
                     tail = temp;
              } else {
                     head = temp;
                     tail = temp;
              }
              size++;
       }

       public boolean add(E item) {
              addLast(item);
              return true;
              /*
               * Node<E> temp = new Node<>(item);
               * if (tail == null) {
               * head = temp;
               * tail = temp;
               * } else {
               * temp.prev = tail;
               * tail.next = temp;
               * tail = temp;
               * }
               * size++;
               */
       }

       public E getFirst() {
              if (head == null)
                     throw new NoSuchElementException();
              return head.data;
       }

       public E getLast() {
              if (tail == null)
                     throw new NoSuchElementException();
              return tail.data;
       }

       public int size() {
              return size;
       }

       private class KWListIter implements ListIterator<E> {
              private Node<E> nextItem;
              private Node<E> lastItemReturned;
              private int index;

              private KWListIter() {
                     nextItem = head;
                     lastItemReturned = null;
                     index = 0;
              }

              private KWListIter(int index) {
                     if (index < 0 || index > size)
                            throw new IndexOutOfBoundsException();
                     nextItem = head;
                     for (int i = 0; i < index; i++)
                            nextItem = nextItem.next;
                     this.index = index;
                     lastItemReturned = null;
              }

              private KWListIter(KWListIter iter) {
                     if (iter.nextIndex() < 0 || iter.nextIndex() > size)
                            throw new IndexOutOfBoundsException();
                     nextItem = head;
                     for (int i = 0; i < iter.nextIndex(); i++)
                            nextItem = nextItem.next;
                     this.index = iter.nextIndex();
                     lastItemReturned = null;
              }

              @Override
              public boolean hasNext() {
                     return nextItem != null;
              }

              @Override
              public E next() {
                     if (!hasNext())
                            throw new NoSuchElementException();
                     lastItemReturned = nextItem;
                     nextItem = nextItem.next;
                     index++;
                     return lastItemReturned.data;
              }

              @Override
              public void remove() {
                     if (lastItemReturned == null)
                            throw new IllegalStateException();
                     Node<E> temp = lastItemReturned;
                     if (temp == head && temp == tail) {
                            head = null;
                            tail = null;
                     } else if (temp == head) {
                            head = head.next;
                            head.prev = null;
                     } else if (temp == tail) {
                            tail = tail.prev;
                            tail.next = null;
                     } else {
                            temp.prev.next = temp.next;
                            temp.next.prev = temp.prev;
                     }
                     if (temp == nextItem)
                            nextItem = temp.next;
                     else
                            index--;
                     size--;
                     lastItemReturned = null;
              }

              @Override
              public boolean hasPrevious() {
                     return (nextItem == null && tail != null) || (nextItem != null && nextItem.prev != null);
              }

              @Override
              public E previous() {
                     if (!hasPrevious())
                            throw new NoSuchElementException();
                     if (nextItem == null)
                            nextItem = tail;
                     else
                            nextItem = nextItem.prev;
                     lastItemReturned = nextItem;
                     index--;
                     return lastItemReturned.data;
              }

              @Override
              public int previousIndex() {
                     return index - 1;
              }

              @Override
              public int nextIndex() {
                     return index;
              }

              @Override
              public void add(E obj) {
                     Node<E> temp = new Node<>(obj);
                     if (head == null) {
                            head = temp;
                            tail = temp;
                     } else if (nextItem == head) {
                            temp.next = head;
                            head.prev = temp;
                            head = temp;
                     } else if (nextItem == null) {
                            temp.prev = tail;
                            tail.next = temp;
                            tail = temp;
                     } else {
                            temp.prev = nextItem.prev;
                            nextItem.prev.next = temp;
                            temp.next = nextItem;
                            nextItem.prev = temp;
                     }
                     size++;
                     index++;
                     lastItemReturned = null;
              }

              @Override
              public void set(E obj) {
                     if (lastItemReturned == null)
                            throw new IllegalStateException();
                     lastItemReturned.data = obj;
              }
       }

       public ListIterator<E> listIterator() {
              KWListIter iter = new KWListIter();
              return iter;
       }

       public ListIterator<E> listIterator(int index) {
              KWListIter iter = new KWListIter(index);
              return iter;
       }

       public ListIterator<E> listIterator(ListIterator<E> iter) {
              KWListIter iterator = new KWListIter((KWListIter) iter);
              return iterator;
       }

       public void add(int index, E obj) {
              listIterator(index).add(obj);
       }

       public E get(int index) {
              return listIterator(index).next();
       }

       public int indexOf(E target) {
              Node<E> cur = head;
              int index = 0;
              while (cur != null) {
                     if ((cur.data).equals(target))
                            return index;
                     else {
                            index++;
                            cur = cur.next;
                     }
              }
              return -1;
              /*
               * for (int i = 0; i < size && cur != null; i++) {
               * if (cur.data.equals(target))
               * return i;
               * cur = cur.next;
               * }
               */
       }

       public E remove(int index) {
              if (index < 0 || index >= size)
                     throw new IndexOutOfBoundsException(index);
              Node<E> cur = head;
              for (int i = 0; i < index && cur != null; i++)
                     cur = cur.next;
              E removed = cur.data;
              if (cur.equals(head) && cur.equals(tail)) {
                     head = null;
                     tail = null;
              } else if (cur.equals(head)) {
                     head.data = null;
                     head = head.next;
              } else if (cur.equals(tail)) {
                     tail.data = null;
                     tail = tail.prev;
              } else {
                     cur.prev.next = cur.next;
                     cur.next.prev = cur.prev;
              }
              size--;
              return removed;
       }

       public boolean remove(E item) {
              int index = indexOf(item);
              if (index == -1)
                     return false;
              else {
                     remove(index);
                     return true;
              }
       }

       public E set(int index, E anEntry) {
              if (index < 0 || index >= size)
                     throw new IndexOutOfBoundsException(index);
              Node<E> cur = head;
              for (int i = 0; i < index && cur != null; i++)
                     cur = cur.next;
              E old = cur.data;
              cur.data = anEntry;
              return old;
       }

       public void reverseNodes() {
              if (size <= 1)
                     System.out.println("List is empty or has one node");
              else {
                     E item1, item2;
                     KWListIter iter1 = new KWListIter();
                     KWListIter iter2 = new KWListIter(size);
                     for (int i = 0; i < size / 2; i++) {
                            item1 = iter1.next();
                            item2 = iter2.previous();
                            iter1.set(item2);
                            iter2.set(item1);
                     }
                     /*
                      * E item1, item2;
                      * Node<E> forward = head;
                      * Node<E> backward = tail;
                      * for (int i = 0; i < size / 2; i++) {
                      * item1 = forward.data;
                      * item2 = backward.data;
                      * forward.data = item2;
                      * backward.data = item1;
                      * forward = forward.next;
                      * backward = backward.prev;
                      * }
                      */
              }
       }

       public boolean addWithCondition(E item1, E item2) {
              if (head == null)
                     return false;
              KWListIter iter = new KWListIter();
              while (iter.hasNext())
                     if (iter.next().equals(item1)) {
                            iter.previous();
                            iter.add(item2);
                            return true;
                     }
              return false;
              /*
               * Node<E> cur = head;
               * while (cur != null) {
               * if (cur.data.equals(item)) {
               * Node<E> temp = new Node(item1);
               * temp.prev = cur.prev;
               * cur.prev.next = temp;
               * temp.next = cur;
               * cur.prev = temp;
               * }
               * }
               */
       }

       public boolean findAll(E item, KWLinkedList<E> list2) {
              if (head == null)
                     return false;
              KWListIter iter = new KWListIter();
              while (iter.hasNext()) {
                     E item1 = iter.next();
                     if (((Comparable) item1).compareTo((Comparable) item) < 0)
                            list2.add(item1);
              }
              if (list2.size == 0)
                     return false;
              else
                     return true;
              /*
               * Node<E> cur = head;
               * while (cur != null) {
               * if (((Comparable) cur.data).compareTo((Comparable) item)) {
               * Node<E> temp = new Node<>();
               * if (list2.head == null) {
               * head = temp;
               * tail = temp;
               * } esle {
               * temp.prev = list2.tail;
               * list2.tail.next = temp;
               * list2.tail = temp;
               * }
               * list2.size++
               * }
               * cur = cur.next;
               * }
               */
       }

       public int lastIndexOf(E item) {
              KWListIter iter = new KWListIter(size);
              int index = iter.previousIndex();
              while (iter.hasPrevious())
                     if (iter.previous().equals(item))
                            return index;
                     else
                            index--;
              return -1;
              /*
               * Node<E> cur = tail;
               * for (int i = size - 1; i >= 0 && cur != null; i--) {
               * if (cur.data.equals(item))
               * return i;
               * cur = cur.prev;
               * }
               */
       }

       public boolean checkForEquality() {
              if (head == null)
                     return false;
              KWListIter iter1 = new KWListIter();
              KWListIter iter2 = new KWListIter(size);
              while (iter1.nextIndex() < size / 2)
                     if (!iter1.next().equals(iter2.previous()))
                            return false;
              return true;
              /*
               * Node<E> forward = head;
               * Node<E> backward = tail;
               * for (int i = 0; i < size / 2; i++) {
               * if (!forward.data.equals(backward.data))
               * return false;
               * forward = forward.next;
               * backward = backward.prev;
               * }
               */
       }

       public boolean removeTheCorrespondingIndex(KWLinkedList<Character> list) {
              if (list.head == null)
                     return false;
              ListIterator<Character> iter1 = list.listIterator();
              ListIterator<E> iter2 = this.listIterator();
              while (iter1.hasNext())
                     if (iter1.next().equals('x')) {
                            iter2.remove();
                            return true;
                     } else {
                            iter2.next();
                     }
              return false;
       }

       public void insertFirstLast(E elem) {
              Node<E> temp = new Node(elem);
              if (((Comparable) elem).compareTo((Comparable) head.data) > 0 &&
                            ((Comparable) elem).compareTo(tail.data) < 0) {
                     temp.next = head;
                     head.prev = temp;
                     head = temp;
              } else {
                     temp.prev = tail;
                     tail.next = temp;
                     tail = temp;
              }
              size++;
              /*
               * if (((Comparable) head.data).compareTo((Comparable) elem) < 0 &&
               * ((Comparable) tail.data).compareTo(elem) > 0)
               * addFirst(elem);
               * else
               * addLast(elem);
               */
       }
}

class Application<E> {
       public void insertInMiddle(KWLinkedList<E> l, E value) {
              ListIterator<E> iter = l.listIterator();
              for (int i = 0; i < l.size(); i++)
                     iter.next();
              iter.add(value);
       }
}


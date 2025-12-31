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
                     tail = tail.prev;
                     tail.next = null;
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
                     ListIterator<E> iter1 = listIterator();
                     ListIterator<E> iter2 = listIterator(size);
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
              ListIterator<E> iter = listIterator();
              if (!iter.hasNext())
                     return false;
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
              ListIterator<E> iter1 = listIterator();
              ListIterator<E> iter2 = list2.listIterator();
              while (iter1.hasNext()) {
                     E item1 = iter1.next();
                     if (((Comparable) item1).compareTo((Comparable) item) < 0)
                            iter2.add(item1);
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
              ListIterator<E> iter = listIterator(size);
              int index = iter.previousIndex();
              while (iter.hasPrevious()) {
                     E item1 = iter.previous();
                     if (item1.equals(item))
                            return index;
                     else
                            index--;
              }
              return -1;
              /*
               * Node<E> cur = tail;
               * for (int i = size - 1; i >= 0 && cur != null; i--) {
               * if (cur.data.equals(item))
               * return i;
               * cur = cur.prev;
               * }
               */
              /*
               * Node<E> cur = tail;
               * while (cur != null) {
               * if (cur.data.equals(item))
               * return index;
               * else {
               * index--;
               * cur = cur.prev;
               * }
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

       public void deleteInsert(E item) {
              Node<E> cur = head;
              for (int i = 0; i < size / 2 - 1; i++)
                     cur = cur.next;
              cur.prev.next = cur.next;
              cur.next.prev = cur.prev;
              /*
               * Node<E> fast = head;
               * Node<E> slow = fast;
               * while (fast != null && fast.next != null) {
               * slow = slow.next;
               * fast = fast.next.next;
               * }
               * slow.next.prev = slow.prev;
               * slow.prev.next = slow.next;
               */
              Node<E> node = new Node<>(item);
              node.prev = tail;
              tail.next = node;
              tail = node;
       }

       public void InsertFirstLast(E item) {
              Node<E> node = new Node<>(item);
              if (head == null && tail == null) {
                     head = node;
                     tail = node;
                     size++;
              } else {
                     Node<E> newNode = node;
                     node.next = head;
                     head.prev = node;
                     head = node;
                     newNode.prev = tail;
                     tail.next = newNode;
                     tail = newNode;
                     size += 2;
              }
       }

       public boolean replace(E searchItem, E repItem) {
              ListIterator<E> iter = listIterator();
              while (iter.hasNext()) {
                     E item = iter.next();
                     if (item.equals(searchItem)) {
                            iter.set(repItem);
                            return true;
                     }
              }
              return false;
       }
}

class Application<E> {
       public void insertInMiddle(KWLinkedList<E> l, E value) {
              ListIterator<E> iter = l.listIterator();
              for (int i = 0; i < l.size() / 2; i++)
                     iter.next();
              iter.add(value);
       }

       public static void setMinByAverage(KWLinkedList<Double> list) {
              ListIterator<Double> iter = list.listIterator();
              if (!iter.hasNext())
                     return;
              double sum = 0;
              int count = 0;
              while (iter.hasNext()) {
                     sum += iter.next();
                     count++;
              }
              double avg = sum / count;
              iter = list.listIterator();
              double min = iter.next();
              while (iter.hasNext()) {
                     double d = iter.next();
                     if (min > d)
                            min = d;
              }
              iter = list.listIterator();
              while (iter.hasNext())
                     if (iter.next().equals(min))
                            iter.set(avg);
       }

       public static <E> void display2Directions(KWLinkedList<E> list, int n) {
              ListIterator<E> iter = list.listIterator();
              int size = 0;
              while (iter.hasNext())
                     size++;
              if (n < 0 || n >= size) {
                     System.out.println("Invalid Index");
                     return;
              }
              iter = list.listIterator(n);
              iter.next();
              int right = 0;
              int left = 0;
              while (iter.hasNext())
                     right++;
              iter = list.listIterator(n);
              while (iter.hasPrevious())
                     left++;
              int min = (left > right) ? left : right;
              int count = 0;
              iter = list.listIterator(n);
              for (int i = 0; i < min; i++) {
                     iter = list.listIterator(n);
                     for (int j = 0; j < count; j++)
                            iter.next();
                     System.out.print(iter.next() + " ");
                     iter = list.listIterator(n);
                     for (int k = 0; k < count; k++)
                            iter.previous();
                     System.out.print(iter.previous() + " ");
              }
              System.out.println();
       }
}

class DoublyLinkedListEx {
       public static void insertGreaterElements(KWLinkedList<Integer> l1, KWLinkedList<Integer> l2,
                     KWLinkedList<Integer> l3) {
              ListIterator<Integer> iter1 = l1.listIterator();
              ListIterator<Integer> iter2 = l2.listIterator();
              ListIterator<Integer> iter3 = l3.listIterator();
              while (iter1.hasNext()) {
                     int a = iter1.next();
                     int b = iter2.next();
                     if (a > b)
                            iter3.add(a);
                     else if (a < b)
                            iter3.add(b);
              }
       }
}

package LinkedLists;

class SingleLinkedList<E> {
       private Node<E> head;
       private int size;

       public SingleLinkedList() {
              head = null;
              size = 0;
       }

       private static class Node<E> {
              private E data;
              private Node<E> next;

              private Node(E data) {
                     this.data = data;
                     next = null;
              }

              private Node(E data, Node<E> ref) {
                     this.data = data;
                     next = ref;
              }
       }

       private void addFirst(E item) {
              /*
               * Node<E> temp = new Node<>(item);
               * temp.next = head;
               * head = temp;
               */
              head = new Node<>(item, head);
              size++;
       }

       private void addAfter(Node<E> ref, E item) {
              /*
               * Node<E> temp = new Node<>(item);
               * temp.next = ref.next;
               * ref.next = temp;
               */
              Node<E> temp = new Node<>(item, ref.next);
              ref.next = temp;
              size++;
       }

       private E removeFirst() {
              if (head == null)
                     return null;
              else {
                     E removed = head.data;
                     head = head.next;
                     size--;
                     return removed;
              }
       }

       private E removeAfter(Node<E> ref) {
              if (ref.next != null) {
                     E removed = ref.next.data;
                     ref.next = ref.next.next;
                     size--;
                     return removed;
              } else
                     return null;
       }

       private Node<E> getNode(int index) {
              Node<E> cur = head;
              for (int i = 0; i < index && cur != null; i++)
                     cur = cur.next;
              return cur;
       }

       public int size() {
              return size;
       }

       public boolean isEmpty() {
              // return head == null;
              return size == 0;
       }

       public E get(int index) {
              if (index < 0 || index >= size)
                     throw new ArrayIndexOutOfBoundsException(index);
              return getNode(index).data;
       }

       public E set(int index, E item) {
              if (index < 0 || index >= size)
                     throw new ArrayIndexOutOfBoundsException(index);
              E old = getNode(index).data;
              getNode(index).data = item;
              return old;
       }

       public void add(int index, E item) {
              if (index < 0 || index > size)
                     throw new ArrayIndexOutOfBoundsException(index);
              if (index == 0)
                     addFirst(item);
              else
                     addAfter(getNode(index - 1), item);
       }

       public boolean add(E item) {
              add(size, item);
              return true;
       }

       public int indexOf(E item) {
              int index = 0;
              Node<E> cur = head;
              while (cur != null) {
                     /*
                      * if (item == null) {
                      * if (cur.data == null)
                      * return index;
                      * }
                      * else
                      */
                     if ((cur.data).equals(item))
                            return index;
                     index++;
                     cur = cur.next;
              }
              return -1;
              /*
               * for (int i = 0; i < size && cur != null; i++) {
               * if (item == null) {
               * if (cur.data == null)
               * return i;
               * }
               * else
               * if (cur.data.equals(item))
               * return i;
               * cur = cur.next;
               * }
               */
       }

       public E remove(int index) {
              if (index < 0 || index >= size)
                     throw new ArrayIndexOutOfBoundsException(index);
              if (index == 0)
                     return removeFirst();
              else
                     return removeAfter(getNode(index - 1));
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

       public boolean contains(E item) {
              return indexOf(item) != -1;
       }

       public void clear() {
              Node<E> cur = head;
              while (cur != null) {
                     cur.data = null;
                     cur = cur.next;
              }
              size = 0;
              /*
               * for (int i = 0; i < size && cur != null; i++) {
               * cur.data = null;
               * cur = cur.next;
               * }
               */
       }

       public String toString() {
              StringBuilder str = new StringBuilder();
              str.append("[");
              Node<E> cur = head;
              while (cur != null) {
                     str.append(cur.data);
                     if (cur.next != null)
                            str.append(", ");
                     cur = cur.next;
              }
              str.append("]");
              return str.toString();
       }

       public int replaceAll(E item, E rpItem) {
              if (size == 0)
                     return 0;
              int count = 0;
              Node<E> cur = head;
              while (cur != null) {
                     /*
                      * if (item == null) {
                      * if (cur.data == null) {
                      * cur.data = rpItem;
                      * count++;
                      * }
                      * }
                      * else
                      */
                     if ((cur.data).equals(item)) {
                            cur.data = rpItem;
                            count++;
                     }
                     cur = cur.next;
              }
              return count;
              /*
               * for (int i = 0; i < size && cur != null; i++) {
               * if (item == null) {
               * if (cur.data == null) {
               * cur.data = rpItem;
               * count++;
               * }
               * }
               * else
               * if (cur.data.equals(item)) {
               * cur.data = rpItem;
               * count++;
               * }
               * cur = cur.next;
               * }
               */
       }

       public boolean compareHalfs() {
              if (isEmpty() || size % 2 != 0)
                     return false;
              Node<E> first = head;
              Node<E> second = getNode(size / 2);
              while (second != null) {
                     /*
                      * if (first.data == null) {
                      * if (second.data != null)
                      * return false;
                      * } else if (second.data == null) {
                      * if (first.data != null)
                      * return false;
                      * }
                      * else
                      */
                     if ((first.data).equals(second.data)) {
                            first = first.next;
                            second = second.next;
                     } else
                            return false;
              }
              return true;
              /*
               * for (int i = 0; i < size / 2 && second != null; i++) {
               * if (first.data == null) {
               * if (second.data != null) return false;
               * } else if (second.data == null) {
               * if (first.data != null) return false;
               * }
               * if (!first.data.equals(second.data))
               * return false;
               * else {
               * second = second.next;
               * first = first.next;
               * }
               * }
               */
       }

       public boolean insertValue(E v1, E v2) {
              if (size == 0)
                     return false;
              Node<E> cur = head;
              while (cur != null) {
                     if ((cur.data).equals(v1)) {
                            Node<E> temp = new Node<>(v2, cur.next);
                            cur.next = temp;
                            size++;
                            return true;
                     }
                     cur = cur.next;
              }
              return false;
              /*
               * index = indexOf(v1);
               * if (isEmpty() || index == -1)
               * return false;
               * addAfter(getNode(index, v2);
               * return true;
               */
       }

       public boolean removeAll(E item) {
              if (isEmpty())
                     return false;
              boolean removed = false;
              Node<E> cur = head;
              while (cur != null) {
                     if ((cur.data).equals(item)) {
                            remove(item);
                            removed = true;
                     }
                     cur = cur.next;
              }
              return removed;
              /*
               * while (head != null && (head.data).equals(item)) {
               * head = head.next;
               * size--;
               * removed = true;
               * }
               * Node<E> cur = head;
               * while (cur != null) {
               * if (cur.next != null && (cur.next.data).equals(item)) {
               * cur.next = cur.next.next;
               * size--;
               * removed = true;
               * } else
               * cur = cur.next;
               * }
               */
              /*
               * Node<E> ptr1 = head;
               * Node<E> ptr2 = head.next;
               * while (ptr2 != null) {
               * if (ptr2.data.equals(item)) {
               * ptr1.next = ptr2.next;
               * size--;
               * }
               * else
               * ptr1 = ptr2;
               * ptr2 = ptr2.next;
               * }
               */
       }

       public boolean shiftRightRotate() {
              if (size == 0 || size == 1)
                     return false;
              Node<E> cur = head;
              while (cur.next.next != null)
                     cur = cur.next;
              Node<E> temp = cur.next;
              cur.next = null;
              temp.next = head;
              head = temp;
              return true;
              /*
               * if (isEmpty() || size == 1)
               * return false;
               * add(remove(size - 1));
               */
       }

       public void printAndReplaceLarger(E value, E rpItem) {
              Node<E> cur = head;
              while (cur != null) {
                     if (((Comparable) cur.data).compareTo((Comparable) value) > 0) {
                            System.out.print(cur.data + " ");
                            cur.data = rpItem;
                     }
                     cur = cur.next;
              }
       }

       public boolean compareList() {
              if (size < 2)
                     return false;
              E max = head.data;
              Node<E> cur = head.next;
              for (int i = 1; i < size / 2; i++) {
                     if (((Comparable) cur.data).compareTo((Comparable) max) > 0)
                            max = cur.data;
                     cur = cur.next;
              }
              E min = cur.data;
              cur = cur.next;
              for (int i = size / 2 + 1; i < size; i++) {
                     if (((Comparable) cur.data).compareTo((Comparable) min) < 0)
                            min = cur.data;
                     cur = cur.next;
              }
              return ((Comparable) min).compareTo((Comparable) max) > 0;
       }
}

public class SLL {
       public static void insertBeforeLast(int item, SingleLinkedList<Integer> SL) {
              if (SL.isEmpty())
                     SL.add(item);
              else
                     SL.add(SL.size() - 1, item);
       }

       public static void main(String[] args) {
              SingleLinkedList<String> List1 = new SingleLinkedList<>();
              List1.add("B");
              List1.add("C");
              List1.add(0, "A");
              List1.add(3, "D");
              List1.add("E");
              List1.add("F");
              System.out.println("The size of the list is: " + List1.size());
              System.out.println("The data of the list: \n" + List1);
              System.out.println("Element removed from the list: " + List1.remove(4));
              List1.set(0, "Ahmed");
              List1.set(4, "Eman");
              System.out.println(List1.get(2));
              System.out.println(List1.indexOf("B"));
              System.out.println(List1.contains("P"));
              System.out.println("The size of the list now is: " + List1.size());
              for (int i = 0; i < List1.size(); i++)
                     System.out.print(List1.get(i) + " ");
       }
}

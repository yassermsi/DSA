package ArrayLists;

import java.util.Arrays;

class KWArrayList<E> {
       private static final int INITIAL_CAPACITY = 10;
       private E[] theData;
       private int size;
       private int capacity;

       public KWArrayList() {
              capacity = INITIAL_CAPACITY;
              theData = (E[]) new Object[capacity];
              size = 0;
       }

       public KWArrayList(int cap) {
              if (cap <= 0)
                     capacity = INITIAL_CAPACITY;
              else
                     capacity = cap;
              theData = (E[]) new Object[capacity];
              size = 0;
       }

       public KWArrayList(KWArrayList<E> list) {
              this.capacity = list.capacity;
              this.size = list.size;
              for (int i = 0; i < size; i++)
                     this.theData[i] = list.theData[i];
       }

       public void reallocate() {
              /*
               * capacity *= 2;
               * E[] temp = System.arraycopy(theData, 0, temp, 0, capacity);
               * theData = temp
               */
              /*
               * capacity *= 2;
               * E[] temp = (E[]) new Object(capacity);
               * for (int i = 0; i < size; i++)
               * temp[i] = theData[i];
               * theData = temp;
               */
              capacity *= 2;
              theData = Arrays.copyOf(theData, capacity);
       }

       public boolean add(E anEntry) {
              if (size == capacity)
                     reallocate();
              theData[size++] = anEntry;
              return true;
       }

       public void add(int index, E anEntry) {
              if (index < 0 || index > size)
                     throw new ArrayIndexOutOfBoundsException(index);
              if (size == capacity)
                     reallocate();
              for (int i = size; i > index; i--)
                     theData[i] = theData[i - 1];
              theData[index] = anEntry;
              size++;
       }

       public E get(int index) {
              if (index < 0 || index >= size)
                     throw new ArrayIndexOutOfBoundsException(index);
              return theData[index];
       }

       public E set(int index, E newValue) {
              if (index < 0 || index >= size)
                     throw new ArrayIndexOutOfBoundsException(index);
              E v = theData[index];
              theData[index] = newValue;
              return v;
       }

       public int indexOf(E item) {
              for (int i = 0; i < size; i++)
                     if (theData[i].equals(item))
                            return i;
              return -1;
       }

       public boolean contains(E obj) {
              for (int i = 0; i < size; i++)
                     if (theData[i].equals(obj))
                            return true;
              return false;
       }

       public int size() {
              return size;
       }

       public boolean isEmpty() {
              return size == 0;
       }

       public void clear() {
              Arrays.fill(theData, 0, size, null);
              size = 0;
              /*
               * for (int i = 0; i < size; i++)
               * theData[i] = null;
               * size = 0;
               */
       }

       public E remove(int index) {
              if (index < 0 || index >= size)
                     throw new ArrayIndexOutOfBoundsException(index);
              E removed = theData[index];
              for (int i = index + 1; i < size; i++)
                     theData[i - 1] = theData[i];
              theData[size - 1] = null;
              size--;
              return removed;
       }

       public boolean remove(E obj) {
              int index = indexOf(obj);
              if (index == -1)
                     return false;
              else {
                     remove(index);
                     return true;
              }
       }

       public String toString() {
              StringBuilder str = new StringBuilder();
              str.append("[");
              for (int i = 0; i < size; i++) {
                     str.append(theData[i]);
                     if (i != size - 1)
                            str.append(", ");
              }
              str.append("]");
              return str.toString();
       }

       public int lastIndexOf(E obj) {
              int index = -1;
              for (int i = 0; i < size; i++)
                     if (theData[i].equals(obj))
                            index = i;
              return index;
              /*
               * for (int i = size - 1; i >= 0; i--)
               * if (theData[i].equals(obj))
               * return i;
               */
       }

       public boolean setAll(E value, E rpValue) {
              for (int i = 0; i < size; i++)
                     if (theData[i].equals(value))
                            theData[i] = rpValue;
              return true;
       }

       public boolean compareHalfs() {
              if (size() < 2)
                     return false;
              E max = theData[0];
              E min = theData[size / 2];
              int i;
              for (i = 1; i < size / 2; i++)
                     if (((Comparable) theData[i]).compareTo((Comparable) max) > 0)
                            max = theData[i];
              for (i = size / 2 + 1; i < size; i++)
                     if (((Comparable) theData[i]).compareTo((Comparable) min) < 0)
                            min = theData[i];
              return ((Comparable) min).compareTo((Comparable) max) > 0;
       }

       public void removeSmallest() {
              if (size == 0)
                     return;
              int minIndex = 0;
              for (int i = 1; i < size; i++)
                     if (((Comparable) theData[i]).compareTo((Comparable) theData[minIndex]) < 0)
                            minIndex = i;
              for (int i = minIndex + 1; i < size; i++)
                     theData[i - 1] = theData[i];
              theData[size - 1] = null;
              size--;
              /*
               * if (isEmpty())
               * return;
               * E min = theData[0];
               * for (int i = 1; i < size; i++)
               * if (theData[i].compareTo(min) < 0)
               * min = theData[i];
               * remove(min);
               */
       }

       public boolean removeAll(E obj) {
              boolean isFound = false;
              int index = 0;
              while (index < size) {
                     if (obj.equals(theData[index])) {
                            isFound = true;
                            for (int i = index + 1; i < size; i++)
                                   theData[i - 1] = theData[i];
                            theData[size - 1] = null;
                            size--;
                     }
              }
              return isFound;
              /*
               * for (int i = 0; i < size; i++)
               * if (theData[i].equals(obj))
               * remove(theData[i]);
               * return true;
               */
       }

       public boolean equals(KWArrayList<E> list) {
              if (this.size != list.size)
                     return false;
              for (int i = 0; i < size; i++)
                     if (!list.theData[i].equals(theData[i]))
                            return false;
              return true;
       }

       public boolean compareReverse(KWArrayList<E> Arr) {
              if (this.size == 0 || Arr.size == 0)
                     return false;
              for (int i = 0, j = this.size - 1; i < this.size && j >= 0; i++, j--)
                     if (!this.theData[i].equals(Arr.theData[j]))
                            return false;
              return true;
              /*
               * if (this.isEmpty() || Arr.isEmpty())
               * return false;
               * for (int i = 0, j = this.size - 1; i < this.size && j >= 0; i++, j--)
               * if (this.theData[i].compareTo(Arr.theData[j]) != 0)
               * return false;
               * return true;
               */
       }
}

class ListApplication {
       public boolean checkItem(KWArrayList<Integer> list1, int item) {
              int index = list1.indexOf(item);
              if (index == -1)
                     return false;
              int i;
              for (i = 0; i < index; i++)
                     if (list1.get(i) > item)
                            return false;
              for (i = index + 1; i < list1.size(); i++)
                     if (list1.get(i) < item)
                            return false;
              return true;
       }

       public boolean equalSets(KWArrayList<Integer> list1, KWArrayList<Integer> list2) {
              if (list1.isEmpty() && list2.isEmpty())
                     return true;
              if (list1.size() != list2.size())
                     return false;
              boolean isFound = false;
              for (int i = 0; i < list1.size(); i++) {
                     isFound = false;
                     for (int j = 0; j < list2.size(); j++)
                            if (list1.get(i).equals(list2.get(j)))
                                   isFound = true;
                     if (!isFound)
                            return false;
              }
              return true;
       }
}

class KWArryApp<E> {
       public int replaceFromSecond(KWArrayList<E> l1, E Item, E replaceItem) {
              if (l1.isEmpty())
                     return 0;
              int i;
              for (i = 0; i < l1.size(); i++)
                     if (l1.get(i).equals(Item))
                            break;
              int count = 0;
              for (int j = i + 1; j < l1.size(); j++)
                     if (l1.get(i).equals(Item)) {
                            l1.set(i, Item);
                            count++;
                     }
              return count;
              /*
               * if (l1.size() < 2)
               * return 0;
               * int index = l1.indexOf(Item);
               * if (index == -1)
               * return 0;
               * int count = 0;
               * for (int i = index + 1; i < l1.size(); i++)
               * if (l1.get(i).equals(Item)) {
               * l1.set(i, replaceItem);
               * count++;
               * }
               */
       }

       public boolean removeAll(E item, KWArrayList<E> l) {
              if (l.isEmpty())
                     return false;
              /*
               * if (l.indexOf(item) == -1)
               * return false;
               */
              boolean isFound = false;
              for (int i = 0; i < l.size(); i++)
                     if (l.get(i).equals(item)) {
                            l.remove(i);
                            isFound = true;
                            i--;
                     }
              return isFound;
       }
}

public class KWAL {
       public static <E> boolean removeDuplicate(KWArrayList<E> L, E obj) {
              int i;
              for (i = 0; i < L.size(); i++)
                     if (L.get(i).equals(obj))
                            break;
              for (int j = i + 1; j < L.size(); j++)
                     if (L.get(j).equals(obj))
                            L.remove(j);
              return true;
       }

       public static <E> boolean compareHalfs(KWArrayList<E> array) {
              if (array.size() < 2)
                     return false;
              E max = array.get(0);
              E min = array.get(array.size() / 2);
              for (int i = 1; i < array.size() / 2; i++)
                     if (((Comparable) array.get(i)).compareTo((Comparable) max) > 0)
                            max = array.get(i);
              for (int i = array.size() / 2 + 1; i < array.size(); i++)
                     if (((Comparable) array.get(i)).compareTo((Comparable) min) < 0)
                            min = array.get(i);
              return ((Comparable) min).compareTo((Comparable) max) > 0;
       }

       public static void main(String[] args) {
              KWArrayList<Integer> list = new KWArrayList<>();
              list.add(1);
              list.add(7);
              list.add(22);
              list.add(1, 100);
              for (int i = 0; i < list.size(); i++)
                     System.out.print(list.get(i) + " ");
              list.set(2, 50);
              list.remove(1);
              System.out.println();
              for (int i = 0; i < list.size(); i++)
                     System.out.print(list.get(i) + " ");
       }
}

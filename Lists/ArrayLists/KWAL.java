package ArrayLists;

import java.util.Arrays;

class KWArrayList<E extends Comparable<E>> implements Comparable<KWArrayList<E>> {
       private static final int INITIAL_CAPACITY = 10;
       private E[] data;
       private int size;
       private int capacity;

       public KWArrayList() {
              capacity = INITIAL_CAPACITY;
              data = (E[]) new Comparable[capacity];
              size = 0;
       }

       public KWArrayList(int cap) {
              if (cap <= 0)
                     capacity = INITIAL_CAPACITY;
              else
                     capacity = cap;
              data = (E[]) new Comparable[capacity];
              size = 0;
       }

       public void reallocate() {
              capacity *= 2;
              data = Arrays.copyOf(data, capacity);
       }

       public boolean add(E anEntry) {
              if (size == capacity)
                     reallocate();
              data[size++] = anEntry;
              return true;
       }

       public void add(int index, E anEntry) {
              if (index < 0 || index > size)
                     throw new ArrayIndexOutOfBoundsException(index);
              if (size == capacity)
                     reallocate();
              for (int i = size; i > index; i--)
                     data[i] = data[i - 1];
              data[index] = anEntry;
              size++;
       }

       public E get(int index) {
              if (index < 0 || index >= size)
                     throw new ArrayIndexOutOfBoundsException(index);
              return data[index];
       }

       public E set(int index, E newValue) {
              if (index < 0 || index >= size)
                     throw new ArrayIndexOutOfBoundsException(index);
              E old = data[index];
              data[index] = newValue;
              return old;
       }

       public int indexOf(E item) {
              for (int i = 0; i < size; i++)
                     if (data[i].equals(item))
                            return i;
              return -1;
       }

       public boolean contains(E obj) {
              for (int i = 0; i < size; i++)
                     if (data[i].equals(obj))
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
              for (int i = 0; i < size; i++)
                     data[i] = null;
              size = 0;
       }

       public E remove(int index) {
              if (index < 0 || index >= size)
                     throw new ArrayIndexOutOfBoundsException(index);
              E removed = data[index];
              for (int i = index + 1; i < size; i++)
                     data[i - 1] = data[i];
              data[size - 1] = null;
              size--;
              return removed;
       }

       public boolean remove(E obj) {
              int index = indexOf(obj);
              if (index == -1)
                     return false;
              remove(index);
              return true;
       }

       public String toString() {
              String res = "";
              res += "[";
              for (int i = 0; i < size; i++) {
                     res += data[i];
                     if (i != size - 1)
                            res += ", ";
              }
              res += "]";
              return res;
       }

       @Override

       public int compareTo(KWArrayList<E> other) {
              int min = Math.min(this.size(), other.size());
              for (int i = 0; i < min; i++) {
                     int cmp = this.data[i].compareTo(other.data[i]);
                     if (cmp != 0)
                            return cmp;
              }
              return Integer.compare(this.size(), other.size());
       }

       public int lastIndexOf(E obj) {
              int index = -1;
              for (int i = 0; i < size; i++)
                     if (data[i].equals(obj))
                            index = i;
              return index;
       }

       public boolean setAll(E value, E rpValue) {
              for (int i = 0; i < size; i++)
                     if (data[i].equals(value))
                            data[i] = rpValue;
              return true;
       }

       public boolean compareHalfs() {
              if (size() < 2)
                     return false;
              E max = data[0];
              E min = data[size / 2];
              int i;
              for (i = 1; i < size / 2; i++)
                     if (data[i].compareTo(max) > 0)
                            max = data[i];
              for (i = size / 2 + 1; i < size; i++)
                     if (data[i].compareTo(min) < 0)
                            min = data[i];
              return min.compareTo(max) > 0;

       }

       public void removeSmallest() {
              if (isEmpty())
                     return;
              E min = data[0];
              for (int i = 1; i < size; i++)
                     if (data[i].compareTo(min) < 0)
                            min = data[i];
              remove(min);
       }

       public boolean removeAll(E obj) {
              boolean isFound = false;
              for (int i = 0; i < size; i++)
                     if (data[i].equals(obj)) {
                            remove(data[i]);
                            isFound = true;
                     }
              return isFound;
       }

       public boolean compareReverse(KWArrayList<E> Arr) {
              if (this.isEmpty() || Arr.isEmpty())
                     return false;
              if (this.size() != Arr.size())
                     return false;
              for (int i = 0, j = this.size - 1; i < this.size && j >= 0; i++, j--)
                     if (this.data[i].compareTo(Arr.data[j]) != 0)
                            return false;
              return true;
       }
}

class ListApplication {
       public boolean checkItem(KWArrayList<Integer> list1, int item) {
              int index = list1.indexOf(item);
              if (index == -1)
                     return false;
              int i;
              for (i = 0; i < index; i++)
                     if (list1.get(i).compareTo(item) > 0)
                            return false;
              for (i = index + 1; i < list1.size(); i++)
                     if (list1.get(i).compareTo(item) < 0)
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

public class KWAL {
       public static <E extends Comparable<E>> boolean removeDuplicate(KWArrayList<E> L, E obj) {
              int i;
              for (i = 0; i < L.size(); i++)
                     if (L.get(i).equals(obj))
                            break;
              for (int j = i + 1; j < L.size(); j++)
                     if (L.get(j).equals(obj))
                            L.remove(obj);
              return true;
       }

       public static <E extends Comparable<E>> boolean compareHalfs(KWArrayList<E> array) {
              if (array.size() < 2)
                     return false;
              E max = array.get(0);
              E min = array.get(array.size() / 2);
              for (int i = 1; i < array.size() / 2; i++)
                     if (array.get(i).compareTo(max) > 0)
                            max = array.get(i);
              for (int i = array.size() / 2 + 1; i < array.size(); i++)
                     if (array.get(i).compareTo(min) < 0)
                            min = array.get(i);
              return min.compareTo(max) > 0;
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

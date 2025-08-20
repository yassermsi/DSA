package ArrayLists;

import java.util.Arrays;

class KWArrayList<E> {
       private static final int INITIAL_CAPACITY = 10;
       private E[] data;
       private int size;
       private int capacity;

       public KWArrayList() {
              capacity = INITIAL_CAPACITY;
              data = (E[]) new Object[capacity];
              size = 0;
       }

       public KWArrayList(int cap) {
              if (cap <= 0)
                     capacity = INITIAL_CAPACITY;
              else
                     capacity = cap;
              data = (E[]) new Object[capacity];
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
              for (E item : data)
                     if (item.equals(obj))
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
}

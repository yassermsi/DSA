public class HashTable<E extends Integer> {
       private static final int INIT_CAP = 10;
       private E[] theData;
       private int size;
       private int capacity;

       public HashTable() {
              capacity = INIT_CAP;
              theData = (E[]) new Object[capacity];
              size = 0;
       }

       public HashTable(int cap) {
              capacity = (cap <= 0) ? INIT_CAP : cap;
              theData = (E[]) new Object[capacity];
              size = 0;
       }

       public int size() {
              return size;
       }

       public int capacity() {
              return capacity;
       }

       public void insertKeyLinear(E key) {
              if (size == capacity)
                     System.out.println("The hash table is full!");
              else {
                     int loc = (Integer) key % capacity;
                     int nloc = loc;
                     for (int i = 1; theData[nloc] != null; i++)
                            nloc = (loc + i) % capacity;
                     size++;
                     theData[nloc] = key;
              }
       }

       public void insertKeyQuadratic(E key) {
              if (size == capacity) {
                     System.out.println("The hash table is full!");
                     return;
              }
              int loc = (Integer) key % capacity;
              int nloc = loc;
              int i = 1;
              while (theData[nloc] != null) {
                     nloc = (loc + i * i) % capacity;
                     // (int) Math.pow(i, 2)
                     i++;
              }
              size++;
              theData[nloc] = key;
       }

       public int linearSearch(E key) {
              if (size == 0)
                     return -1;
              int loc = (Integer) key % capacity;
              int i = 1;
              int nloc = loc;
              boolean found = false;
              while (theData[nloc] != null && !found) {
                     if (theData[nloc].equals(key))
                            found = true;
                     else
                            nloc = (loc + i) % capacity;
                     if (nloc == loc)
                            break;
                     i++;
              }
              if (found)
                     return nloc;
              else
                     return -1;
       }

       public int quadraticSearch(E key) {
              if (size == 0)
                     return -1;
              int loc = (Integer) key % capacity;
              int nloc = loc;
              for (int i = 0; i < capacity && nloc != loc; i++)
                     if (theData[nloc].equals(key))
                            return nloc;
                     else
                            nloc = (loc + i * i) % capacity;
              return -1;
       }

       public E get(int i) {
              return (i < 0 || i >= capacity || theData[i] == null) ? null : theData[i];
       }

       public boolean linearRemove(E item) {
              if (linearSearch(item) == -1)
                     return false;
              E[] theData1 = (E[]) new Object[capacity];
              for (int i = 0; i < capacity; i++)
                     if (theData[i] != item)
                            theData1[i] = theData[i];
              for (int i = 0; i < capacity; i++)
                     theData[i] = null;
              size = 0;
              for (E data : theData1)
                     if (data != null) {
                            insertKeyLinear(data);
                            size++;
                     }
              return true;
       }

       public boolean quadraticRemove(E item) {
              if (quadraticSearch(item) == -1)
                     return false;
              E[] theData1 = (E[]) new Object[capacity];
              for (int i = 0; i < capacity; i++)
                     if (theData[i] != item)
                            theData1[i] = theData[i];
              for (int i = 0; i < capacity; i++)
                     theData[i] = null;
              size = 0;
              for (int i = 0; i < capacity; i++)
                     if (theData1[i] != null) {
                            insertKeyQuadratic(theData1[i]);
                            size++;
                     }
              return true;
       }
}

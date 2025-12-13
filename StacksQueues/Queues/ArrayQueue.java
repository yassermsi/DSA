package Queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> {
       private E[] theData;
       private int front;
       private int rear;
       private int size;
       private int capacity;
       private static final int DEFAULT_CAPACITY = 10;

       public ArrayQueue() {
              this(DEFAULT_CAPACITY);
       }

       public ArrayQueue(int cap) {
              if (cap <= 0)
                     capacity = DEFAULT_CAPACITY;
              else
                     capacity = cap;
              theData = (E[]) new Object[capacity];
              front = 0;
              rear = capacity - 1;
              size = 0;
       }

       public ArrayQueue(ArrayQueue<E> other) {
              capacity = other.capacity;
              size = other.size;
              front = other.front;
              rear = other.rear;
              theData = (E[]) new Object[capacity];
              int index = front;
              for (int i = 0; i < size; i++) {
                     theData[index] = other.theData[index];
                     index = (index + 1) % capacity;
              }
       }

       public boolean isEmpty() {
              return size == 0;
       }

       public boolean offer(E item) {
              if (size == capacity)
                     reallocate();
              rear = (rear + 1) % capacity;
              theData[rear] = item;
              size++;
              return true;
       }

       public void reallocate() {
              int newCap = capacity * 2;
              E[] newData = (E[]) new Object[newCap];
              int idx = front;
              for (int i = 0; i < size; i++) {
                     newData[idx] = theData[idx];
                     idx = (idx + 1) % capacity;
              }
              front = 0;
              rear = size - 1;
              theData = newData;
              capacity = newCap;
       }

       public E peek() {
              if (isEmpty())
                     return null;
              else
                     return theData[front];
       }

       public E poll() {
              if (isEmpty())
                     return null;
              E result = theData[front];
              front = (front + 1) % capacity;
              size--;
              return result;
       }

       public Iterator<E> iterator() {
              return new Iter();
       }

       public int size() {
              return size;
       }

       private class Iter implements Iterator<E> {
              private int index;
              private int count;

              public Iter() {
                     index = front;
                     count = 0;
              }

              public boolean hasNext() {
                     return count < size;
              }

              public void remove() {
                     throw new UnsupportedOperationException();
              }

              public E next() {
                     if (!hasNext())
                            throw new NoSuchElementException();
                     E returnValue = theData[index];
                     index = (index + 1) % capacity;
                     count++;
                     return returnValue;
              }
       }

       public void RemoveFromQueue(E item, ArrayQueue<E> q1) {
              ArrayQueue<E> qtemp = new ArrayQueue<>();
              if (this.isEmpty())
                     return;
              E value;
              while (!this.isEmpty()) {
                     value = this.poll();
                     if (((Comparable) value).compareTo((Comparable) item) > 0)
                            q1.offer(value);
                     else
                            qtemp.offer(value);
              }
              while (!qtemp.isEmpty())
                     this.offer(qtemp.poll());
       }

       public void addQueueWithCondition(Integer item) {
              if (size <= 1)
                     return;
              int value1 = (Integer) theData[front];
              int value2 = (Integer) theData[(front + 1) % capacity];
              int avg = (value1 + value2) / 2;
              if (item > avg) {
                     if (size == capacity)
                            reallocate();
                     rear = (rear + 1) % capacity;
                     theData[rear] = (E) item;
                     size++;
              }
       }
}

class AQ {

       public static <E> boolean SplitQueue(ArrayQueue<E> q1, ArrayQueue<E> q2, ArrayQueue<E> q3) {
              ArrayQueue<E> q = new ArrayQueue<>(q1);
              if (q.isEmpty())
                     return false;
              int n = q.size();
              for (int i = 0; i < n; i++)
                     if (i % 2 == 0)
                            q2.offer(q.poll());
                     else
                            q3.offer(q.poll());
              return true;
              /*
               * Iterator<E> iter = q1.iterator();
               * while (iter.hasNext()) {
               * q2.offer(iter.next());
               * if (iter.hasNext())
               * q3.offer(iter.next());
               * }
               * return true;
               */
              /*
               * ArrayQueue<E> q11 = new ArrayQueue<>(q1);
               * while (!q11.isEmpty()) {
               * q2.offer(q11.poll())
               * if (q11.isEmpty())
               * return true;
               * else
               * q3.offer(q11.poll());
               * }
               * return true;
               */
       }

       public static <E> boolean MergeQueue(ArrayQueue<E> q1, ArrayQueue<E> q2, ArrayQueue<E> q3) {
              Iterator<E> iter1 = q1.iterator();
              Iterator<E> iter2 = q2.iterator();
              if (!iter1.hasNext() || !iter2.hasNext())
                     return false;
              while (iter1.hasNext() && iter2.hasNext()) {
                     q3.offer(iter1.next());
                     q3.offer(iter2.next());
              }
              while (iter1.hasNext())
                     q3.offer(iter1.next());
              while (iter2.hasNext())
                     q3.offer(iter2.next());
              return true;
              /*
               * ArrayQueue<E> q11 = new ArrayQueue<>(q1);
               * ArrayQueue<E> q22 = new ArrayQueue<>(q2);
               * if (q11.isEmpty() || q22.isEmpty())
               * return false;
               * while (!q11.isEmpty && !q22.isEmpty()) {
               * q3.offer(q11.poll())
               * q3.offer(q22.poll())
               * }
               * while (!q11.isEmpty())
               * q3.offer(q11.poll())
               * while (!q22.isEmpty())
               * q3.offer(q22.poll())
               * return true;
               */
       }

       public static boolean CreateQueue(ArrayQueue<Integer> q1, ArrayQueue<Integer> q2, int item) {
              ArrayQueue<Integer> q11 = new ArrayQueue<>(q1);
              if (q11.isEmpty())
                     return false;
              int e1, e2, sum;
              while (!q11.isEmpty()) {
                     e1 = q11.poll();
                     if (q11.isEmpty())
                            break;
                     e2 = q11.poll();
                     sum = e1 + e2;
                     if (sum > item)
                            q2.offer(sum);
                     else
                            q2.offer(item);
              }
              return true;
              /*
               * ArrayQueue<Integer> q3 = new ArrayQueue<>(q1);
               * if (q3.isEmpty())
               * return false;
               * int n = q3.size();
               * int sum;
               * for (int i = 0; i + 1 < n; i = i + 2) {
               * sum = q3.poll() + q3.poll();
               * q2.offer(sum > item ? sum : item);
               * }
               * return true;
               */
              /*
               * Iterator<Integer> iter = q1.iterator();
               * if (!iter.hasNext())
               * return false;
               * int v1, v2, sum;
               * while (iter.hasNext()) {
               * v1 = iter.next();
               * if (iter.hasNext()) {
               * v2 = iter.next();
               * sum = v1 + v2;
               * if (item > sum)
               * q2.offer(item);
               * else
               * q2.offer(sum);
               * }
               * }
               */
       }
}

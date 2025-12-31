package Stacks;

import java.util.Arrays;
import java.util.NoSuchElementException;

interface StackInt<E> {
       E push(E obj);

       E pop();

       boolean isEmpty();

       E peek();
}

public class ArrayStack<E> implements StackInt<E> {
       private static final int INITIAL_CAPACITY = 10;
       private E[] theData;
       private int topOfStack;

       public ArrayStack() {
              this(INITIAL_CAPACITY);
       }

       public ArrayStack(int cap) {
              if (cap <= 0)
                     cap = INITIAL_CAPACITY;
              theData = (E[]) new Object[cap];
              topOfStack = -1;
       }

       public ArrayStack(ArrayStack<E> other) {
              theData = (E[]) new Object[other.theData.length];
              for (int i = 0; i < other.topOfStack + 1; i++)
                     this.theData[i] = other.theData[i];
              this.topOfStack = other.topOfStack;
       }

       private void reallocate() {
              int length = theData.length * 2;
              theData = Arrays.copyOf(theData, length);
       }

       @Override
       public E push(E obj) {
              if (topOfStack == theData.length - 1)
                     reallocate();
              theData[++topOfStack] = obj;
              return obj;
       }

       @Override
       public E pop() {
              if (topOfStack == -1)
                     throw new NoSuchElementException();
              E old = theData[topOfStack];
              theData[topOfStack--] = null;
              return old;
       }

       @Override
       public boolean isEmpty() {
              return topOfStack == -1;
       }

       @Override
       public E peek() {
              if (isEmpty())
                     throw new NoSuchElementException();
              return theData[topOfStack];
       }
}

class StackEx {
       public static void rearrangeStacks(ArrayStack<Integer> s1, ArrayStack<Integer> s2) {
              ArrayStack<Integer> positive = new ArrayStack<>();
              ArrayStack<Integer> negative = new ArrayStack<>();
              while (!s1.isEmpty()) {
                     int num = s1.pop();
                     if (num > 0)
                            positive.push(num);
                     else if (num < 0)
                            negative.push(num);
              }
              while (!s2.isEmpty()) {
                     int num = s2.pop();
                     if (num > 0)
                            positive.push(num);
                     else if (num < 0)
                            negative.push(num);
              }
              while (!positive.isEmpty())
                     s1.push(positive.pop());
              while (!negative.isEmpty())
                     s2.push(negative.pop());
       }

       public static <E> boolean compareStacks(ArrayStack<E> st1, ArrayStack<E> st2) {
              ArrayStack<E> st1Copy = new ArrayStack<>(st1);
              ArrayStack<E> st2Copy = new ArrayStack<>(st2);
              ArrayStack<E> st2Rev = new ArrayStack<>();
              int count = 0;
              while (!st2Copy.isEmpty()) {
                     st2Rev.push(st2Copy.pop());
                     count++;
              }
              for (int i = 0; i < count / 2; i++)
                     if (!st1Copy.pop().equals(st2Rev.pop()))
                            return false;
              return true;
       }

       public static <E> int countAndMoveToTop(ArrayStack<E> S1, E item) {
              ArrayStack<E> smaller = new ArrayStack<>();
              ArrayStack<E> greater = new ArrayStack<>();
              int count = 0;
              while (!S1.isEmpty()) {
                     E v = S1.pop();
                     if (((Comparable) v).compareTo((Comparable) item) < 0) {
                            smaller.push(v);
                            count++;
                     } else
                            greater.push(v);
              }
              while (!greater.isEmpty())
                     S1.push(greater.pop());
              while (!smaller.isEmpty())
                     S1.push(smaller.pop());
              return count;
       }
}

class StackApplication {
       public static void removeBelow(int x, ArrayStack<Integer> st) {
              ArrayStack<Integer> temp = new ArrayStack<>();
              while (!st.isEmpty()) {
                     int num = st.pop();
                     if (num >= x)
                            temp.push(num);
              }
              while (!temp.isEmpty())
                     st.push(temp.pop());
       }

       public static <E> boolean stackShuffle(ArrayStack<E> s1, E value) {
              if (s1.isEmpty())
                     return false;
              ArrayStack<E> greater = new ArrayStack<>();
              ArrayStack<E> smaller = new ArrayStack<>();
              while (!s1.isEmpty()) {
                     E item = s1.pop();
                     if (((Comparable) item).compareTo((Comparable) value) > 0)
                            greater.push(item);
                     else
                            smaller.push(item);
              }
              while (!smaller.isEmpty())
                     s1.push(smaller.pop());
              while (!greater.isEmpty())
                     s1.push(greater.pop());
              return true;
       }

       public static <E> boolean ReverseEquality(ArrayStack<E> st1, ArrayStack<E> st2) {
              if (st1.isEmpty() || st2.isEmpty())
                     return false;
              ArrayStack<E> tempSt1 = new ArrayStack<>(st1);
              ArrayStack<E> tempSt2 = new ArrayStack<>(st2);
              ArrayStack<E> revSt2 = new ArrayStack<>();
              while (!tempSt2.isEmpty())
                     revSt2.push(tempSt2.pop());
              while (!tempSt1.isEmpty() && !revSt2.isEmpty()) {
                     E v1 = tempSt1.pop();
                     E v2 = revSt2.pop();
                     if (!v1.equals(v2))
                            return false;
              }
              return true;
       }

       public static boolean matchAndUpdate(ArrayStack<Integer> St1, ArrayStack<Integer> St2, int value) {
              if (St1.isEmpty() || St2.isEmpty())
                     return false;
              ArrayStack<Integer> St1Copy = new ArrayStack<>(St1);
              ArrayStack<Integer> St2Copy = new ArrayStack<>(St2);
              while (!St1Copy.isEmpty()) {
                     int num1 = St1Copy.pop();
                     int num2 = St2Copy.pop();
                     if (num1 != num2)
                            return false;
              }
              ArrayStack<Integer> temp = new ArrayStack<>();
              while (!St1.isEmpty())
                     temp.push(St1.pop() + value);
              while (!temp.isEmpty())
                     St1.push(temp.pop());
              return true;
       }

       public static void assignRelation(ArrayStack<Integer> st1, ArrayStack<Integer> st2, ArrayStack<Character> st3) {
              ArrayStack<Integer> st1Copy = new ArrayStack<>(st1);
              ArrayStack<Integer> st2Copy = new ArrayStack<>(st2);
              ArrayStack<Character> temp = new ArrayStack<>();
              while (!st1Copy.isEmpty()) {
                     int v1 = st1Copy.pop();
                     int v2 = st2Copy.pop();
                     if (v1 > v2)
                            temp.push('>');
                     else if (v1 < v2)
                            temp.push('<');
                     else
                            temp.push('=');
              }
              while (!temp.isEmpty())
                     st3.push(temp.pop());
       }

       public static <E> void constructStack(ArrayStack<E> s1, ArrayStack<E> s2, ArrayStack<E> s3) {
              ArrayStack<E> s1Copy = new ArrayStack<>(s1);
              ArrayStack<E> s11Copy = new ArrayStack<>(s1);
              ArrayStack<E> s2Copy = new ArrayStack<>(s2);
              ArrayStack<E> temp = new ArrayStack<>();
              E s1Top = null, s1Bottom = null;
              int count = 0;
              while (!s1Copy.isEmpty()) {
                     s1Copy.pop();
                     count++;
              }
              for (int i = 0; i < count && !s11Copy.isEmpty(); i++) {
                     E item = s11Copy.pop();
                     if (i == 0)
                            s1Top = item;
                     else if (i == count - 1)
                            s1Bottom = item;
              }
              while (!s2Copy.isEmpty())
                     temp.push(s2Copy.pop());
              s3.push(s1Top);
              while (!temp.isEmpty())
                     s3.push(temp.pop());
              s3.push(s1Bottom);
       }
}
import java.util.Arrays;
import java.util.NoSuchElementException;

interface StackInt<E> {
       E push(E obj);

       E pop();

       boolean isEmpty();

       E peek();
}

class ArrayStack<E> implements StackInt<E> {
       private static final int INITIAL_CAPACITY = 10;
       private E[] theData;
       private int topOfStack;

       public ArrayStack() {
              theData = (E[]) new Object[INITIAL_CAPACITY];
              topOfStack = -1;
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

       public void reallocate() {
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
              ArrayStack<Integer> s3 = new ArrayStack<>();
              ArrayStack<Integer> s4 = new ArrayStack<>();
              while (!s1.isEmpty()) {
                     int num = s1.pop();
                     if (num > 0)
                            s3.push(num);
                     else if (num < 0)
                            s4.push(num);
              }
              while (!s2.isEmpty()) {
                     int num = s2.pop();
                     if (num > 0)
                            s3.push(num);
                     else if (num < 0)
                            s4.push(num);
              }
              while (!s3.isEmpty())
                     s1.push(s3.pop());
              while (!s4.isEmpty())
                     s2.push(s4.pop());
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
              ArrayStack<E> s2 = new ArrayStack<>();
              ArrayStack<E> s3 = new ArrayStack<>();
              while (!s1.isEmpty()) {
                     E item = s1.pop();
                     if (((Comparable) item).compareTo((Comparable) value) > 0)
                            s2.push(item);
                     else
                            s3.push(item);
              }

              while (!s3.isEmpty())
                     s1.push(s3.pop());
              while (!s2.isEmpty())
                     s1.push(s2.pop());
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
}

public class AS {
       public static void main(String[] args) {
              ArrayStack<Integer> AS1 = new ArrayStack<>();
              ArrayStack<Integer> AS2 = new ArrayStack<>();
              AS1.push(10);
              AS1.push(12);
              AS1.push(15);
              AS1.push(3);
              AS1.push(40);
              AS1.push(16);
              System.out.println(AS1.isEmpty());
              System.out.println(AS1.pop());
              System.out.println(AS1.pop());
              System.out.println(AS1.pop());
              System.out.println(AS1.peek());

              while (!AS1.isEmpty())
                     AS2.push(AS1.pop());

              System.out.println(AS1.isEmpty());
              System.out.println(AS2.isEmpty());

              while (!AS2.isEmpty())
                     System.out.println(AS2.pop());

              ArrayStack<Integer> s1 = new ArrayStack<>();
              ArrayStack<Integer> s2 = new ArrayStack<>();
              for (int j = 1; j <= 7; j++)
                     s1.push(j);
              while (!s1.isEmpty()) {
                     int item = s1.pop();
                     if (item % 2 == 0)
                            s2.push(item);
              }
              while (!s2.isEmpty())
                     s1.push(s2.pop());
              while (!s1.isEmpty())
                     System.out.print(s1.pop() + " ");
       }
}

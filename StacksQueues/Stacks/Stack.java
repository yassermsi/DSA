package Stacks;

public class Stack {
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

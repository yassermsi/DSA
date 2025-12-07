import java.util.Iterator;

public class Qs {
       public static void main(String[] args) {
              System.out.println("Exercise 1: ");
              LinkedQueue<Integer> q1 = new LinkedQueue<>();
              LinkedQueue<Integer> q2 = new LinkedQueue<>();
              q1.offer(14);
              q1.offer(30);
              q1.offer(45);
              q1.offer(8);
              q1.offer(75);
              q2.offer(12);
              q2.offer(9);
              q2.offer(16);
              q2.offer(20);
              q2.offer(25);
              System.out.println("Queue size is: " + q2.size());
              q1.poll();
              q1.offer(10);
              System.out.println(q1.poll() - q2.poll());
              System.out.println(q1.peek() - q2.peek());
              System.out.println(q1.isEmpty());
              while (!q1.isEmpty())
                     System.out.println(q1.poll());
              System.out.println(q1.offer(20) && q2.offer(5));
              System.out.println(q1.peek() + q2.peek());
              while (!q2.isEmpty())
                     System.out.println(q2.poll());
              System.out.println(q1.isEmpty());

              System.out.println("Exercise 2: ");
              ArrayQueue<Integer> q21 = new ArrayQueue<>();
              System.out.println(q21.poll());
              q21.offer(12);
              q21.offer(50);
              q21.offer(15);
              q21.offer(10);
              q21.poll();
              q21.poll();
              q21.offer(5);
              System.out.println(q21.isEmpty());
              System.out.println(q21.peek());
              System.out.println("----------");
              System.out.println(q21.offer(6 + 3));
              System.out.println("----------");
              System.out.println(q21.size());
              System.out.println(q21.peek());
              System.out.println(" ");
              Iterator iter = q21.iterator();
              iter.next();
              iter.next();
              while (iter.hasNext())
                     System.out.println(iter.next());
              System.out.println(iter.hasNext());
       }
}

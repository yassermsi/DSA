package Queues;

import java.util.Iterator;

public class Queues {
       public static void main(String[] args) {
              System.out.println("Example 1: ");
              ArrayQueue<Integer> q1 = new ArrayQueue<>();
              q1.offer(10);
              q1.offer(20);
              q1.offer(60);
              q1.offer(70);
              q1.poll();
              Iterator<Integer> iter = q1.iterator();
              while (iter.hasNext()) {
                     int a = iter.next();
                     System.out.print(a + " ");
              }
              System.out.println();
              q1.poll();
              q1.offer(15);
              q1.poll();
              Iterator<Integer> iter1 = q1.iterator();
              while (iter1.hasNext()) {
                     int a = iter1.next();
                     System.out.print(a + " ");
              }

              System.out.println("\nExample 2: ");
              ArrayQueue<Integer> q2 = new ArrayQueue<>();
              System.out.println("Size of the queue: " + q2.size());
              q2.offer(4);
              q2.offer(2);
              q2.offer(6);
              q2.offer(9);
              q2.peek();
              q2.poll();
              q2.offer(11);
              System.out.println("Size of the queue: " + q2.size());
              Iterator<Integer> iter2 = q2.iterator();
              while (iter2.hasNext()) {
                     int b = iter2.next();
                     System.out.print(b + " ");
              }
       }
}
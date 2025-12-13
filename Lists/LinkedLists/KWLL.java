package LinkedLists;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class KWLL {
       public static void main(String[] args) {
              KWLinkedList<Integer> list1 = new KWLinkedList<>();
              list1.addLast(5);
              list1.addLast(10);
              list1.addFirst(15);
              list1.add(1, 12);
              list1.addLast(3);
              ListIterator<Integer> iter = list1.listIterator();
              int a, b;
              try {
                     while (iter.hasNext()) {
                            a = iter.next();
                            b = iter.next();
                            if (a > b)
                                   iter.set(a + b);
                     }
              } catch (NoSuchElementException e) {
                     System.out.println(e.getMessage());
              }
              while (iter.hasPrevious())
                     System.out.print(iter.previous() + " ");
              System.out.println();

              KWLinkedList<String> colors = new KWLinkedList<>();
              colors.addLast("red");
              colors.addFirst("blue");
              colors.add(2, "pink");
              colors.add("brown");
              ListIterator<String> iter1 = colors.listIterator(1);
              iter1.previous();
              iter1.add("black");
              iter1.next();
              iter1.add("green");
              System.out.println("The size of the list: " + colors.size);
              ListIterator<String> iter2 = colors.listIterator(colors.size());
              System.out.println(iter2.hasNext());
              System.out.println(iter2.previousIndex());
              iter2.previous();
              iter2.set("grey");
              ListIterator<String> iter3 = colors.listIterator(iter1);
              iter3.next();
              iter3.remove();
              ListIterator<String> iterprint = colors.listIterator();
              while (iterprint.hasNext())
                     System.out.println(iterprint.next());
       }
}


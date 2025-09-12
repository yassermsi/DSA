package LinkedLists;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class Iter {
       public static void main(String[] args) {
              LinkedList<String> languages = new LinkedList<>();
              languages.add("Python");
              languages.add("Java");
              languages.addFirst("C++");
              languages.add(2, "Javascript");
              languages.addLast("C");
              languages.addFirst("PHP");
              System.out.println("LinkedList: " + languages);

              LinkedList<Integer> numbers = new LinkedList<>();
              numbers.add(10);
              numbers.add(5);
              numbers.add(20);
              numbers.add(14);
              numbers.add(3);
              System.out.println("LinkedList: " + numbers);
              int num1 = numbers.get(3);
              System.out.println("Get data at position 3: " + num1);
              int num2 = numbers.getFirst();
              System.out.println("Get data at first position: " + num2);
              int num3 = numbers.getLast();
              System.out.println("Get data at last position: " + num3);
              numbers.clear();
              try {
                     int num4 = numbers.getFirst();
                     System.out.println("Get data at first position: " + num4);
              } catch (NoSuchElementException e) {
                     System.out.println(e.getMessage());
              }

              languages.clear();
              languages.add("Python");
              languages.add("Java");
              languages.add("C++");
              languages.add("Javascript");
              languages.add("Java");
              languages.add("PHP");
              System.out.println("LinkedList: " + languages);
              System.out.println("Remove node with Java data: " + languages.remove("Java"));
              System.out.println("Remove node at index 4: " + languages.remove(4));
              System.out.println("Remove node with data C: " + languages.remove("C"));
              System.out.println("Updated LinkedList: " + languages);
              System.out.println("The size of the list: " + languages.size());

              Iterator<String> iter1 = languages.iterator();
              while (iter1.hasNext())
                     System.out.println(iter1.next());
              /*
               * int i = 0;
               * while (i < languages.size()) {
               * System.out.println(languages.get(i));
               * i++;
               * }
               */
              /*
               * for (int i = 0; i < number.size(); i++)
               *     System.out.println(numbers.get(i))
               */
              LinkedList<String> aListDay = new LinkedList<>();
              aListDay.add("Sunday");
              aListDay.add("Monday");
              aListDay.add("Tuesday");
              Iterator<String> iter = aListDay.iterator();
              while (iter.hasNext())
                     System.out.println(iter.next());

              numbers.addFirst(15);
              numbers.addFirst(12);
              numbers.addLast(7);
              numbers.add(1, 30);
              numbers.addLast(20);
              Iterator<Integer> iter2 = numbers.iterator();
              int number = iter2.next();
              System.out.println("Accessed Element: " + number);
              iter2.next();
              iter2.remove();
              System.out.println("Updated LinkedList: ");
              while (iter2.hasNext())
                     System.out.print(iter2.next() + ", ");
       }
}
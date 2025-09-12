package LinkedLists;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIter {
       public static void main(String[] args) {
              System.out.println("Example 1: ");
              LinkedList<String> myList = new LinkedList<>();
              myList.add("A");
              myList.add("B");
              myList.add("C");
              myList.add("D");
              myList.add("E");
              ListIterator<String> myIter = myList.listIterator(3);
              System.out.println("Next Element: " + myIter.next());
              System.out.println("Next Element's Index: " + myIter.nextIndex());
              System.out.println("Previous Element: " + myIter.previous());
              System.out.println("Previous Element's Index: " + myIter.previousIndex());
              System.out.println("Has next? " + myIter.hasNext());
              System.out.println("Has previous? " + myIter.hasPrevious());

              System.out.println("\nExample 2:");
              LinkedList<Integer> numbers = new LinkedList<>();
              numbers.addFirst(10);
              numbers.addFirst(14);
              numbers.add(1, 3);
              numbers.addLast(20);
              System.out.println("LinkedList: " + numbers);
              ListIterator<Integer> iter = numbers.listIterator();
              iter.next();
              iter.next();
              int number1 = iter.previous();
              System.out.println("Previous Element: " + number1);
              int index1 = iter.previousIndex();
              System.out.println("Position of the Previous element: " + index1);

              System.out.println("\nExample 3:");
              LinkedList<String> animals = new LinkedList<>();
              animals.addFirst("Dog");
              animals.addLast("Cat");
              animals.addLast("Horse");
              System.out.println("LinkedList 1: " + animals);
              ListIterator<String> listIter = animals.listIterator();
              listIter.next();
              listIter.remove();
              System.out.println("LinkedList 2: " + animals);
              listIter.add("Bird");
              listIter.add("Fish");
              System.out.println("LinkedList 3: " + animals);
              listIter.previous();
              listIter.add("Zebra");
              System.out.println("LinkedList 4: " + animals);

              System.out.println("\nExercise 1: ");
              LinkedList<Integer> list = new LinkedList<>();
              list.add(10);
              list.add(20);
              list.add(30);
              System.out.println("The list is: " + list);
              ListIterator<Integer> iterator = list.listIterator();
              System.out.println("Call nextIndex() " + iterator.nextIndex());
              System.out.println("Call previousIndex() " + iterator.previousIndex());
              iterator.add(11);
              iterator.add(15);
              iterator.next();
              iterator.remove();
              System.out.println("Calling nextIndex() " + iterator.nextIndex());
              System.out.println("Calling previousIndex() " + iterator.previousIndex());
              while (iterator.hasNext())
                     System.out.print(iterator.next() + " ");
              System.out.println();
              while (iterator.hasPrevious())
                     System.out.print(iterator.previous() + " ");
              System.out.println();

              System.out.println("\nExercise 2: ");
              LinkedList<Integer> list1 = new LinkedList<>();
              list1.addFirst(15);
              list1.addFirst(5);
              list1.addLast(40);
              list1.add(2, 30);
              ListIterator<Integer> iter1 = list1.listIterator();
              iter1.add(6);
              iter1.add(9);
              iter1.next();
              iter1.set(10);
              ListIterator<Integer> iter2 = list1.listIterator();
              // iter2 = list1.listIterator(iter1);
              iter2 = list1.listIterator(iter1.nextIndex());
              while (iter2.hasNext())
                     System.out.print(iter2.next() + " ");
              System.out.println();
              iter1 = list1.listIterator();
              while (iter1.hasNext())
                     System.out.print(iter1.next() + " ");
              System.out.println();
              iter1 = list1.listIterator(3);
              while (iter1.hasPrevious())
                     System.out.print(iter1.previous() + " ");
              System.out.println();
              while (iter2.hasPrevious())
                     System.out.print(iter2.previous() + " ");
              System.out.println();
              iter1 = list1.listIterator(2);
              iter1.next();
              iter1.next();
              iter1.remove();
              iter1 = list1.listIterator(0);
              while (iter1.hasNext())
                     System.out.print(iter1.next() + " ");
              System.out.println();
       }
}

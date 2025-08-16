package ArrayLists;

import java.util.ArrayList;

public class FirstLec {
       public static void main(String[] args) {
              System.out.println("First Example: ");
              ArrayList<Integer> myList = new ArrayList<>();
              myList.add(13);
              myList.add(4);
              myList.add(8);
              myList.add(3);
              System.out.println("myList: " + myList);
              System.out.println("myList by get method: ");
              for (int i = 0; i < myList.size(); i++)
                     System.out.print(myList.get(i) + " ");

              System.out.println("\n\nSecond Example:");
              ArrayList<Integer> list1 = new ArrayList<>();
              list1.add(11);
              list1.add(2);
              list1.add(1, 7);
              list1.add(10);
              list1.add(3, 15);
              list1.set(2, 30);
              list1.remove(4);
              for (int i = 0; i < list1.size(); i++)
                     System.out.print(list1.get(i) + " ");
              System.out.println();
              System.out.print(list1.get(2) + " ");
              System.out.print(list1.indexOf(15) + " ");
              System.out.print(list1.remove(1) + " ");
              System.out.print(list1.remove((Integer) 10));

              System.out.println("\n\nThird Example: ");
              System.out.println("myList: " + myList);
              boolean value = myList.add(30);
              System.out.println("Do you add 30 to the list? " + value);
              myList.add(2, 40);
              System.out.println("myList after adding 30 and 40: ");
              for (int i = 0; i < myList.size(); i++)
                     System.out.print(myList.get(i) + " ");
              System.out.println("\nThe size of the list: " + myList.size());
              System.out.println("Get the element at index 3: " + myList.get(3));
              System.out.println("Set 14 at index 0 and return old value: " + myList.set(0, 14));
              System.out.println("myList after set method: ");
              for (int i = 0; i < myList.size(); i++)
                     System.out.print(myList.get(i) + " ");
              System.out.println("\nIndex of the element 25 is: " + myList.indexOf(25));
              System.out.println("Index of element 3: " + myList.indexOf(3));
              System.out.println("Remove item 4 from the list: " + myList.remove((Integer) 4));
              System.out.println("Remove item at index 2: " + myList.remove(2));
              System.out.println("The updated list: " + myList);
       }
}

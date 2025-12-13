package ArrayLists;

import java.util.ArrayList;

public class ArrayList1 {
       public static void main(String[] args) {
              System.out.println("Example 1: ");
              ArrayList<Integer> arrayList1 = new ArrayList<>();
              arrayList1.add(5);
              arrayList1.add(10);
              arrayList1.add(30);
              arrayList1.add(50);
              for (int i = 0; i < arrayList1.size(); i++)
                     System.out.print(arrayList1.get(i) + " ");

              System.out.println();
              arrayList1.remove(2);
              int loc = arrayList1.indexOf(30);
              if (loc != -1)
                     System.out.println("30 Found at location " + loc);
              else
                     System.out.println("30 Not Found");
              arrayList1.add(3, 100);
              for (int i = 0; i < arrayList1.size(); i++)
                     System.out.print(arrayList1.get(i) + " ");
              System.out.println();
              arrayList1.remove((Integer) 10);
              for (int i = 0; i < arrayList1.size(); i++)
                     System.out.print(arrayList1.get(i) + " ");

              System.out.println("\nExample 2: ");
              KWArrayList<Integer> list = new KWArrayList<>();
              list.add(1);
              list.add(7);
              list.add(22);
              list.add(1, 100);
              for (int i = 0; i < list.size(); i++)
                     System.out.print(list.get(i) + " ");
              list.set(2, 50);
              list.remove(1);
              System.out.println();
              for (int i = 0; i < list.size(); i++)
                     System.out.print(list.get(i) + " ");
       }
}

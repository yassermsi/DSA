package ArrayLists;

import java.util.ArrayList;

public class ArrayList1 {
       public static void main(String[] args) {
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
       }
}

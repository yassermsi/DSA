package LinkedLists;

public class SLL {
       public static void main(String[] args) {
              SingleLinkedList<String> List1 = new SingleLinkedList<>();
              List1.add("B");
              List1.add("C");
              List1.add(0, "A");
              List1.add(3, "D");
              List1.add("E");
              List1.add("F");
              System.out.println("The size of the list is: " + List1.size());
              System.out.println("The data of the list: \n" + List1);
              System.out.println("Element removed from the list: " + List1.remove(4));
              List1.set(0, "Ahmed");
              List1.set(4, "Eman");
              System.out.println(List1.get(2));
              System.out.println(List1.indexOf("B"));
              System.out.println(List1.contains("P"));
              System.out.println("The size of the list now is: " + List1.size());
              for (int i = 0; i < List1.size(); i++)
                     System.out.print(List1.get(i) + " ");
       }
}

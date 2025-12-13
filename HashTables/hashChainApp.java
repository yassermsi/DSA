public class hashChainApp {
       public static void main(String[] args) {
              HashTableChaining<Integer> ht1 = new HashTableChaining<>();
              ht1.insertKey(5);
              ht1.insertKey(10);
              ht1.insertKey(7);
              ht1.insertKey(17);
              ht1.insertKey(27);
              ht1.insertKey(37);
              for (int i = 0; i < ht1.capacity(); i++)
                     System.out.println("Location " + i + ": " + ht1.toString(i));
              int loc = ht1.search(27);
              if (loc != -1)
                     System.out.println("Found in location "  + loc);
              else 
                     System.out.println("NOT FOUND!");
       }
}

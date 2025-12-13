public class HashApplication {
       public static void main(String[] args) {
              HashTable<Integer> ht1 = new HashTable<>();
              ht1.insertKeyQuadratic(5);
              ht1.insertKeyQuadratic(10);
              ht1.insertKeyQuadratic(7);
              ht1.insertKeyQuadratic(17);
              ht1.insertKeyQuadratic(27);
              ht1.insertKeyQuadratic(37);
              for (int i = 0; i < ht1.capacity(); i++)
                     System.out.println("Location " + i + ": " + ht1.get(i));
              int loc = ht1.quadraticSearch(27);
              if (loc != -1)
                     System.out.println("Found in location "  + loc);
              else 
                     System.out.println("NOT FOUND!");
       }
}

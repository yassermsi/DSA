// Yasser Almasri 202407061ﬁ

package ArrayLists;

public class demo_PI_Manager202407061 {
       public static void main(String[] args) {
              PI_Manager_202407061 list1 = new PI_Manager_202407061();
              list1.addProduct("Laptop");
              list1.addProduct("Smartphone");
              list1.addProduct("Tablet");
              System.out.println("Product List Length: " + list1.getLength());
              System.out.println("Is 'Smartphone' in list? " + list1.isProductInList("Smartphone"));
              System.out.println("Product at index 1: " + list1.getProduct(1));
              String replacedProduct = list1.setProduct(2, "Smartwatch");
              System.out.println("Replaced Product: " + replacedProduct);
              System.out.println("Product at index 2 after replacement: " + list1.getLast());
              list1.removeProduct(0);
              System.out.println("Product List Length after removal: " + list1.size());
              PI_Manager_202407061 list2 = new PI_Manager_202407061(5);
              list2.addProduct("Microsoft Word");
              list2.addProduct("Google Chrome");
              list2.addProduct("Adobe Photoshop");
              list2.addProduct("Spotify");
              list2.addProduct("Visual Studio Code");
              list2.removeLastProduct();
              System.out.println("\n Is List 2 equal to List 1? " + list2.equals(list1));
              list2.reverse();
              System.out.println("List 2 Products after reversal: ");
              for (int i = 0; i < list2.getLength(); i++)
                     System.out.print(list2.getProduct(i) + "  ");
              System.out.println("\n Is List 2 empty? " + list2.isEmpty());
              String lastProduct = list2.getLast();
              System.out.println("Last Product in List 2: " + lastProduct);
              list2.setLast("Spotify");
              System.out.println("Last Product in List 2 after update: " + list2.getLast());
              System.out.println("How many times 'Spotify' appears in List 2? " + list2.countOccurrences("Spotify"));
              System.out.println(list2.toString());
              try {
                     System.out.println("Trying to access product at invalid index (10): " + list1.getProduct(10));
              } catch (ArrayIndexOutOfBoundsException e) {
                     System.out.println("Exception caught: " + e.getMessage());
              }
              try {
                     list2.setProduct(-1, "Invalid");
              } catch (ArrayIndexOutOfBoundsException e) {
                     System.out.println("Exception caught while setting product: " + e.getMessage());
              }

       }
}

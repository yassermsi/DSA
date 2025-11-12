// Yasser Almasri 202407061

package ArrayLists;

public class PI_Manager_202407061 {
       private String[] productList;
       private int length;
       private int capacity = 10;

       public PI_Manager_202407061() {
              capacity = 10;
              productList = new String[capacity];
              length = 0;
       }

       public PI_Manager_202407061(int newCapacity) {
              if (newCapacity <= 0)
                     capacity = 10;
              else 
                     capacity = newCapacity;
              productList = new String[capacity];
              length = 0;
       }

       private void reallocate() {
              capacity *= 2;
              String[] newList = new String[capacity];
              for (int i = 0; i < length; i++)
                     newList[i] = productList[i];
              productList = newList;
       }

       public int getLength() {
              return length;
       }

       public void addProduct(String newProduct) {
              if (length == capacity)
                     reallocate();
              productList[length++] = newProduct;
       }

       public boolean isProductInList(String product) {
              for (int i = 0; i < length; i++)
                     if (productList[i].equals(product))
                            return true;
              return false;
       }

       public String getProduct(int index) {
              if (index < 0 || index >= length)
                     throw new ArrayIndexOutOfBoundsException(index);
              return productList[index];
       }

       public String setProduct(int index, String newProduct) {
              if (index < 0 || index >= length)
                     throw new ArrayIndexOutOfBoundsException(index);
              String oldProduct = productList[index];
              productList[index] = newProduct;
              return oldProduct;
       }

       public void removeProduct(int index) {
              if (index < 0 || index >= length)
                     throw new ArrayIndexOutOfBoundsException(index);
              for (int i = index + 1; i < length; i++)
                     productList[i - 1] = productList[i];
              productList[length - 1] = null;
              length--;
       }

       public void removeLastProduct() {
              if (length == 0)
                     throw new IllegalStateException("List is empty");
              productList[length - 1] = null;
              length--;
       }

       public boolean equals(PI_Manager_202407061 otherList) {
              if (this.length != otherList.length)
                     return false;
              for (int i = 0; i < this.length; i++)
                     if (!this.productList[i].equals(otherList.productList[i]))
                            return false;
              return true;
       }

       public void reverse() {
              for (int i = 0, j = length - 1; i < j; i = i + 1, j = j - 1) {
                     String temp = productList[i];
                     productList[i] = productList[j];
                     productList[j] = temp;
              }
       }

       public boolean isEmpty() {
              return length == 0;
       }

       public String getLast() {
              if (isEmpty())
                     throw new IllegalStateException("List is empty");
              return productList[length - 1];
       }

       public void setLast(String newValue) {
              if (isEmpty())
                     throw new IllegalStateException("List is empty");
              productList[length - 1] = newValue;
       }

       public int countOccurrences(String value) {
              int counter = 0;
              for (int i = 0; i < length; i++)
                     if (productList[i].equals(value))
                            counter++;
              return counter;
       }

       public String toString() {
              String res = "[";
              for (int i = 0; i < length; i++) {
                     res += productList[i];
                     if (i < length - 1)
                            res += ", ";
              }
              res += "]";
              return res;
       }

       public int size() {
              return getLength();
       }
}

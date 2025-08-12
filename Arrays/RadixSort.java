public class RadixSort {
       public static void main(String[] args) {
              int[] arr = { 33, 45, 40, 25, 17, 24 };
              int[][] radix = new int[10][arr.length];
              int max = arr[0];
              for (int n : arr)
                     if (n > max)
                            max = n;
              int place = 1;
              while (max / place > 0) {
                     for (int n : arr) {
                            int row = (n / place) % 10;
                            int col = 0;
                            while (col < arr.length && radix[row][col] != 0)
                                   col++;
                            radix[row][col] = n;
                     }
                     int idx = 0;
                     for (int i = 0; i < radix.length; i++)
                            for (int j = 0; j < radix[i].length; j++)
                                   if (radix[i][j] != 0) {
                                          arr[idx++] = radix[i][j];
                                          radix[i][j] = 0;
                                   }
                     place *= 10;
              }
              System.out.print("Sorted array: ");
              for (int n : arr) {
                     System.out.print(n + " ");
              }
       }
}

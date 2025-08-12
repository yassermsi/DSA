public class RadixSort {
       public static void main(String[] args) {
              int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
              System.out.print("Original array: ");
              int max = arr[0];
              for (int n : arr) {
                     if (n > max)
                            max = n;
                     System.out.print(n + " ");
              }
              System.out.println();
              int[][] radix = new int[10][arr.length];
              int[] count = new int[10];
              int place = 1;
              while (max / place > 0) {
                     for (int n : arr) {
                            int index = (n / place) % 10;
                            radix[index][count[index]++] = n;
                     }
                     int idx = 0;
                     for (int i = 0; i < radix.length; i++) {
                            for (int j = 0; j < count[i]; j++)
                                   arr[idx++] = radix[i][j];
                            count[i] = 0;
                     }
                     place *= 10;
              }
              System.out.print("Sorted array: ");
              for (int n : arr)
                     System.out.print(n + " ");
       }
}

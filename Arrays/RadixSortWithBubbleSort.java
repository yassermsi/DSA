public class RadixSortWithBubbleSort {
       public static void swap(int i, int j, int[] arr) {
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
       }

       public static void bubbleSort(int[] arr) {
              for (int i = 0; i < arr.length; i++) {
                     boolean swapped = false;
                     for (int j = 0; j < arr.length - i - 1; j++)
                            if (arr[j] > arr[j + 1]) {
                                   swap(j, j + 1, arr);
                                   swapped = true;
                            }
                     if (!swapped)
                            break;
              }
       }

       public static void radixSortWithBubbleSort(int[] arr) {
              int[][] radix = new int[10][arr.length];
              int[] count = new int[radix.length];
              int max = arr[0];
              for (int n : arr)
                     if (n > max)
                            max = n;
              int exp = 1, idx = 0;
              while (max / exp > 0) {
                     for (int n : arr) {
                            idx = (n / exp) % 10;
                            radix[idx][count[idx]++] = n;
                     }
                     for (int i = 0; i < radix.length; i++) {
                            int[] temp = new int[count[i]];
                            System.arraycopy(radix[i], 0, temp, 0, count[i]);
                            bubbleSort(temp);
                            System.arraycopy(temp, 0, radix[i], 0, count[i]);
                     }
                     int index = 0;
                     for (int i = 0; i < radix.length; i++) {
                            for (int j = 0; j < count[i]; j++)
                                   arr[index++] = radix[i][j];
                            count[i] = 0;
                     }
                     exp *= 10;
              }
       }

       public static void main(String[] args) {
              int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
              System.out.print("Original array: ");
              for (int n : arr)
                     System.out.print(n + " ");
              System.out.println();
              radixSortWithBubbleSort(arr);
              System.out.print("Sorted array: ");
              for (int n : arr)
                     System.out.print(n + " ");
              System.out.println();
       }
}

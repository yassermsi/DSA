public class CountingSort {
       public static void main(String[] args) {
              int[] arr = { 4, 2, 2, 6, 3, 3, 1, 6, 5, 2, 3 };
              int max = arr[0];
              for (int n : arr)
                     if (n > max)
                            max = n;
              int[] count = new int[max + 1];
              for (int n : arr)
                     count[n]++;
              int idx = 0;
              for (int i = 0; i < count.length; i++)
                     while (count[i] > 0) {
                            arr[idx++] = i;
                            count[i]--;
                     }
              System.out.print("Sorted array: ");
              for (int i : arr)
                     System.out.print(i + " ");
       }
}

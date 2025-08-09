public class SelectionSort {
       public static void main(String[] args) {
              int[] arr = { 7, 12, 9, 11, 3 };
              for (int i = 0; i < arr.length - 1; i++) {
                     int minIndex = i;
                     for (int j = i + 1; j < arr.length; j++)
                            if (arr[j] < arr[minIndex])
                                   minIndex = j;
                     if (minIndex != i) {
                            int temp = arr[i];
                            arr[i] = arr[minIndex];
                            arr[minIndex] = temp;
                     }
              }
              System.out.print("Sorted array: ");
              for (int i : arr)
                     System.out.print(i + " ");
       }
}

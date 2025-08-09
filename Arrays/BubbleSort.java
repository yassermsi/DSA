public class BubbleSort {
       public static void main(String[] args) {
              int[] arr = { 64, 34, 25, 12, 22, 11, 90, 5 };
              for (int i = 0; i < arr.length - 1; i++)
                     for (int j = i + 1; j < arr.length; j++)
                            if (arr[i] > arr[j]) {
                                   int temp = arr[i];
                                   arr[i] = arr[j];
                                   arr[j] = temp;
                            }
              System.out.print("Sorted array: ");
              for (int i : arr)
                     System.out.print(i + " ");
       }
}

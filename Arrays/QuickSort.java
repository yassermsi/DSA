public class QuickSort {
       public static void swap(int i, int j, int[] arr) {
              int temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
       }

       public static int partition(int l, int h, int[] arr) {
              int pivot = arr[h];
              int i = l - 1;
              for (int j = l; j < h; j++) {
                     if (arr[j] < pivot) {
                            i++;
                            swap(i, j, arr);
                     }
              }
              swap(i + 1, h, arr);
              return i + 1;
       }

       public static void quickSort(int l, int h, int[] arr) {
              if (l < h) {
                     int j = partition(l, h, arr);
                     quickSort(l, j - 1, arr);
                     quickSort(j + 1, h, arr);
              }
       }

       public static void main(String[] args) {
              int[] arr = { 7, 12, 9, 11, 3 };
              int h = arr.length - 1;
              quickSort(0, h, arr);
              System.out.print("Sorted Array: ");
              for (int i : arr) {
                     System.out.print(i + " ");
              }
       }
}
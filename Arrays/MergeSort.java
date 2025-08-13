import java.util.Arrays;

public class MergeSort {
       public static int[] merge(int[] left, int[] right) {
              int[] result = new int[left.length + right.length];
              int i = 0, j = 0, k = 0;
              while (i < left.length && j < right.length) {
                     if (left[i] < right[j]) {
                            result[k++] = left[i++];
                     } else {
                            result[k++] = right[j++];
                     }
              }
              while (i < left.length)
                     result[k++] = left[i++];
              while (j < right.length)
                     result[k++] = right[j++];
              return result;
       }

       public static int[] mergeSort(int[] arr) {
              if (arr.length <= 1)
                     return arr;
              int mid = arr.length / 2;
              int[] leftHalf = Arrays.copyOfRange(arr, 0, mid);
              int[] rightHalf = Arrays.copyOfRange(arr, mid, arr.length);
              int[] sortedLeft = mergeSort(leftHalf);
              int[] sortedRight = mergeSort(rightHalf);
              return merge(sortedLeft, sortedRight);
       }

       public static void main(String[] args) {
              int[] arr = { 12, 8, 9, 3, 11, 5, 4 };
              arr = mergeSort(arr);
              System.out.print("Sorted array: ");
              System.out.print(Arrays.toString(arr));
       }
}

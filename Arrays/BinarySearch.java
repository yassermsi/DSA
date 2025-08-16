public class BinarySearch {
       public static int binarySearch(int[] arr, int start, int end, int target) {
              if (start > end)
                     return -1;
              int mid = (start + end) / 2;
              if (arr[mid] > target)
                     return binarySearch(arr, start, mid - 1, target);
              else if (arr[mid] < target)
                     return binarySearch(arr, mid + 1, end, target);
              else
                     return mid;
       }

       public static void main(String[] args) {
              int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
              int target = 15;
              int result = binarySearch(arr, 0, arr.length, target);
              String res = (result != 1)
                            ? "Value " + Integer.toString(target) + " found at index " + Integer.toString(result)
                            : "Value " + String.valueOf(target) + " not found";
              System.out.println(res);
       }
}

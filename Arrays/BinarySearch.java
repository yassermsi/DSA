public class BinarySearch {
       public static int binarySearch(int[] arr, int target) {
              int start = 0, end = arr.length - 1;
              while (start < end) {
                     int mid = (start + end) / 2;
                     if (arr[mid] == target) {
                            return mid;
                     } else if (arr[mid] > target) {
                            end = mid - 1;
                     } else {
                            start = mid + 1;
                     }
              }
              return -1;
       }

       public static void main(String[] args) {
              int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
              int target = 15;
              int result = binarySearch(arr, target);
              String res = (result != 1)
                            ? "Value " + Integer.toString(target) + " found at index " + Integer.toString(result)
                            : "Value " + String.valueOf(target) + " not found";
              System.out.println(res);
       }
}

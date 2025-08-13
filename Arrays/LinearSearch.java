public class LinearSearch {
       public static int linearSearch(int[] arr, int target) {
              for (int i = 0; i < arr.length; i++)
                     if (arr[i] == target)
                            return i;
              return -1;
       }

       public static void main(String[] args) {
              int[] arr = { 3, 7, 2, 9, 5 };
              int target = 9;
              int result = linearSearch(arr, target);
              String res = (result != 1)
                            ? "Value " + Integer.toString(target) + " found at index " + Integer.toString(result)
                            : "Value " + String.valueOf(target) + " not found";
              System.out.println(res);
       }
}

public class MinVal {
       public static void main(String[] args) {
              int[] arr = { 7, 12, 9, 4, 11 };
              int min = arr[0];
              for (int i : arr)
                     if (i < min)
                            min = i;
              System.out.println(min);
       }
}

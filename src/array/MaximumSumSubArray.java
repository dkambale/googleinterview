package array;

public class MaximumSumSubArray {

  // kadanes algo
  // time complexity O(n)
  public static void main(String[] args) {
    int arr1[] = {4, 1, 1, -1, -3, -5, 6, 2, -6, -2};
    int k = 3;

    for (int c = 0; c < k; c++) {
      int max_so_far = Integer.MIN_VALUE;
      int max_here = 0;
      int start = 0, end = 0, s = 0;
      for (int i = 0; i < arr1.length; i++) {

        max_here += arr1[i];
        if (max_so_far < max_here) {
          max_so_far = max_here;
          start = s;
          end = i;
        }

        if (max_here < 0) {
          s = s + i;
          max_here = 0;

        }

      }
      System.out.println("Start:" + start + "End" + end + "Sum:" + max_so_far);
      for (int p=start;p<=end;p++) {
        arr1[p]=Integer.MIN_VALUE;
      }
    }
  }
}

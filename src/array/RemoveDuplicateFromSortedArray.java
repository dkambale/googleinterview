package array;

public class RemoveDuplicateFromSortedArray {

// O(n)
  public static void main(String[] args) {
    int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
    int n = arr.length;

    n = removeDuplicates(arr, n);

    // Print updated array
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  private static int removeDuplicates(int[] arr, int n) {
    if (arr.length == 1) {
      return 1;
    }
    int slow = 0;
    int fast = 1;
    for (; fast < n; fast++) {
      while (fast < arr.length && arr[slow] == arr[fast]) {
        fast++;
      }
      if(fast<n) {
        arr[++slow] = arr[fast];
      }
    }
    return slow + 1;
  }
}

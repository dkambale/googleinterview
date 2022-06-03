package array;

public class BinarySearch {

  //logn
  public static void main(String[] args) {

    int arr1[] = {1,2,3,4,5,6,7,9};

    int found = binarySearch(arr1, 0, arr1.length - 1, 7);
    System.out.print(found);
  }

  private static int binarySearch(int[] arr1, int low, int high, int n) {
    if (low <= high) {

      int mid = low + (high - low) / 2;
      if (arr1[mid] == n) {
        return mid;
      }
      if(n<arr1[mid]) {
        return binarySearch(arr1,low,mid,n);
      } else {
        return binarySearch(arr1,mid+1,high,n);
      }
    } else {
      return -1;
    }
  }
}

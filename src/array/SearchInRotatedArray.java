package array;

public class SearchInRotatedArray {

 // time complexcity O(log(n))

  public static void main(String[] args) {
    // Let us search 3 in below array
    int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    int n = arr1.length;
    int key = 4;
    System.out.println("Index of the element is : "
        + pivotedBinarySearch(arr1, n, key));
  }

  private static int pivotedBinarySearch(int[] arr1, int n, int key) {

    int pivot = getPivot(arr1, n);
    System.out.println("pivot:" + arr1[pivot]);
    int index = binarySearch(arr1, 0, pivot, n, key);
    return index;
  }


  private static int binarySearch(int[] arr1, int i, int pivot, int n, int key) {

    if (arr1[pivot] == key) {
      return pivot;
    }
    int search = -1;
    if (arr1[pivot] < key) {
      return search;
    }
    if (arr1[0] < key) {

      return binarySearchForKey(arr1, i, pivot, key);
    } else {
      return binarySearchForKey(arr1, pivot + 1, n, key);
    }
  }

  private static int binarySearchForKey(int[] arr1, int s, int e, int key) {

    int mid = s + (e - s) / 2;
    if (arr1[mid] == key) {
      return mid;
    }
    if (arr1[mid] > key) {
      return binarySearchForKey(arr1, s, mid - 1, key);
    } else {
      return binarySearchForKey(arr1, mid + 1, e, key);
    }
  }

  private static int getPivot(int[] arr1, int n) {
    int pivot = 0;
    int i = 1;
    for (; i < n; i++) {
      if (arr1[i - 1] > arr1[i]) {
        break;
      }
    }

    return i - 1;
  }
}

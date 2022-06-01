package array;

public class FindtheSmallestMissingNumber {

  public static void main(String[] args) {
    int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
    int n=11;
    for(int i=0;i<arr.length;i++) {

      if(arr[i]!=i) {
        if(i<n) {
          System.out.print(i);
          break;
        }
      }
    }

  }
}

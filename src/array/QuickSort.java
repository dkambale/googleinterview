package array;

public class QuickSort {
// nlogn
  public static void main(String[] args) {
    int[] arr = { 10, 7, 8, 9, 1, 5 };
    int n = arr.length;
    quickSort(arr, 0, n - 1);

    for(int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
  }

  private static void quickSort(int[] arr, int low, int high) {

    if(low<high) {

      int pivot=partion(arr,low,high);

      quickSort(arr,low,pivot-1);
      quickSort(arr,pivot+1,high);
    }

  }

  private static int partion(int[] arr, int low, int high) {

    int pivot=arr[high];
        int i=low-1;
    for (int j=low;j<=high-1;j++) {

      if(arr[j]<pivot) {
        i++;
        swap(arr,i,j);
      }


    }
    swap(arr,i+1,high);
    return (i+1);
  }

  static void swap(int[] arr, int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}

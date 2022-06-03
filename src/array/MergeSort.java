package array;

public class MergeSort {

  // nlogn
  // k=s
  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6, 7};

    mergeSort(arr, 0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.println("  " + arr[i]);
    }
  }

  private static void mergeSort(int[] arr, int s, int e) {

    if (s < e) {
      int mid = s + (e - s) / 2;
      mergeSort(arr, s, mid);
      mergeSort(arr, mid + 1, e);
      sort(arr, s, mid, e);
    }
  }

  private static void sort(int[] arr, int s, int mid, int e) {

    int n1 = mid - s + 1;
    int n2 = e - mid;
    int tmp1[] = new int[n1];
    int tmp2[] = new int[n2];

    for (int i = 0; i < n1; i++) {
      tmp1[i] = arr[s+i];
    }

    for (int j = 0; j < n2; j++) {
      tmp2[j] = arr[mid+1+j];
    }
    int i=0,j=0;
    int k=s;
    while(i<n1 &&j<n2) {

      if(tmp1[i]<=tmp2[j]) {
        arr[k]=tmp1[i];
        i++;
      } else {
        arr[k]=tmp2[j];
        j++;
      }
      k++;
    }
    while(i<n1) {
      arr[k]=tmp1[i];
      i++;
      k++;
    }
    while(j<n2) {
      arr[k]=tmp2[j];
      j++;
      k++;
    }
  }

}

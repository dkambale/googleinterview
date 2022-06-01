package heap;

public class MeanHeap {

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = arr.length;

    MeanHeap ob = new MeanHeap();
    ob.sort(arr);

    System.out.println("Sorted array is");
    for (int num:arr) {
      System.out.print(" "+num);
    }
  }

  private void sort(int[] arr) {
    int n=arr.length;
    for(int i=(n/2)-1;i>=0;i--) {
      heapyFy(arr,i,n);
    }

//    for(int j=n-1;j>0;j--) {
//      int temp = arr[0];
//      arr[0] = arr[j];
//      arr[j] = temp;
//      heapyFy(arr,0,j);
//    }

    for(int j=n-1;j>=0;j--) {
      int temp = arr[j];
      arr[j] = arr[0];
      arr[0] = temp;
      heapyFy(arr,j,n);
    }
  }

  private void heapyFy(int[] arr, int i, int n) {
    int l=i*2+1;
    int r=i*2+2;
    int min=i;
    if(l<n && arr[l]<arr[i]) {
      min=l;
    }
    if(r<n && arr[r]<arr[min]) {
      min=r;
    }
    if(min!=i) {
      int tmp=arr[i];
      arr[i]=arr[min];
      arr[min]=tmp;
      heapyFy(arr,min,n);
    }
  }
}

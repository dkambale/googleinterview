package array;

public class BubbleSort {

  public static void main(String[] args) {
    int arr[] = {12, 11, 13, 5, 6, 7};

    for(int i=0;i<arr.length;i++) {
      for (int j=0;j<arr.length-i-1;j++) {
        if(arr[j]>arr[j+1]) {
          int tmp=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=tmp;
        }
      }
    }
    for (int i=0;i<arr.length;i++) {
      System.out.println(arr[i]);
    }
  }
}

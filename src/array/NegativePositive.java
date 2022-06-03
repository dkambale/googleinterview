package array;

public class NegativePositive {
// n/2 number or nlogn
  public static void main(String[] args) {
    int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};

    int i=-1;
    int tmp=0;
    for(int j=0;j<arr.length;j++) {
      if(arr[j]<0) {
        i++;
        tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
      }
    }
    for (int j=0;j<arr.length;j++) {
      System.out.print(arr[j]);
    }
  }
}

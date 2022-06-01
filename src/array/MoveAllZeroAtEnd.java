package array;

public class MoveAllZeroAtEnd {

  public static void main(String[] args) {

    int arr[] = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};

    int zeroCount=0;

    int s=0;
    int e=arr.length-1;
    int tmp=0;
    while(s<e) {
      if(arr[s]==0 && arr[e]>0) {
        tmp=arr[s];
        arr[s]=arr[e];
        arr[e]=tmp;
      }
      if(arr[s]>0) {
        s ++;
      }
      if(arr[e]==0) {
        e--;
      }

    }
    for(int a:arr) {
      System.out.print(a+" ");
    }
  }
}

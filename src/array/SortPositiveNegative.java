package array;

public class SortPositiveNegative {

  // n/2 time complexity
  public static void main(String[] args) {
    int arr[] = { 1, 10, 2, -10, -20 };
    int s=0;
    int e=arr.length-1;

    while(s<=e) {
      if(arr[s]>0 && arr[e]<0) {
        int tmp=arr[s];
        arr[s]=arr[e];
        arr[e]=tmp;
        s++;
        e--;
      } else if (arr[s]<0) {
        s++;
      } else if(arr[e]>0) {
        e--;
      }
    }
    for(int a:arr) {
      System.out.print(" "+a);
    }
  }
}

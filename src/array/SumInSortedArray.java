package array;

public class SumInSortedArray {

  public static void main(String[] args) {
    int a[] = {6, 7, 9, 10,11, 15};

    int sum=18;
    int statr=0;
    int end=a.length-1;
    while(statr<end) {
      int s=a[statr] +a[end];
      if(s==sum) {
        System.out.print("Pair:"+statr+":"+end);
      }
      if(s>sum) {
        end--;
      } else  {
        statr++;
      }
    }
  }

}

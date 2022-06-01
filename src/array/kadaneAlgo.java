package array;

public class kadaneAlgo {

  // tim complexity n
  public static void main(String[] args) {
    int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};

    int max_value=0;
    int max_so_far=Integer.MIN_VALUE;
    int start=0, end=0,s=0;
    for(int i=0;i<a.length;i++) {

      max_value+=a[i];
      if(max_value>max_so_far) {
        max_so_far=max_value;
        end=i;
        start=s;
      }
      if(max_value<0) {
        s=s+1;
        max_value=0;
      }
    }
    System.out.print("Max Value:"+max_so_far);
  }
}

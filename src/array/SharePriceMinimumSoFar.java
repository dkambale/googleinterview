package array;

public class SharePriceMinimumSoFar {

  public static void main(String[] args) {

    int[] ss = {3, 5, 1, 7, 4, 9, 3};
    int min_so=ss[0];
    int max_pro=0;

    for(int i=0;i<ss.length;i++) {

      if(min_so> ss[i]) {
        min_so=ss[i];
        System.out.println(min_so);
      }
      max_pro=Math.max(max_pro,ss[i]-min_so);
    }

    System.out.println(max_pro);

  }

}

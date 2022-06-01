package array;

public class ShareProfitOne {


  public static void main(String[] args) {

    int[] ss = {3, 5, 1, 7, 4, 9, 3};
    int max = 0;

    for (int i = 0; i < ss.length; i++) {
      int buy = ss[i];
      int sell = ss[i];
      for (int j = 1 + 1; j < ss.length; j++) {
        if (ss[j] > sell) {
          sell = ss[j];
        }
      }
      max=Math.max(max,sell-buy);
    }

    System.out.println(max);
  }
}

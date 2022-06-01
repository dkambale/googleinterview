package dp;

import java.util.ArrayList;
import java.util.List;

public class MinimumNofCoins {

  public static void main(String[] args) {

     int demo[] = {1, 2, 5, 10, 20,
        50, 100, 500, 1000};
     int n = demo.length;
    List<Integer> minimumCoins=getMin(demo,n,93);

    for(int i=0;i<minimumCoins.size();i++) {
      System.out.print( " " +minimumCoins.get(i));
    }

  }

  private static List<Integer> getMin(int[] demo, int n,int w) {

    List<Integer> list=new ArrayList<>();
    for(int i=n-1;i>=0;i--) {

      while(w>=demo[i] &&w>0) {
        list.add(demo[i]);
        w=w-demo[i];
      }
    }

    return list;
  }
}

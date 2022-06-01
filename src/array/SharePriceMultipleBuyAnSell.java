package array;

import java.util.LinkedList;
import java.util.Queue;
import tree.TreeNode;

public class SharePriceMultipleBuyAnSell {


  public static void main(String[] args) {
    int[] ss = {3, 5, 1, 7, 4, 9, 3};

    int max_pr = 0;
    for (int i = 1; i < ss.length; i++) {

      if (ss[i - 1] < ss[i]) {
        max_pr = max_pr + (ss[i] - ss[i - 1]);
      }

    }
    System.out.println(max_pr);

  }


}

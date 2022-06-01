package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralArray {


  public static void main(String[] args) {
    int a[][] = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };

    System.out.println(spiralOrder(a).toString());
  }

  private static List<Integer> spiralOrder(int[][] a) {
    List<Integer> list=new ArrayList<>();
    int sc=0;
    int ec=a[0].length-1;
    int sr=0;
    int er=a.length-1;
    while(sc<ec && sr<er) {

      // printing first row
      for(int i=sc;i<=ec;i++) {
        System.out.print(" "+a[sr][i]);
      }
      sr++;
      // printing last col
      for(int i=sr;i<=er;i++) {
        System.out.print(" "+a[i][ec]);
      }
      ec--;

      //printing last row
      for(int i=ec ;i>=sc;i--) {
        System.out.print(" "+a[er][i]);
      }
      er--;
      // printing first column
      for(int i=er;i>=sr;i--) {
        System.out.print(" "+a[i][sc]);
      }
      sc++;
    }
    return list;
  }
}

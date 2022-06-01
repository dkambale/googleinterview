package array;

import java.util.Arrays;

public class ZigZagConvertion {

  public static void main(String[] args) {
    String str = "GEEKSFORGEEKS";
    int n = 3;
    printZigZagConcat(str, n);

  }

  private static void printZigZagConcat(String str, int n) {

    boolean down= true;
    int row=0;
    char [] str1=str.toCharArray();
    String [] arr=new String[n];
    Arrays.fill(arr, "");
    for(int i=0;i<str.length();i++) {

      arr[row]+=str1[i];
      if(row==n-1) {
        down=false;
      }
      if(row==0) {
        down=true;
      }
      if (down)
      {
        row++;
      }
      else
      {
        row--;
      }
    }

    String ss="";
    for (int i=0;i<arr.length;i++) {
      ss=ss+arr[i];
    }

    System.out.println(ss);

  }
}

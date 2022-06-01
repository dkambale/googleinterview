package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfString {

  public static void main(String[] args) {

    String str = "abc";

    printAllPermutation(str, 0, str.length() - 1);
  }

  private static void printAllPermutation(String str, int l, int r) {

    if(l==r) {
      System.out.println(str);
    } else {

      for(int i=l;i<=r;i++) {
        str=swap(str,l,i);
        printAllPermutation(str,l+1,r);
        str=swap(str,l,i);
        int max_so=Integer.MIN_VALUE;
      }
    }
  }

  private static String swap(String str, int l, int i) {
    char[] chrs= str.toCharArray();
    char temp=chrs[l];
    chrs[l]=chrs[i];
    chrs[i]=temp;

    return new String(chrs);
  }


}

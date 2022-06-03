package dp;

import java.util.ArrayList;
import java.util.List;

public class KMP_String_Matching {

  public static void main(String[] args) {

    String text = "abcafabcd";
    String pat = "abcaf";

    List<Integer> allMacthedIndex = new ArrayList<>();
    matchFound(text, pat, allMacthedIndex);


  }

  private static void matchFound(String text, String pat, List<Integer> allMacthedIndex) {

    int[] pre = new int[pat.length()];
    lps(pre, pat);
    System.out.println(pre);
    int j = 0;
    int i = 0;
    while (j < text.length()) {

      if (text.charAt(j) == pat.charAt(i)) {
        j++;
        i++;
      }
      if (i == pat.length()) {
        System.out.println("Found matching:" + j);
        i = pre[i - 1];
        allMacthedIndex.add(j);
      } else if (j < text.length() && text.charAt(j) != pat.charAt(i)) {
        if (i != 0) {
          i = pre[i - 1];
        } else {
          j++;
        }
      }


    }

  }

  private static void lps(int[] pre, String pat) {

    int l = 0;
    pre[0] = l;
    int i = 1;
    for (; i < pat.length(); ) {
      if (pre[i] == pat.charAt(l)) {
        l++;
        pre[i] = l;
        i++;
      } else {
        if (l != 0) {
          pre[i] = pre[l - 1];
        } else {
          pre[i] = l;
          i++;
        }
      }
    }
  }
}

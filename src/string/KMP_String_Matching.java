package string;

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
    computeLPSArray(pat,pat.length(),pre);
    System.out.println(pre);
    int j = 0;
    int i = 0;
    while (j < text.length()) {

      if (text.charAt(j) == pat.charAt(i)) {
        j++;
        i++;
      }
      if (i == pat.length()) {
        System.out.println("Found matching:" + (j-i));
        i = pre[i - 1];
        allMacthedIndex.add(j-i);
      } else if (j < text.length() && text.charAt(j) != pat.charAt(i)) {
        if (i != 0) {
          i = pre[i - 1];
        } else {
          j++;
        }
      }


    }

  }

  static void computeLPSArray(String pat, int M, int lps[])
  {
    // length of the previous longest prefix suffix
    int len = 0;
    int i = 1;
    lps[0] = 0; // lps[0] is always 0

    // the loop calculates lps[i] for i = 1 to M-1
    while (i < M) {
      if (pat.charAt(i) == pat.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      }
      else // (pat[i] != pat[len])
      {
        // This is tricky. Consider the example.
        // AAACAAAA and i = 7. The idea is similar
        // to search step.
        if (len != 0) {
          len = lps[len - 1];

          // Also, note that we do not increment
          // i here
        }
        else // if (len == 0)
        {
          lps[i] = len;
          i++;
        }
      }
    }
  }
}

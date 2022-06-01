package array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

  public static void main(String[] args) {

    String input = "abcabcbb";
    Set<Character> chars = new HashSet<>();
    int s = 0;
    int max_so_far = 0;
    int arrStart=0;
        int arrEnd=0;
    for (int i = 0; i < input.length(); i++) {

      if (!chars.contains(input.charAt(i))) {
        chars.add(input.charAt(i));
      } else {
        int size = chars.size();
        if (max_so_far < size) {
          max_so_far = size;
          arrStart=s;
          arrEnd=i;
        }
        chars.clear();
        s=s+1;
        i=s;
      }
    }
    System.out.println("max_length:"+max_so_far +"s:"+arrStart+"e"+(arrEnd-1));
  }
}

package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckIsAtAofIPosition {

  public static void main(String[] args) {
    int A[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};

    Set<Integer> set = new HashSet<>();
    for (int a : A) {
      set.add(a);
    }
    for(int i=0;i<A.length;i++) {
      if(set.contains(i)) {
        A[i]=i;
      } else {
        A[i]=-1;
      }
    }
    for(int a:A) {
      System.out.print(a +"  ");
    }
  }
}

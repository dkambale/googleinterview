package array;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class SubSequenceArray {

  // time complexity 2^n
  public static void main(String[] args) {

    int a[] = {1,2,3};
    int[] ss = new int[a.length];
    printAllSubSequence(a, 0, 0, ss);
  }

  private static void printAllSubSequence(int[] a, int s, int ssi, int[] ss) {

    if (s == a.length) {
       printArray(ss, ssi);
      return;
    }

    printAllSubSequence(a,s+1,ssi,ss);
    ss[ssi]=a[s];
    printAllSubSequence(a,s+1,ssi+1,ss);
  }

  private static void printArray(int[] ss, int ssi) {
    for (int i = 0; i < ssi; i++) {
      System.out.print(" "+ss[i]);
    }
    System.out.println();
  }
}

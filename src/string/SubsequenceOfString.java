package string;

import java.util.Map;

public class SubsequenceOfString {

  public static void main(String[] args) {
    String ss="abc";
    printAllSubsequence(ss ,"");
  }

  private static void printAllSubsequence(String ss, String s) {

    if(ss.length()==0) {
      System.out.println(s);
      return ;
    }
    printAllSubsequence(ss.substring(1),s+ss.charAt(0));
    printAllSubsequence(ss.substring(1),s);
  }
}

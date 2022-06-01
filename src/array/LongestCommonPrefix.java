package array;

import java.util.Arrays;

public class LongestCommonPrefix {

  public static void main(String[] args) {

    String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
     Arrays.sort(input);
     int small=input[0].length();
    int i=0;
    boolean breakLine=false;
     for (;i<small;i++) {

       char c=input[i].charAt(i);

       for (int j=1;j<input.length;j++) {
         if(input[j].charAt(i)!=c) {
           System.out.println(i);
           breakLine=true;
           break;
         }
       }
       if(breakLine) {
         break;
       }
     }

     for (int j=0;j<i;j++) {
       System.out.print(input[0].charAt(j));
     }

  }

}

package string;

public class ReverseUsingRecursion {

  public static void main(String[] args) {

    String re=reverseString("Dadasaheb");

    System.out.println(re);
  }

  private static String reverseString(String s) {
    if(s.length()==1 || s==null || s=="")
    {
      return s;
    }
    return s.substring(s.length()-1)+reverseString(s.substring(0,s.length()-1));
  }
}

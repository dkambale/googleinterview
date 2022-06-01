package string;

public class ReMoveDuplicate {

  public static void main(String[] args) {
    String ss="geekforgeek";

    char [] array=removeDuplicate(ss.toCharArray());
    System.out.println(new String(array));
  }

  private  static char[]   removeDuplicate(char[] ss) {

    int index=0;
    for(int i=0;i<ss.length;i++) {
      int j=0;
      for(;j<ss.length;j++){

        if(ss[i]==ss[j]) {
          break;
        }
      }
      if(i==j) {
        ss[index]=ss[i];
        index++;
      }
    }
    return ss;
  }
}

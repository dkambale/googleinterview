package tree;

public class NoOfUniqueBST {
  public static  int [] dp=new int[20];
  public static void main(String[] args) {
    int c=3;

    int noOfBst=bstCount(c);
    System.out.println("====>"+noOfBst);
  }

  private static int bstCount(int c) {

    if(c<=1) {
      return 1;
    }
    if(dp[c]>0) {
      return dp[c];
    }
    for(int i=1;i<=c;i++) {
      dp[c] +=bstCount(i-1) * bstCount(c-i);
    }

    return dp[c];
  }
}

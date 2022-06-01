package string;

public class LongestCommonSubsequence {

  // GTAB
  public static void main(String[] args) {
    String x = "AGGTAB";
    String y = "GXTXAYB";
    int m = x.length();
    int n = y.length();

    lcs(x,y,m,n);
  }

  private static void lcs(String x, String y, int m, int n) {

    int [][] pre=new int[m+1][n+1];

    for(int i=0;i<=m;i++) {
      for(int j=0;j<=n;j++) {

        if(i==0 || j==0) {
          pre[i][j]=0;
        } else {

          if(x.charAt(i-1)==y.charAt(j-1)) {
            pre[i][j]= pre[i-1][j-1]+1;
          } else {
            pre[i][j]= Math.max(pre[i-1][j],pre[i][j-1]);
          }
        }
      }
    }

    System.out.println(pre[m][n]);

    int index=pre[m][n];
    int temp=index;
    char[] lcs = new char[index + 1];
    lcs[index]
        = '\u0000'; // Set the terminating character

    // Start from the right-most-bottom-most corner and
    // one by one store characters in lcs[]
    int i = m;
    int j = n;
    while (i > 0 && j > 0) {
      // If current character in X[] and Y are same,
      // then current character is part of LCS
      if (x.charAt(i - 1) == y.charAt(j - 1)) {
        // Put current character in result
        lcs[index - 1] = x.charAt(i - 1);

        // reduce values of i, j and index
        i--;
        j--;
        index--;
      }

      // If not same, then find the larger of two and
      // go in the direction of larger value
      else if (pre[i - 1][j] > pre[i][j - 1])
        i--;
      else
        j--;
    }

    // Print the lcs
    System.out.print("LCS of " + x + " and " + y
        + " is ");
    for (int k = 0; k < temp; k++)
      System.out.print(lcs[k]);

  }
}

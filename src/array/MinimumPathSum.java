package array;

public class MinimumPathSum {
//time complexity its visiting each and every node hence O(m * n)
  public static void main(String[] args) {
    int cost[][] = { {1,3,1},
        {1,5,1},
        {4,2,1} };
    MinimumPathSum sum=new MinimumPathSum();
    System.out.print(sum.getMinPath(cost, 2, 2));
  }

  public int getMinPath(int[][] grid,int n,int m) {
    if(n<0|| m<0) {
      return Integer.MAX_VALUE;
    }
    if(n==0 && m==0) {
      return grid[n][m];
    } else {

      return grid[n][m]+ min(getMinPath(grid,n-1,m-1),
          getMinPath(grid,n,m-1),
          getMinPath(grid,n-1,m));
    }
  }

  public int min(int n1,int n2,int n3){

    int min=Math.min(n1,n2);
    min=Math.min(min,n3);
    return min;
  }
}

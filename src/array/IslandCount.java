package array;

public class IslandCount {
//O(ROW x COL)
public static int col=0;
  public static int row=0;
  public static void main(String[] args) throws java.lang.Exception {
    int M[][] = new int[][]{{1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}};
    row=M.length;
    col=M[0].length;

    System.out.println("Number of islands is: " + countIslands(M));
  }

  private static int countIslands(int[][] m) {
    int count=0;
    int n1=m.length;
    int n2=m[0].length;
    boolean [][]visit=new boolean[n1][n2];

    for(int i=0;i<n1;i++) {
      for(int j=0;j<n2;j++) {
        if(m[i][j]==1 && !visit[i][j]) {

          Dfs(m,i,j,visit);
          count++;

        }
      }
    }
    return count;
  }

  private static void Dfs(int[][] m, int i, int j,boolean [][]visit) {

    visit[i][j]=true;
    int row[]=new int[] {-1,-1,-1,0,0,1,1,1};
    int col[]=new int[]{-1,0,1,-1,1,-1,0,1};
    for(int k=0;k<8;k++) {
      if(isSafe(m,i+row[k],j+col[k],visit)) {
        Dfs(m,i+row[k],j+col[k],visit);
      }
    }

  }

  private static boolean isSafe(int[][] m, int i, int j,boolean [][]visit) {

    if(i>=0 && i<row && j>=0 &&j<col && !visit[i][j] &&m[i][j]==1 ) {
      return true;
    }
    return false;
  }
}

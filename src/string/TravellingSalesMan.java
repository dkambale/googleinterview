package string;

public class TravellingSalesMan {

  public static void main(String[] args) {
    int[][] graph = {{0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}};

    // Boolean array to check if a node
    // has been visited or not
    boolean[] flag = new boolean[graph.length];

    // Mark 0th node as visited
    flag[0] = true;
    int ans = Integer.MAX_VALUE;
    int currPos=0;
    int total=graph.length;
    int count=1;
    int cost=0;
    int minimumAmount=getMinimumPath(graph,flag,currPos,total,count,cost,ans);
    System.out.println("Minimum Cost:"+minimumAmount);

  }

  private static int getMinimumPath(int[][] graph, boolean[] flag, int currPos, int total, int count, int cost,
      int ans) {

    if(count==total && graph[currPos][0] >0) {
      ans =Math.min(ans, cost+graph[currPos][0]);
      return ans;
    }
    for(int i=0;i<total;i++) {
      if(flag[i]==false && graph[currPos][i]>0) {
        flag[i]=true;
        ans =getMinimumPath(graph,flag,i,total,count+1,cost+graph[currPos][i],ans);

        flag[i]=false;
      }
    }
    return ans;
  }
}

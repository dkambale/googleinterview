package dp;

public class SpaningTreePrims {


  public static void main(String[] args) {
    /* Let us create the example graph discussed above */
    int graph[][] = new int[][]{ { 0, 2, 0, 6, 0 },
        { 2, 0, 3, 8, 5 },
        { 0, 3, 0, 0, 7 },
        { 6, 8, 0, 0, 9 },
        { 0, 5, 7, 9, 0 } };
    SpaningTreePrims t = new SpaningTreePrims();
    int result[] = t.minimumSpaning(graph, 0);
    for (int i = 0; i < result.length; i++) {
      System.out.println("  " + result[i]);
    }
  }

  private int[] minimumSpaning(int[][] graph, int s) {
    int V = graph.length;
    int dist[] = new int[V];
    boolean sp[] = new boolean[V];

    for (int i = 0; i < V; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    for (int i = 0; i < V; i++) {
      sp[i] = false;
    }

    dist[s] = 0;
    for (int i = 0; i < V; i++) {

      int u = getMiniDistanceIndex(dist, sp, i);
      if (u == -1) {
        continue;
      }
      sp[u] = true;
      for (int j = 0; j < V; j++) {

        if (graph[u][j] != 0 && sp[j] == false && graph[u][j] < dist[j]) {
          dist[j] = graph[u][j];
        }
      }

    }
    return dist;
  }

  private int getMiniDistanceIndex(int dist[], boolean sp[], int u) {
    int min = Integer.MAX_VALUE;
    int minIndex = -1;

    for (int i = 0; i < dist.length; i++) {

      if (dist[i] < min && sp[i] == false) {
        min = dist[i];
        minIndex = i;
      }
    }
    return minIndex;
  }
}

package dp;

public class Dijkstra {


  public static void main(String[] args) {
    /* Let us create the example graph discussed above */
    int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}};
    Dijkstra t = new Dijkstra();
    int result[] = t.dijkstra(graph, 0);
    for (int i = 0; i < result.length; i++) {
      System.out.println("  " + result[i]);
    }
  }

  private int[] dijkstra(int[][] graph, int s) {
    int V = graph.length;
    int dist[] = new int[graph.length];

    Boolean sptSet[] = new Boolean[V];
    for (int i = 0; i < dist.length; i++) {
      dist[i] = Integer.MAX_VALUE;
      sptSet[i] = false;
    }

    dist[s] = 0;

    for (int c = 0; c < V; c++) {

      // Pick the minimum distance vertex from the set of vertices
      // not yet processed. u is always equal to src in first
      // iteration.
      int u = getMinVertex(dist, sptSet);
      if (u == -1) {
        continue;
      }
      sptSet[u] = true;
      //update all distances

      // Update dist[v] only if is not in sptSet, there is an
      // edge from u to v, and total weight of path from src to
      // v through u is smaller than current value of dist[v]
      for (int i = 0; i < V; i++) {

        if (graph[u][i] != 0 && sptSet[i] == false && dist[u] != Integer.MAX_VALUE &&
            dist[u] + graph[u][i] < dist[i]) {
          dist[i] = dist[u] + graph[u][i];
        }

      }

    }

    return dist;
  }

  // A utility function to find the vertex with minimum distance value,
  // from the set of vertices not yet included in shortest path tree
  private int getMinVertex(int[] dist, Boolean[] sptSet) {

    int min = Integer.MAX_VALUE;
    int min_index = -1;
    for (int i = 0; i < dist.length; i++) {

      if (dist[i] < min && sptSet[i] == false) {
        min = dist[i];
        min_index = i;

      }
    }
    return min_index;
  }
}

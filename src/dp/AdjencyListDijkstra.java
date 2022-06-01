package dp;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AdjencyListDijkstra {

  static class AdjListNode {

    int vertex, weight;

    AdjListNode(int v, int w) {
      vertex = v;
      weight = w;
    }

    int getVertex() {
      return vertex;
    }

    int getWeight() {
      return weight;
    }
  }

  public static void main(String[] args) {
    int V = 9;
    ArrayList<ArrayList<AdjListNode>> graph
        = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }
    int source = 0;
    graph.get(0).add(new AdjListNode(1, 4));
    graph.get(0).add(new AdjListNode(7, 8));
    graph.get(1).add(new AdjListNode(2, 8));
    graph.get(1).add(new AdjListNode(7, 11));
    graph.get(1).add(new AdjListNode(0, 7));
    graph.get(2).add(new AdjListNode(1, 8));
    graph.get(2).add(new AdjListNode(3, 7));
    graph.get(2).add(new AdjListNode(8, 2));
    graph.get(2).add(new AdjListNode(5, 4));
    graph.get(3).add(new AdjListNode(2, 7));
    graph.get(3).add(new AdjListNode(4, 9));
    graph.get(3).add(new AdjListNode(5, 14));
    graph.get(4).add(new AdjListNode(3, 9));
    graph.get(4).add(new AdjListNode(5, 10));
    graph.get(5).add(new AdjListNode(4, 10));
    graph.get(5).add(new AdjListNode(6, 2));
    graph.get(6).add(new AdjListNode(5, 2));
    graph.get(6).add(new AdjListNode(7, 1));
    graph.get(6).add(new AdjListNode(8, 6));
    graph.get(7).add(new AdjListNode(0, 8));
    graph.get(7).add(new AdjListNode(1, 11));
    graph.get(7).add(new AdjListNode(6, 1));
    graph.get(7).add(new AdjListNode(8, 7));
    graph.get(8).add(new AdjListNode(2, 2));
    graph.get(8).add(new AdjListNode(6, 6));
    graph.get(8).add(new AdjListNode(7, 1));

    int[] distance = dijkstra(V, graph, source);
    // Printing the Output
    System.out.println("Vertex  "
        + "  Distance from Source");
    for (int i = 0; i < V; i++) {
      System.out.println(i + "             "
          + distance[i]);
    }
  }

  private static int[] dijkstra(int v, ArrayList<ArrayList<AdjListNode>> graph, int s) {
    int dist[] = new int[v];
    for (int i = 0; i < v; i++) {
      dist[i] = Integer.MAX_VALUE;
    }
    dist[s] = 0;
    PriorityQueue<AdjListNode> heap = new PriorityQueue<AdjListNode>((o1, o2) -> o1.weight - o2.weight);

    heap.add(new AdjListNode(s, 0));

    while (!heap.isEmpty()) {
      AdjListNode node = heap.poll();
      List<AdjListNode> adjListNodes = graph.get(node.getVertex());
      for (AdjListNode n : adjListNodes) {

        if (dist[node.vertex] + n.getWeight() < dist[n.vertex]) {
          dist[n.vertex] = dist[node.vertex] + n.getWeight();
          heap.add(n);
        }
      }

    }

    return dist;
  }
}

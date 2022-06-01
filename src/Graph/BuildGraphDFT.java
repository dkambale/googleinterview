package Graph;

import java.util.Stack;

public class BuildGraphDFT {

  Graph graph = new Graph();

  public static void main(String[] args) {

    BuildGraphDFT buildGraphDFT = new BuildGraphDFT();
    buildGraphDFT.graph.addVertex('a'); //0
    buildGraphDFT.graph.addVertex('b'); //1
    buildGraphDFT.graph.addVertex('c'); //2
    buildGraphDFT.graph.addVertex('d'); //3
    buildGraphDFT.graph.addVertex('e'); //4
    buildGraphDFT.graph.addVertex('f'); //5
    buildGraphDFT.graph.addVertex('g'); //6
    buildGraphDFT.graph.addVertex('h'); //7

    buildGraphDFT.graph.addEdge(0, 1);
    buildGraphDFT.graph.addEdge(1, 2);
    buildGraphDFT.graph.addEdge(2, 4);
    buildGraphDFT.graph.addEdge(2, 3);
    buildGraphDFT.graph.addEdge(1, 7);
    buildGraphDFT.graph.addEdge(7, 4);
    buildGraphDFT.graph.addEdge(4, 6);
    buildGraphDFT.graph.addEdge(4, 5);

    buildGraphDFT.graph.dfs();

  }

  public class Graph {

    int maxCount = 20;
    Stack<Integer> stack;
    int adjMatrix[][];
    Vertex[] vertices;
    int vertexCount;

    public Graph() {
      this.maxCount = 20;
      this.stack = new Stack<>();
      this.adjMatrix = new int[maxCount][maxCount];
      this.vertices = new Vertex[maxCount];
      this.vertexCount = 0;
    }

    public int addVertex(char data) {
      Vertex v1 = new Vertex(data);
      vertices[vertexCount] = v1;
      vertexCount++;
      return vertexCount;
    }

    public void addEdge(int start, int end) {
      this.adjMatrix[start][end] = 1;
    }

    public void dfs() {
      Vertex v1 = vertices[0];
      System.out.print(" " + v1.lable);
      v1.visisted = true;
      stack.push(0);
      while (!stack.isEmpty()) {
        int curr = stack.peek();
        System.out.println("Visited position:" + vertices[curr].lable);
        int v2 = getAdjustVertex(curr);
        if (v2 == -1) {
          stack.pop();
        } else {
          stack.push(v2);
          vertices[v2].visisted=true;
        }
      }
    }

    private int getAdjustVertex(int curr) {

      for (int j = 0; j < vertexCount; j++) {
        if (adjMatrix[curr][j] == 1 && vertices[j].visisted == false) {
          return j;
        }
      }
      return -1;
    }

  }


  public class Vertex {

    char lable;
    boolean visisted;

    Vertex(char lable) {
      this.lable = lable;
      this.visisted = false;
    }
  }
}

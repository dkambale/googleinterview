package Graph;

import Graph.BuildGraphDFT.Graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BsfGraphTravel {
  Graph graph=new Graph();
  public class Vertex {

    char lable;
    boolean visisted;

    Vertex(char lable) {
      this.lable = lable;
      this.visisted = false;
    }
  }
  public class Graph {

    int maxCount = 20;
    Queue<Integer> queue;
    int adjMatrix[][];
    Vertex[] vertices;
    int vertexCount;

    public Graph() {
      this.maxCount = 20;
      this.queue = new LinkedList<>();
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


    public void  bfs() {
      Vertex vertex=vertices[0];
      queue.add(0);
      System.out.print("Visited Vertex:"+vertex.lable);
      while (!queue.isEmpty()) {
        int v1=queue.poll();
        int v2=getAdjustVertex(v1);
        while( v2 !=-1) {
          System.out.println("Visited Vertex:"+vertices[v2].lable);
          vertices[v2].visisted=true;
          queue.add(v2);
          v2=getAdjustVertex(v1);
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

  public static void main(String[] args) {
    BsfGraphTravel buildGraphDFT = new BsfGraphTravel();
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

    buildGraphDFT.graph.bfs();

  }
}

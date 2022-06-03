package array;

public class MinMaxNumberPair {
// Time Complexity: O(n)
  private Pair pair;

  private static class Pair {

    int min;
    int max;

    public int getMin() {
      return min;
    }

    public void setMin(int min) {
      this.min = min;
    }

    public int getMax() {
      return max;
    }

    public void setMax(int max) {
      this.max = max;
    }

    Pair(int min, int max) {
      this.max = max;
      this.min = min;
    }

    Pair() {
    }
  }

  public static void main(String[] args) {
    int arr[] = {1000, 11, 445, 1, 330, 3000};

    Pair p1 = findPair(arr, 0, arr
        .length - 1);
    System.out.print("pair:"+p1.getMin()+":"+p1.getMax());

  }

  private static Pair findPair(int[] arr, int start, int end) {

    Pair p = new Pair();
    if (start == end) {
      p.setMax(arr[end]);
      p.setMin(arr[start]);
      return p;
    }
    if (start + 1 == end) {
      if (arr[start] > arr[end]) {
        p.setMax(arr[start]);
        p.setMin(arr[end]);
      } else {
        p.setMax(arr[end]);
        p.setMin(arr[start]);
      }
      return p;
    }
    int mid = (start + end) / 2;
    Pair p1 = findPair(arr, start, mid);
    Pair p2 = findPair(arr, mid + 1, end);
    Pair finalPair = new Pair();
    if (p1.getMax() > p1.getMax()) {
      finalPair.setMax(p1.getMax());
    } else {
      finalPair.setMax(p2.getMax());
    }

    if (p1.getMin() < p2.getMin()) {
      finalPair.setMin(p1.getMin());
    } else {
      finalPair.setMin(p2.getMin());
    }

    return finalPair;

  }
}

package stack;

import java.util.Stack;

public class NearestSmallLeft {

  public static void main(String[] args) {
    int arr[] = {1, 3, 0, 2, 5};
    int n = arr.length;
    printPrevSmaller(arr, n);
  }

  private static void printPrevSmaller(int[] arr, int n) {

    Stack<Integer> stck = new Stack<>();

    for (int i = 0; i < n; i++) {
      int val = arr[i];
      if (stck.isEmpty()) {
        System.out.print(-1);
      } else if (stck.peek() < val) {
        System.out.print(" " + stck.pop());
      } else if (stck.peek() > val) {
        while ( !stck.isEmpty() && stck.peek() > val ) {
          stck.pop();
        }
        if(stck.isEmpty()) {
          System.out.print("-1");
        } else if(stck.peek()< val) {
          System.out.print(stck.pop());
        }
      }
     stck.push(val);
    }

  }
}

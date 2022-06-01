package stack;

import java.util.Stack;

public class TrappingRainWater {

  public static void main(String[] args) {

    int[] arr = { 0, 1, 0, 2, 1, 0,1, 3, 2, 1, 2, 1 };
    int n = arr.length;

    System.out.print(maxWater1(arr,n));
    System.out.print(maxWater(arr,n));
  }

  private static int maxWater1(int[] arr, int n) {

    int[] nmr=new int[n];
    int[] nml=new int[n];

    Stack<Integer> st=new Stack<>();
    st.push(st.push(arr[0]));
    nml[0]=arr[0];
    for(int i=1;i<arr.length;i++) {

      while( !st.isEmpty() && arr[i]>st.peek() ) {
        st.pop();
      }
      if(st.isEmpty()) {
        nml[i]=arr[i];
      } else {
        nml[i]=st.peek();
      }
      st.push(arr[i]);
    }
    for (int a:nml) {
      System.out.print(" "+a);
    }
    System.out.println();
    st.clear();
    nmr[n-1]=arr[n-1];
    st.push(nmr[n-1]);

    for (int j=n-2;j>=0;j--) {

      while(!st.isEmpty() && st.peek()<arr[j]) {
        st.pop();
      }
      if(!st.isEmpty()) {
        nmr[j]=st.peek();
      } else {
        nmr[j]=arr[j];
      }
      st.push(arr[j]);
    }

    for (int a:nmr) {
      System.out.print(" "+a);
    }
    System.out.println();

    int max=0;
    for(int i=0;i<n;i++) {
      max=max+ Math.min(nml[i],nmr[i])- arr[i];
    }
    return max;
  }

  public static int maxWater(int[] arr, int n)
  {

    // To store the maximum water
    // that can be stored
    int res = 0;

    // For every element of the array
    // except first and last element
    for(int i = 1; i < n - 1; i++)
    {

      // Find maximum element on its left
      int left = arr[i];
      for(int j = 0; j < i; j++)
      {
        left = Math.max(left, arr[j]);
      }

      // Find maximum element on its right
      int right = arr[i];
      for(int j = i + 1; j < n; j++)
      {
        right = Math.max(right, arr[j]);
      }

      // Update maximum water value
      res += Math.min(left, right) - arr[i];
    }
    return res;
  }
}

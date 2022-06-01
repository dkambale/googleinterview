package stack;

import java.util.Arrays;
import java.util.Stack;

public class HistoGram {

  public int largestRectangleArea(int[] hh) {

    int [] nsr= getRightSmall(hh);
    display(nsr);

    int [] nsl= getLeftSmall(hh);
    display(nsl);

    int sum[]=new int[hh.length];
    for(int i=0;i<hh.length;i++) {
      sum[i]=nsr[i]-nsl[i]-1;
    }
    // multiply
    for(int i=0;i<hh.length;i++) {
      sum[i]=sum[i]*hh[i];
    }
    Arrays.sort(sum);
    display(sum);
    return sum[hh.length-1];

  }
  public void display(int[] aa) {
    for(int a:aa) {
      System.out.print(" "+a);
    }
    System.out.println();
  }

  public int[] getLeftSmall(int[]hh) {
    Stack<Pair> st=new Stack();
    int[] nsl= new int[hh.length];

    st.push(new Pair(hh[0],-1));
    int n=hh.length;
    for(int i=0;i<n;i++) {

      Pair p=st.peek();
      while(p.val>hh[i] && !st.isEmpty()) {
        st.pop();
        if(!st.isEmpty()) {
          p=st.peek();
        }
      }

      if(st.isEmpty()) {
        nsl[i]=-1;
      } else {
        nsl[i]=st.peek().index;
      }

      st.push(new Pair(hh[i],i));

    }
    return nsl;
  }

  public int[] getRightSmall(int[] hh) {

    Stack<Pair> st=new Stack();
    int [] nsr=new int[hh.length];
    int n=hh.length;
    //st.push(new Pair(hh[n-1],n));
    for(int i=n-1;i>=0;i--) {

      if(st.isEmpty()) {
        nsr[i]=n;
      } else {
        Pair p=st.peek();

        while( !st.isEmpty() && p.val>=hh[i] ) {
          st.pop();
          if(!st.isEmpty()) {
            p=st.peek();
          }
        }
        if(st.isEmpty()) {
          nsr[i]=n;
        } else {
          nsr[i]=st.peek().index;
        }
      }

      st.push(new Pair(hh[i],i));

    }
    return nsr;
  }

  public class Pair {
    int val;
    int index;

    Pair(int val,int index) {
      this.val=val;
      this.index=index;
    }
  }
}

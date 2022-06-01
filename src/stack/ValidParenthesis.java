package stack;

import java.util.Stack;

public class ValidParenthesis {

  public static void main(String[] args) {
    Stack<Character> st=new Stack<Character>();

    String ss="(())";

    int i=0;
    while(i<ss.length()) {

      if(ss.charAt(i)=='(') {
        st.push(ss.charAt(i));
      } else {
        System.out.print(st.peek());
        if( !st.isEmpty() && '('==st.peek()) {
          st.pop();
        }
      }
      i++;
    }
    if(st.isEmpty()) {
      System.out.print("Valid Parenthesis");
    } else {
      System.out.print("Valid Not Parenthesis");
    }
  }

  static int findMaxLen(String s)
  {
    if (s.length() <= 1)
      return 0;

    // Initialize curMax to zero
    int curMax = 0;
    int[] longest = new int[s.length()];

    // Iterate over the String starting from second index
    for (int i = 1; i < s.length(); i++)
    {
      if (s.charAt(i) == ')' && i - longest[i - 1] - 1 >= 0
          && s.charAt(i - longest[i - 1] - 1) == '(')
      {
        longest[i]
            = longest[i - 1] + 2
            + ((i - longest[i - 1] - 2 >= 0)
            ? longest[i - longest[i - 1] - 2]
            : 0);
        curMax = Math.max(longest[i], curMax);
      }
    }
    return curMax;
  }
}

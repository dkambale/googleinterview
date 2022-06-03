package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {
// O(n)
  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    TreeNode one = new TreeNode(2);
    TreeNode two = new TreeNode(3);
    TreeNode three = new TreeNode(4);
    TreeNode four = new TreeNode(5);
    TreeNode five = new TreeNode(6);
    root.left = one;
    root.right = two;
    one.left = three;
    one.right = four;
    two.left = five;
    Solution ss = new Solution();
    boolean isBalanced = ss.isBalanced(root);

    System.out.println("Balance tree:" + isBalanced);
  }

  static class Solution {

    public boolean isBalanced(TreeNode root) {

      Queue<TreeNode> qu = new LinkedList<>();

      qu.add(root);

      qu.add(null);
      int level = 1;
      TreeNode prev = null;
      Integer start = null;
      Integer end = null;
      while (!qu.isEmpty()) {
        TreeNode tn = qu.poll();

        if (tn != null) {
          System.out.println("data==>" + tn.key);
          if (tn.left != null) {
            qu.add(tn.left);
          }
          if (tn.right != null) {
            qu.add(tn.right);
          }

          if (tn.left == null && tn.right == null) {
            if (start == null) {
              start = level;
              end = level;
            } else {
              end = level;
            }
          }
        } else {
          if (!qu.isEmpty() && tn == null) {
            level++;
            qu.add(null);
          }
        }
        System.out.println("queue size==>" + qu.size());

      }

      return end - start > 1 ? false : true;
    }
  }
}

package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

  TreeNode root;

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    TreeNode one = new TreeNode(2);
    TreeNode two = new TreeNode(3);
    TreeNode three = new TreeNode(4);
    TreeNode four = new TreeNode(5);
    TreeNode five = new TreeNode(6);
/* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      4      5   6     7    */

    root.left = one;
    root.right = two;
    one.left = three;
    one.right = four;
    two.left = five;

    BinaryTree binaryTree = new BinaryTree();
    //binaryTree.preOrderTravel(root);
    //binaryTree.inorderTravel(root);
    binaryTree.postTrevaler(root);
    binaryTree.levelTravel(root);
    int maxValue= binaryTree.findMax(root);
    System.out.println("FindMax:"+maxValue);
  }

  public void preOrderTravel(TreeNode root) {
    System.out.println("Pre Order travel");
    Stack<TreeNode> stack = new Stack<>();

    if (root != null) {
      stack.push(root);
    }
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      System.out.print(" " + cur.key);
      if (cur.right != null) {
        stack.push(cur.right);
      }
      if (cur.left != null) {
        stack.push(cur.left);
      }
    }
  }

  public void inorderTravel(TreeNode root) {
    System.out.println("In Order travel");
    Stack<TreeNode> stack = new Stack<>();

    TreeNode curr = root;
    boolean done = false;
    while (!done) {

      if (curr != null) {
        stack.push(curr);
        curr = curr.left;
      } else {
        if (stack.isEmpty()) {
          done = true;
        } else {
          curr = stack.pop();
          System.out.print(curr.key);
          // stack.push(curr.right);
          curr = curr.right;
        }
      }
    }
  }


  public void postTrevaler(TreeNode root) {
    System.out.print("Post Travaler==> ");
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = null;
    stack.push(root);
    TreeNode pre = null;
    while (!stack.isEmpty()) {
      cur = stack.peek();
      if (pre == null || pre.left == cur
          || pre.right == cur) {
        if (cur.left != null) {
          stack.push(cur.left);
        } else if (cur.right != null) {
          stack.push(cur.right);
        }
      } else if (cur.left == pre) {
        if (cur.right != null) {
          stack.push(cur.right);
        }
      } else {
        System.out.print(" " + cur.key);
        stack.pop();
      }
      pre = cur;

    }
  }

  public void levelTravel(TreeNode root) {
    List<List<TreeNode>> listList = new ArrayList<>();
    List<TreeNode> list=new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      if (curr != null) {
        if (curr.left != null) {
          queue.add(curr.left);
        }
        if (curr.right != null) {
          queue.add(curr.right);
        }
        list.add(curr);
      } else  {
        if(!queue.isEmpty()) {
          queue.add(null);
        }
        print(list);
        list.clear();
      }
    }
  }

  private void print(List<TreeNode> list) {
    System.out.println();
    for(TreeNode node:list) {
      System.out.print(" "+node.key);
    }
  }

  public int findMax(TreeNode root) {
    if(root==null)
      return Integer.MIN_VALUE;
    int res=root.key;
    int letMax=findMax(root.left);
    int rightMax=findMax(root.right);
    if(res<letMax) {
      res=letMax;
    }
    if(res<rightMax) {
      res=rightMax;
    }
    return res;
  }
}



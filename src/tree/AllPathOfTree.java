package tree;

public class AllPathOfTree {
// time complexity O(n)
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

    int [] ss=new int[255];
    printAllPath(root,ss,0);
  }

  private static void printAllPath(TreeNode root,int[]ss,int l) {

    if(root==null){
      return;
    }
    ss[l]=root.key;
    l++;
    if(root.left==null && root.right==null) {
      display(ss,l);
    } else {

      if(root.left!=null) {
        printAllPath(root.left,ss,l);
      }
      if(root.right!=null) {
        printAllPath(root.right,ss,l);
      }

    }

  }

  private static void display(int[] ss, int l) {
    for(int i=0;i<l;i++) {
      System.out.print(" "+ss[i]);
    }
    System.out.println();
  }
}

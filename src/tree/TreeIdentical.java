package tree;

public class TreeIdentical {

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

    TreeNode root1 = new TreeNode(1);
    TreeNode one1 = new TreeNode(2);
    TreeNode two1 = new TreeNode(3);
    TreeNode three1 = new TreeNode(4);
    TreeNode four1 = new TreeNode(5);
    //TreeNode five1 = new TreeNode(6);
/* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      4      5   6     7    */

    root1.left = one1;
    root1.right = two1;
    one1.left = three1;
    one1.right = four1;
    //two1.left = five1;

    boolean isSymmetric=isSymmetric(root,root1);
    System.out.println(isSymmetric);

  }

  private static boolean isSymmetric(TreeNode root, TreeNode root1) {

    if(root ==null && root1==null)
      return true;
    if((root== null && root1!=null) || (root1== null && root!=null))  {
      return false;
    }
    return isSymmetric(root.right,root1.right) && isSymmetric(root.left,root1.left);
  }
}

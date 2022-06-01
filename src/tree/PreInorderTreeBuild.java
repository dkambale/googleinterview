package tree;

class Node {

  char data;
  Node left, right;

  Node(char item) {
    data = item;
    left = right = null;
  }
}

public class PreInorderTreeBuild {

  private static int preIndex = 0;

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
    char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
    int len = in.length;
    Node root = buildTree(in, pre, 0, len - 1);

    // building the tree by printing inorder traversal
    System.out.println("Inorder traversal of constructed tree is : ");
    printInorder(root);
  }

  private static void printInorder(Node root) {
    if (root == null) {
      return;
    }
    printInorder(root.left);
    System.out.print(root.data);
    printInorder(root.right);
  }

  static Node buildTree(char in[], char pre[], int inStrt, int inEnd) {
    if (inStrt > inEnd) {
      return null;
    }

        /* Pick current node from Preorder traversal using preIndex
           and increment preIndex */
    Node tNode = new Node(pre[preIndex++]);

    /* If this node has no children then return */
    if (inStrt == inEnd) {
      return tNode;
    }

    /* Else find the index of this node in Inorder traversal */
    int inIndex = search(in, inStrt, inEnd, tNode.data);

        /* Using index in Inorder traversal, construct left and
           right subtress */
    tNode.left = buildTree(in, pre, inStrt, inIndex - 1);
    tNode.right = buildTree(in, pre, inIndex + 1, inEnd);

    return tNode;
  }

  static int search(char arr[], int strt, int end, char value) {
    int i;
    for (i = strt; i <= end; i++) {
      if (arr[i] == value) {
        return i;
      }
    }
    return i;
  }
}

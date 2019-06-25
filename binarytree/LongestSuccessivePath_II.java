package org.interview.preperation.binarytree;

public class LongestSuccessivePath_II {

//  public static void main(String args[]) {
//    TreeNode<Integer> root = new TreeNode(1);
//
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(3);
//
//    root.right.right = new TreeNode(4);
//
//    root.right.right.right = new TreeNode(5);
//
//    System.out.println(findLongestSuccessivePath(root));
//  }

  public static void main(String args[]) {
    TreeNode<Integer> root = new TreeNode(2);

    root.right = new TreeNode(3);

    root.right.left = new TreeNode(2);

    root.right.left.left = new TreeNode(1);

    System.out.println(findLongestSuccessivePath(root, 0, 0));
  }

  static int result = 0;

  private static int findLongestSuccessivePath(TreeNode<Integer> root, int pathLen, int target) {
    if (root == null) {
      return 1;
    }

    if (target == root.val) {
      pathLen++;
    } else {
      pathLen = 1;
    }

    result = Math.max(pathLen, result);
    findLongestSuccessivePath(root.left, pathLen, root.val + 1);
    findLongestSuccessivePath(root.right, pathLen, root.val + 1);

    return result;
  }
}

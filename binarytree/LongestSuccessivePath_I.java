package org.interview.preperation.binarytree;

public class LongestSuccessivePath_I {

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

    System.out.println(findLongestSuccessivePath(root));
  }

  private static int findLongestSuccessivePath(TreeNode<Integer> root) {
    if (root == null) {
      return 1;
    }

    //Find Longest Successive Path in left side subtree
    int left_longest_path_length = findLongestSuccessivePath(root.left);

    //diff between child and parent should be 1
    if (root.left != null && root.left.val - root.val == 1) {
      left_longest_path_length++;
    }

    //Find Longest Successive Path in right side subtree
    int right_longest_path_length = findLongestSuccessivePath(root.right);

    //diff between child and parent should be 1
    if (root.right != null && root.right.val - root.val == 1) {
      right_longest_path_length++;
    }

    return Math.max(right_longest_path_length, left_longest_path_length);
  }
}

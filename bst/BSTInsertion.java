package org.interview.preperation.bst;

public class BSTInsertion {
    /*
           8
        /    |
      3       10
     / \       \
    1  6       14
      / \      /
     4  7     13
 */
    public static void main(String args[]) {
        TreeNode<Integer> root = new TreeNode<>(8);
        root.leftTree = new TreeNode<>(3);
        root.rightTree = new TreeNode<>(10);

        root.leftTree.leftTree = new TreeNode<>(1);
        root.leftTree.rightTree = new TreeNode<>(6);

        root.leftTree.rightTree.leftTree = new TreeNode<>(4);
        root.leftTree.rightTree.rightTree = new TreeNode<>(7);

        root.rightTree.rightTree = new TreeNode<>(14);
        root.rightTree.rightTree.leftTree = new TreeNode<>(13);

        insertKeyIterative(root, 70);

        printTree(root);
    }

    private static <T> void printTree(TreeNode<? extends Comparable<T>> root) {
        if (root == null) {
            return;
        }
        printTree(root.rightTree);
        System.out.println(root.key);
        printTree(root.leftTree);
    }

    private static <T extends Comparable<T>> void insertKeyIterative(TreeNode<T> root, T key) {
        while (root != null) {
            if (root.key.compareTo(key) == 1) {
                if (root.leftTree == null) {
                    root.leftTree = new TreeNode<>(key);
                    return;
                }
                root = root.leftTree;
            } else {
                if (root.rightTree == null) {
                    root.rightTree = new TreeNode<>(key);
                    return;
                }
                root = root.rightTree;
            }
        }
    }
}

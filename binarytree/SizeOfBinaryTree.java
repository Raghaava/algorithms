package org.interview.preperation.binarytree;

/*
    Given a binary tree, return it's total number of nodes i.e size.
 */
public class SizeOfBinaryTree {
    public static void main(String args[]) {
        TreeNode<Integer> root = new TreeNode(3);

        root.left = new TreeNode(6);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(11);

        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(5);

        root.right.right = new TreeNode(13);
        root.right.right.left = new TreeNode(7);

        System.out.println(getSize(root));
    }

    private static <T> int getSize(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + getSize(root.left) + getSize(root.right);
    }
}

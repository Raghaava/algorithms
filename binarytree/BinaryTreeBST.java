package org.interview.preperation.binarytree;

public class BinaryTreeBST {
    public static void main(String args[]) {
        TreeNode<Integer> root = new TreeNode(7);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(6);

        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(8);

        System.out.println(isBinaryTreeBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean isBinaryTreeBST(TreeNode<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }

        return isValueBetween(root.val,min,max) && isBinaryTreeBST(root.left, min, root.val) && isBinaryTreeBST(root.right, root.val, max);
    }

    private static boolean isValueBetween(int value, int min, int max) {
        return value < max && value >= min;
    }
}

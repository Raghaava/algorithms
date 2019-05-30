package org.interview.preperation.binarytree;

/*
    height = no.of edges between root and deepest leaf.
    TC = O(n)
    SC = O(n)
 */
public class HeightOfBinaryTree {
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

        System.out.println(getHeight(root));
    }

    private static <T> int getHeight(TreeNode<T> root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }


}

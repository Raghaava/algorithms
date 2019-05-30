package org.interview.preperation.binarytree;

public class SameBinaryTree {
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

        TreeNode<Integer> root2 = new TreeNode(3);

        root2.left = new TreeNode(6);
        root2.right = new TreeNode(8);

        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(11);

        root2.left.right.left = new TreeNode(9);
        root2.left.right.right = new TreeNode(5);

        root2.right.right = new TreeNode(13);
        root2.right.right.left = new TreeNode(7);
        
        System.out.println(areSameBinaryTrees(root, root2));
    }

    private static <T> boolean areSameBinaryTrees(TreeNode<T> root1, TreeNode<T> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && areSameBinaryTrees(root1.left, root2.left) && areSameBinaryTrees(root1.right, root2.right);
    }
}

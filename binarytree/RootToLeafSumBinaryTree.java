package org.interview.preperation.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSumBinaryTree {
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

        List<Integer> path = new ArrayList<>();
        System.out.println(printPathsRootToLeaf(root, path,11));
        System.out.println(path);
    }

    private static boolean printPathsRootToLeaf(TreeNode<Integer> root,List<Integer> path,int sum) {
        if (root == null) {
            return false;
        }

        sum = sum - root.val;
        path.add(root.val);
        if (sum == 0 && isLeaf(root)) {
            return true;
        }
        if(printPathsRootToLeaf(root.left, path,sum) || printPathsRootToLeaf(root.right, path,sum))
        {
            return true;
        }

        path.remove(root.val);
        return false;
    }

    private static <T> boolean isLeaf(TreeNode<T> root) {
        if (root == null) {
            return true;
        }

        if (root.right == null && root.left == null) {
            return true;
        }

        return false;
    }
}

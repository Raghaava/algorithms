package org.interview.preperation.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeastCommonAncestor {
    static class TreeNode<T> {
        T val;

        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T val) {
            this.val = val;
        }
    }

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

        findAncestorWithExtraSpace(root, 8, 7);
        System.out.println(findAncestor(root, 8, 7));
    }

    public static <T> void findAncestorWithExtraSpace(TreeNode root, T from, T to) {
        if (root == null) {
            return;
        }

        List<T> path1 = new ArrayList<>();
        List<T> path2 = new ArrayList<>();
        findPath(root, path1, from);
        findPath(root, path2, to);

        System.out.println(path1);
        System.out.println(path2);
        T lca = null;
        for (T element : path1) {
            if (path2.contains(element)) {
                lca = element;
            }
        }

        System.out.println(lca);
    }

    public static <T> boolean findPath(TreeNode<T> node, List<T> path, T element) {
        if (node == null) {
            return false;
        }

        path.add(node.val);
        if (node.val == element) {
            return true;
        }

        if (findPath(node.left, path, element) || findPath(node.right, path, element)) {
            return true;
        }

        path.remove(node.val);
        return false;
    }

    public static <T> T findAncestor(TreeNode<T> node, T from, T to) {
        if (node == null) {
            return null;
        }

        if (node.val == from || node.val == to) {
            return node.val;
        }

        T lval = findAncestor(node.left, from, to);

        T rval = findAncestor(node.right, from, to);

        if (lval != null && rval != null) {
            return node.val;
        }
        return lval != null ? lval : rval;
    }
}

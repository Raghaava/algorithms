package org.interview.preperation.bst;

public class SearchBST {

    static class TreeNode<T extends Comparable<T>> {
        T key;
        TreeNode<T> leftTree;
        TreeNode<T> rightTree;

        TreeNode(T key) {
            this.key = key;
        }
    }

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

        System.out.println(findKey(root, 7));
        System.out.println(findKeyIterative(root, 7));
    }

    /**
     *     8
     *      \
     *      10
     *       \
     *       14
     *        \
     *         13
     */
//    public static void main(String args[]) {
//        TreeNode<Integer> root = new TreeNode<>(8);
//        root.rightTree = new TreeNode<>(10);
//
//        root.rightTree.rightTree = new TreeNode<>(14);
//        root.rightTree.rightTree.leftTree = new TreeNode<>(13);
//
//        System.out.println(findKey(root, 8));
//        System.out.println(findKeyIterative(root, 8));
//    }

    //o(nlogn)
    public static <T> boolean findKeyIterative(TreeNode<? extends Comparable<T>> root, T key) {
        while (root != null) {
            if (root.key == key) {
                return true;
            }
            if (root.key.compareTo(key) == 1) {
                root = root.leftTree;
            } else {
                root = root.rightTree;
            }
        }
        return false;
    }

    //Time complexity O(logn) - Space complexity O(h)
    public static <T> boolean findKey(TreeNode<? extends Comparable<T>> root, T key) {
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }

        if (root.key.compareTo(key) == 1) {
            return findKey(root.leftTree, key);
        } else {
            return findKey(root.rightTree, key);
        }
    }
}

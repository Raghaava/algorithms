package org.interview.preperation.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeIterativeZigzagOrderDequeStacks {

    static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.right.left = new TreeNode(9);

        root.right.right.right = new TreeNode(10);

        printLevelOrder(root);
    }


    /*
    *                      1    <-
    *                   /    |            null
    *                 2       3
    *               /  \    /  \
    *              4   5   6   7
    *            /    /         \
    *           8    9          10
    *
     */
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> queue = new LinkedList<>();

        queue.addFirst(null);
        queue.addFirst(root);

        while (queue.size() > 1) {
            while (queue.peekFirst() != null) {
                TreeNode node = queue.pollFirst();

                System.out.print(node.val + " ");

                if (node.left != null) {
                    queue.addLast(node.left);
                }

                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            System.out.println();
            while (queue.peekLast() != null) {
                TreeNode node = queue.pollLast();

                System.out.print(node.val+" ");

                if (node.right != null) {
                    queue.addFirst(node.right);
                }

                if (node.left != null) {
                    queue.addFirst(node.left);
                }

            }
            System.out.println();
        }
    }
}

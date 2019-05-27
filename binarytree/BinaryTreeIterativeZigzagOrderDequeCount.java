package org.interview.preperation.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTreeIterativeZigzagOrderDequeCount {

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
        root.right.right.right.left = new TreeNode(11);
        root.left.right.left.right = new TreeNode(19);

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

        queue.addFirst(root);
        int levelCount = 1;
        int currentCount = 0;
        boolean levelFlag = true;
        while (!queue.isEmpty()) {
            if (levelFlag) {
                TreeNode node = queue.pollFirst();
                System.out.print(node.val+" ");
                levelCount--;
                if (node.left != null) {
                    queue.addLast(node.left);
                    currentCount++;
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                    currentCount++;
                }
            } else {
                TreeNode node = queue.pollLast();
                System.out.print(node.val+" ");
                levelCount--;

                if (node.right != null) {
                    queue.addFirst(node.right);
                    currentCount++;
                }

                if (node.left != null) {
                    queue.addFirst(node.left);
                    currentCount++;
                }
            }
            if (levelCount == 0) {
                levelCount = currentCount;
                currentCount = 0;
                levelFlag = !levelFlag;
                System.out.println();
            }
        }
    }
}

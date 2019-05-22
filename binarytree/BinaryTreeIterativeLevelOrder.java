package org.interview.preperation.binarytree;

import java.util.*;

public class BinaryTreeIterativeLevelOrder {

    static class TreeNode {
        int val;

        TreeNode leftNode;
        TreeNode rightNode;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 10
     * /     |
     * -2       4
     * / \     / \
     * 11  13  20 -10
     * /     \
     * 130    150
     * /
     * 160
     */
    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.leftNode = new TreeNode(-2);
        root.rightNode = new TreeNode(4);

        root.leftNode.leftNode = new TreeNode(11);
        root.leftNode.rightNode = new TreeNode(13);

        root.rightNode.leftNode = new TreeNode(20);
        root.rightNode.rightNode = new TreeNode(-10);

        root.rightNode.leftNode.rightNode = new TreeNode(150);

        root.rightNode.leftNode.rightNode.leftNode = new TreeNode(160);

        root.leftNode.rightNode.leftNode = new TreeNode(130);

        printLevelOrder(root);
    }

    /**
     * 10           10
     * /     |
     * -2       4
     * / \     / \
     * 11  13  20 -10
     * /     \
     * 130    150
     */
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.print(node.val + " ");

            if (node.leftNode != null) {
                queue.add(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.add(node.rightNode);
            }
        }
    }
}

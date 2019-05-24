package org.interview.preperation.binarytree;

import java.util.*;

public class BinaryTreeIterativeZigzagOrderStacks {

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
        root.right = new TreeNode(12);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(16);

        root.right.left.left = new TreeNode(35);
        root.right.left.right = new TreeNode(55);

        root.left.left = new TreeNode(3);

        root.left.left.right = new TreeNode(33);


        root.left.left.left = new TreeNode(4);
        root.left.left.left.left = new TreeNode(5);
        root.left.left.left.right = new TreeNode(55);

        printLevelOrder(root);
    }


    /***
     *                      1
     *                     /      \
     *                    2        12
     *                   / \      /  \
     *                  3  null  15  16
     *                 / \      /  \
     *                4  33   35   55     <-
     *               / \
     *              5  55
     */
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                System.out.print(node.val+" ");

                if (node.left != null) {
                    stack2.push(node.left);
                }

                if (node.right != null) {
                    stack2.push(node.right);
                }
            }
            System.out.println();
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                System.out.print(node.val+" ");

                if (node.right != null) {
                    stack1.push(node.right);
                }

                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
            System.out.println();
        }
    }
}

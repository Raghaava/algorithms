package org.interview.preperation.binarytree;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

/*
Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 */
public class BinaryTreeVericalOrder {
    static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Node {
        TreeNode root;
        int x;
        int y;

        Node(TreeNode root, int x, int y) {
            this.root = root;
            this.x = x;
            this.y = y;
        }

        public int getValue() {
            return this.root.val;
        }

        public int getY() {
            return -1 * this.y;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);


        root.left.left.left.right = new TreeNode(7);
        root.left.left.left.right.left = new TreeNode(10);
        root.left.left.left.right.right = new TreeNode(8);

        root.left.left.right.left = new TreeNode(1);
        root.left.left.right.left.left = new TreeNode(11);
        root.left.left.right.left.right = new TreeNode(9);
        System.out.println(verticalOrder(root));
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

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Map<Integer, List<Node>> map = new TreeMap<>();

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            map.putIfAbsent(cur.x, new ArrayList());
            map.get(cur.x).add(cur);
            if (cur.root.left != null) {
                q.offer(new Node(cur.root.left, cur.x - 1, cur.y - 1));
            }

            if (cur.root.right != null) {
                q.offer(new Node(cur.root.right, cur.x + 1, cur.y - 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (List<Node> values : map.values()) {
            list.add(values.stream().sorted(comparingInt(Node::getY).thenComparing(comparingInt(Node::getValue))).map(Node::getValue).collect(Collectors.toList()));
        }
        return list;
    }
}

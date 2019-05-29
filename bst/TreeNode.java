package org.interview.preperation.bst;

public class TreeNode<T extends Comparable<T>> {
    T key;
    TreeNode<T> leftTree;
    TreeNode<T> rightTree;

    TreeNode(T key) {
        this.key = key;
    }
}
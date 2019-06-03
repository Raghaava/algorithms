package org.interview.preperation.prefixtree;

/**
 * Time complexity: O( ROW x COL )
 * Auxiliary Space: O( ROW x COL )
 * <p>
 * Hash set is best approach
 * In this method convert the whole row into a single String and then check it is already present in HashSet or not.
 * If row is present then we will leave it otherwise we will print unique row and add it to HashSet.
 */
public class DuplicateRowsBinaryMatrix {

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[2];
        }
    }

    private static boolean construct(int[] arr, TrieNode root) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        for (int ch : arr) {
            TrieNode node = root.children[ch];
            if (node == null) {
                node = new TrieNode();
            }
            root.children[ch] = node;
            root = node;
        }
        if (root.isEndOfWord) {
            return false;
        }
        root.isEndOfWord = true;
        return true;
    }


    public static void main(String... args) {
        int[][] arr = new int[][]{{1, 1, 0, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1}};

        TrieNode root = new TrieNode();
        for (int[] arr1 : arr) {
            if (construct(arr1, root)) {
                for (int a : arr1) {
                    System.out.print(a);
                }
                System.out.println();
            }
        }
    }
}

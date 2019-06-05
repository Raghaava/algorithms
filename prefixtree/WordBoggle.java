package org.interview.preperation.prefixtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordBoggle {

    static Character[][] arr = null;
    static TreeMap<String, String> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noOfTC = Integer.parseInt(reader.readLine());
        while (noOfTC-- > 0) {
            TrieNode root = new TrieNode();
            reader.readLine();
            String[] words = reader.readLine().split(" ");

            for (String word : words) {
                construct(word, root);
            }

            String[] dimensions = reader.readLine().split(" ");
            int row = Integer.parseInt(dimensions[0]);
            int col = Integer.parseInt(dimensions[1]);
            arr = new Character[row][col];
            String[] chars = reader.readLine().split(" ");
            int index = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    arr[i][j] = chars[index++].toCharArray()[0];
                }
            }
            boolean[][] visited = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    wordBoggle(root, i, j, visited, "");
                }
            }
            if (map.isEmpty()) {
                System.out.print("-1");
            } else {
                for (String key : map.keySet()) {
                    System.out.print(key + " ");
                }
                map.clear();
            }
            System.out.println();
        }
    }

    private static boolean isSafe(int row, int col, boolean[][] visited) {
        return row >= 0 && col >= 0 && col < arr[0].length && row < arr.length && !visited[row][col];
    }

    private static void wordBoggle(TrieNode root, int row, int col, boolean[][] visited, String prefix) {
        if (!isSafe(row, col, visited)) {
            return;
        }
        root = root.children.get(arr[row][col]);
        if (root != null) {
            prefix = prefix + arr[row][col];
            if (root.isEndOfWord) {
                map.put(prefix, null);
            }
            //Don't revisit
            visited[row][col] = true;
            wordBoggle(root, row - 1, col - 1, visited, prefix);
            wordBoggle(root, row - 1, col, visited, prefix);
            wordBoggle(root, row - 1, col + 1, visited, prefix);
            wordBoggle(root, row, col - 1, visited, prefix);
            wordBoggle(root, row, col + 1, visited, prefix);
            wordBoggle(root, row + 1, col - 1, visited, prefix);
            wordBoggle(root, row + 1, col, visited, prefix);
            wordBoggle(root, row + 1, col + 1, visited, prefix);
            visited[row][col] = false;
        }
    }

    private static void construct(String word, TrieNode root) {
        if (word == null || word.length() == 0) {
            return;
        }

        for (Character ch : word.toCharArray()) {
            TrieNode node = root.children.get(ch);
            if (node == null) {
                node = new TrieNode();
            }
            root.children.put(ch, node);
            root = node;
        }
        root.isEndOfWord = true;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }
}

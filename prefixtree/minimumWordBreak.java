package org.interview.preperation.prefixtree;

import java.util.Arrays;

public class minimumWordBreak {

    public static void main(String... args) {
        String[] words = new String[]{"cat", "mat", "ca",
                "tm", "at", "c", "d", "og", "do"};  

        TrieNode root = new TrieNode();

        Arrays.asList(words).stream().forEach(word -> construct(word, root));
        //display(root, "");
        System.out.println(minWordBreak(root, "catmatat"));
    }

    private static int minWordBreak(TrieNode root, String input) {
        if (input == null || root == null) {
            return 0;
        }

        TrieNode node = root;
        int minBreak = Integer.MAX_VALUE-1;
        for (int i = 0; i < input.length(); i++) {
            node = node.children.get(input.charAt(i));
            if (node == null) {
                break;
            }
            if (node.isEndOfWord) {
                //complete word match
                if (i + 1 == input.length()) {
                    return 0;
                }
                minBreak = Math.min(1 + minWordBreak(root, input.substring(i + 1)), minBreak);
            }
        }
        return minBreak;
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
}

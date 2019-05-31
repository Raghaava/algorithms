package org.interview.preperation.prefixtree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TrieCRUD {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    public static void main(String... args) {
        String[] words = new String[]{"abcd", "cat", "dog", "xyz"};

        TrieNode root = new TrieNode();

        Arrays.asList(words).stream().forEach(word -> constructRecessive(word, root));

        Arrays.asList(words).stream().forEach(word -> System.out.println(searchWord(word, root)));

        System.out.println(searchWord("test", root));
        System.out.println(searchPrefix("ab", root));
        System.out.println(searchPrefix("cd", root));
    }

    private static void construct(String word, TrieNode root) {
        if (word == null || word.length() == 0) {
            return;
        }

        for (Character ch : word.toCharArray()) {
            TrieNode node = new TrieNode();
            root.children.putIfAbsent(ch, node);
            root = node;
        }
        root.isEndOfWord = true;
    }

    private static void constructRecessive(String word, TrieNode root) {
        if (word == null || word.length() == 0) {
            root.isEndOfWord = true;
            return;
        }

        TrieNode node = new TrieNode();
        root.children.putIfAbsent(word.charAt(0), node);
        root = node;
        constructRecessive(word.substring(1), root);
    }

    private static boolean searchWord(String word, TrieNode root) {
        if (word == null || word.length() == 0) {
            return true;
        }

        for (Character ch : word.toCharArray()) {
            root = root.children.get(ch);

            if (root == null) {
                return false;
            }
        }

        return root.isEndOfWord;
    }

    private static boolean searchPrefix(String word, TrieNode root) {
        if (word == null || word.length() == 0) {
            return true;
        }

        for (Character ch : word.toCharArray()) {
            root = root.children.get(ch);

            if (root == null) {
                return false;
            }
        }

        return true;
    }
}

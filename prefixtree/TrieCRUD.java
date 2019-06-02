package org.interview.preperation.prefixtree;

import java.util.Arrays;

/**
 * Insert and search costs O(key_length), however the memory requirements of Trie is O(ALPHABET_SIZE * key_length * N)
 * where N is number of keys in Trie.
 *
 * 1) Sorting array of strings (or words) using Trie (Handling Duplicates)
 */
public class TrieCRUD {
    public static void main(String... args) {
        String[] words = new String[]{"xyz", "cat", "abcd", "abcd","dog", "ab"};

        TrieNode root = new TrieNode();

        Arrays.asList(words).stream().forEach(word -> constructRecessive(word, root));

        // Arrays.asList(words).stream().forEach(word -> System.out.println(searchWord(word, root)));

        display(root, "");
    }

    private static void construct(String word, TrieNode root) {
        if (word == null || word.length() == 0) {
            return;
        }

        for (Character ch : word.toCharArray()) {
            TrieNode node = root.children.get(word.charAt(0));
            if (node == null) {
                node = new TrieNode();
            }
            root.children.put(word.charAt(0), node);
            root = node;
        }
        root.isEndOfWord = true;
    }

    private static void constructRecessive(String word, TrieNode root) {
        if (word == null || word.length() == 0) {
            root.isEndOfWord = true;
            return;
        }

        TrieNode node = root.children.get(word.charAt(0));
        if (node == null) {
            node = new TrieNode();
        }
        root.children.put(word.charAt(0), node);
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

    private static void display(TrieNode root, String word) {
        if (root == null) {
            return;
        }

        if (root.isEndOfWord) {
            System.out.println(word);
        }
        root.children.entrySet().stream().forEach(entry -> {
            display(entry.getValue(), word + entry.getKey());
        });
    }
}

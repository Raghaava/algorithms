package org.interview.preperation.prefixtree;

import java.util.Arrays;

public class AutoCompleteTrie {
    public static void main(String... args) {
        String[] words = new String[]{"hello","dog","hell","cat","a","hel","help","helps","helping"};

        TrieNode root = new TrieNode();

        Arrays.asList(words).stream().forEach(word -> constructRecessive(word, root));

        searchPrefix("hel",root);
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

    private static void searchPrefix(String word, TrieNode root) {
        if (word == null || word.length() == 0) {
            return;
        }

        for (Character ch : word.toCharArray()) {
            root = root.children.get(ch);

            if (root == null) {
                return;
            }
        }

        display(root,word);
    }

    //DFS
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

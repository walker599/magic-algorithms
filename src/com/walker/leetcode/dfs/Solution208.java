package com.walker.leetcode.dfs;

/**
 * @program: magic-algorithms
 * @author: Walker
 * @create: 2021-09-02 03:43
 * @difficulty:
 * @link:
 **/
public class Solution208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
    }
}
class Trie {
    private boolean isEnd;
    Trie[] child;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        child = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.child[index] == null) {
                node.child[index] = new Trie();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = seachPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return seachPrefix(prefix) != null;
    }

    private Trie seachPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.child[index] == null) {
                return null;
            }
            node = node.child[index];
        }
        return node;
    }
}

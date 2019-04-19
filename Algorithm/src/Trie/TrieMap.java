package Trie;

import java.util.*;

class TrieMap {
    public boolean isEnd=false;
    public Map<Character, TrieMap> children = new TreeMap<Character, TrieMap>();
    /** Initialize your data structure here. */
    public TrieMap() {}

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieMap root = this;
        for (int i=0;i<word.length();i++) {
            if(!root.children.containsKey(word.charAt(i))) {
                TrieMap tmp = new TrieMap();
                root.children.put(word.charAt(i),tmp);
            }
            if (i==word.length()-1) {
                root.children.get(word.charAt(i)).isEnd=true;
            } else {
                root=root.children.get(word.charAt(i));
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieMap root = this;
        for(int i=0;i<word.length();i++) {
            if (!root.children.containsKey(word.charAt(i))) {
                return false;
            }
            TrieMap child=root.children.get(word.charAt(i));
            if (i==word.length()-1 && child.isEnd) {
                return true;
            }
            root=child;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieMap root = this;
        for(int i=0;i<prefix.length();i++) {
            if (!root.children.containsKey(prefix.charAt(i))) {
                return false;
            }
            TrieMap child=root.children.get(prefix.charAt(i));
            if (i==prefix.length()-1) {
                return true;
            }
            root=child;
        }
        return false;
    }
    public void printLevel() {
        Queue<TrieMap> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TrieMap first=queue.poll();
            for (Map.Entry entry: first.children.entrySet()){
                System.out.printf("%s ",entry.getKey());
                queue.offer((TrieMap) entry.getValue());
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        TrieMap trie=new TrieMap();
        trie.insert("apple");
        trie.printLevel();
        boolean b1=trie.search("apple");   // returns true
        boolean b2=trie.search("app");     // returns false
        boolean b3=trie.startsWith("app"); // returns true
        trie.insert("app");
        boolean b4=trie.search("app");     // returns true
        System.out.printf("%s, %s, %s, %s",b1,b2,b3,b4);
    }
}
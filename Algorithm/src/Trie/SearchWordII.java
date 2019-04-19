package Trie;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children= new TrieNode[26];
    String word;
}

class Solution {
    private TrieNode constructTrie(String[] words) {
        TrieNode root=new TrieNode();
        for (String word: words) {
            TrieNode p=root;
            for(int i=0;i<word.length();i++){
                int index=word.charAt(i)-'a';
                if (p.children[index]==null){
                    p.children[index]=new TrieNode();
                }
                p=p.children[index];
            }
            p.word=word;
        }
        return root;
    }
    public void dfs(char[][] board, int row, int col, TrieNode root, List<String> ret) {
        char c=board[row][col];
        if(c=='#' || root.children[c-'a']==null) {
            return;
        }
        root=root.children[c-'a'];
        if (root.word!=null) {
            ret.add(root.word);
            root.word=null;
        }
        board[row][col]='#';
        if(row < board.length-1) {
            dfs(board,row+1, col, root, ret);
        }
        if(col < board[0].length-1){
            dfs(board,row, col+1, root, ret);
        }
        if(row > 0) {
            dfs(board,row-1, col, root, ret);
        }
        if(col > 0){
            dfs(board,row, col-1, root, ret);
        }
        board[row][col]=c;
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=constructTrie(words);
        List<String> ret = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                dfs(board, i, j, root, ret);
            }
        }
        return ret;
    }
}

public class SearchWordII {
    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        List<String> ret=s.findWords(board, words);
        for (String word: ret){
            System.out.println(word);
        }
    }
}

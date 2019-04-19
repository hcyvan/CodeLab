package Backtrace;

import java.util.*;

class Solution2 {
    // BFS and Iteration
    public List<String> generateParenthesis(int n) {
        LinkedList<String> parentheses=new LinkedList<>();
        Deque<Integer> left=new ArrayDeque<>();
        Deque<Integer> right=new ArrayDeque<>();
        Deque<Integer> total=new ArrayDeque<>();
        parentheses.offer("");
        left.offer(n);
        right.offer(n);
        total.offer(0);
        while (parentheses.peek().length() != 2*n) {
            String str=parentheses.poll();
            int l = left.poll();
            int r = right.poll();
            int t = total.poll();
            if (l > 0) {
                parentheses.offer(str+"(");
                left.offer(l-1);
                right.offer(r);
                total.offer(t+1);
            }
            if (r > 0 && t - 1 >= 0) {
                parentheses.offer(str + ")");
                left.offer(l);
                right.offer(r-1);
                total.offer(t - 1);
            }
        }
        return parentheses;
    }
}

class Solution1 {
    // DFS and Recursion
    List<String> ret=new ArrayList<>();
    private void dfsRecursive(String parentheses, int left, int right, int total,int n) {
        if(parentheses.length()==2*n){
            ret.add(parentheses);
        } else {
            if (left > 0) {
                if (total>=0) {
                    dfsRecursive(parentheses+"(",left-1,right,total+1,n);
                }
            }
            if (right>0) {
                if(total >=0){
                    dfsRecursive(parentheses+")",left,right-1,total-1,n);
                }
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        dfsRecursive("",n,n,0,n);

        return ret;
    }
}

public class GenerateParentheses {
    public static void main(String[] args){
        Solution2 s=new Solution2();
        List<String> ret = s.generateParenthesis(10);
        for(String str:ret) {
            System.out.println(str);
        }
    }
}

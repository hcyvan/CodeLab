import java.util.ArrayList;
import java.util.List;

public class NQueue
{
    int[] queues;
    int N;
    List<List<String>> ret=new ArrayList<>();
    public void addToRet() {
        String dots=".";
        String que=dots.repeat(N);
        List<String> out=new ArrayList<>();
        for (int q: queues) {
            String queue=que.substring(0, q)+'Q'+que.substring(q+1);
            out.add(queue);
        }
        ret.add(out);
    }
    public boolean isValid(int row, int col) {
        for(int k=0; k < row; k++) {
            if (queues[k]==col || Math.abs(col-queues[k])==Math.abs(row-k)) {
                return false;
            }
        }
        return true;
    }
    private void backtrace(int row) {
        for (int i=0;i<N;i++) {
            if(isValid(row, i)) {
                queues[row]=i;
                if (row+1==N) {
                    addToRet();
                } else {
                    backtrace(row+1);
                }
            }
        }
    }
    public void print() {
        int n=0;
        for(List<String> i:ret) {
            n=n+1;
            System.out.println(Integer.toString(n)+": -------------");
            for(String j:i){
                System.out.println(j);
            }
        }
    }
    public void solve(int n) {
        queues=new int[n];
        N=n;
        backtrace(0);
    }
    public static void main(String[] args){
        // [Leecode]N Queue: https://leetcode.com/problems/n-queens/
        NQueue nQueue=new NQueue();
        nQueue.solve(8);
        nQueue.print();
    }
}

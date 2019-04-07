package DP;

public class Bag01 {
    private int number;
    private int[] weight;
    private int[] profit;
    private int capacity;
    private int[][] memo;
    Bag01(int n, int[] p, int[] w, int c) {
        number=n;
        weight=w;
        profit=p;
        capacity=c;
        memo=new int[c][];
        initMemo();
    }
    public int recursion(int i, int c) {
        if (i==number-1) {
           return c < weight[i] ? 0 : profit[i];
        }
        if (c < weight[i]) {
            return recursion(i+1, c);
        }
        return Math.max(recursion(i+1,c), recursion(i+1,c-weight[i])+profit[i]);
    }
    public int recursionMemo(int i, int c) {
        if (c<=0) {
            return 0;
        }
        if (memo[c-1][i]!=-1){
            return memo[c-1][i];
        }
        int ret;
        if (i==number-1) {
            ret = c < weight[i] ? 0 : profit[i];
        } else if (c < weight[i]) {
            ret = recursionMemo(i+1, c);
        } else {
            ret = Math.max(recursionMemo(i+1,c), recursionMemo(i+1,c-weight[i])+profit[i]);
        }
        memo[c-1][i]=ret;
        return ret;
    }
    public int bottomUpMemo() {
        for(int n=0; n < number; n++) {
            for(int c=0; c < capacity; c++){
                if (n==0) {
                    if(weight[0] <= c+1) {
                        memo[c][0] = profit[0];
                    }
                } else {
                    if(weight[n] <= c+1) {
                        int selected = c-weight[n] < 0 ? profit[n] : profit[n] + memo[c-weight[n]][n-1];
                        memo[c][n]=Math.max(memo[c][n-1], selected);
                    } else {
                        memo[c][n]=memo[c][n-1];
                    }
                }
            }
        }
        return memo[capacity-1][number-1];
    }
    public void printMemo() {
        for (int[] line: memo) {
            for (int i:line) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private void initMemo(){
        for (int i=0;i<capacity;i++) {
            memo[i]=new int[number];
            for (int j=0;j<number;j++){
                memo[i][j]=-1;
            }
        }
    }
    public void refreshMemo(){
        for (int i=0;i<capacity;i++) {
            for (int j=0;j<number;j++){
                memo[i][j]=-1;
            }
        }
    }

    public static void main(String[] args) {
        // 0-1背包问题
        int n=5;
        int[] p={1,6,18,22,28}; //价值
        int[] w={1,2,5,6,7}; //体积
        int c=11;// 容量

        Bag01 bag=new Bag01(n,p,w,c);
        System.out.println("Recursion: time complexity O(n^2)");
        int v1=bag.recursion(0,c);
        System.out.println(v1);
        System.out.println("Recursion Memo: time complexity O(nc)");
        int v2=bag.recursionMemo(0,c);
        System.out.println(v2);
        bag.printMemo();
        bag.refreshMemo();
        System.out.println("Traversal Memo: time complexity O(nc)");
        int v3=bag.bottomUpMemo();
        System.out.println(v3);
        bag.printMemo();
    }
}

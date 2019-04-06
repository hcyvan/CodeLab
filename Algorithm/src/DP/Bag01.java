package DP;

public class Bag01 {
    private int number;
    private int[] weight;
    private int[] profit;
    private int capacity;
    Bag01(int n, int[] p, int[] w, int c) {
        number=n;
        weight=w;
        profit=p;
        capacity=c;

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
        if (i==number-1) {
            return c < weight[i] ? 0 : profit[i];
        }
        if (c < weight[i]) {
            return recursion(i+1, c);
        }
        return Math.max(recursion(i+1,c), recursion(i+1,c-weight[i])+profit[i]);
    }

    public static void main(String[] args) {
        // 0-1背包问题
        int n=5;
        int[] p={6,3,5,4,6}; //体积
        int[] w={2,2,6,5,4}; //价值
        int c=10;// 容量

        Bag01 bag=new Bag01(n,p,w,c);
        int v1=bag.recursion(0,10);
        System.out.println("Recursion: time complexity O(n^2)");
        System.out.println(v1);

    }
}

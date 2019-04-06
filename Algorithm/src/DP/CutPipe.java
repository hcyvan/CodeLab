package DP;

public class CutPipe {
    public static int cutRecursion(int[] p, int n){
        if (n==0){
            return 0;
        }
        int tmp_value=0;
        for (int i=1;i<=n;i++) {
            tmp_value=Math.max(tmp_value, p[i-1]+cutRecursion(p, n-i));
        }
        return tmp_value;
    }
    public static int cutMemo(int[] p, int n) {
        int[] memo=new int[n+1];
        for (int i=0;i<=n;i++){
            memo[i]=-1;
        }
        return cutMemoRec(p, n, memo);
    }
    public static int cutMemoRec(int[] p, int n, int[] memo) {
        if (memo[n]!=-1) {
            return memo[n];
        }
        int tmp_value=0;
        for (int i=1;i<=n;i++){
            tmp_value=Math.max(tmp_value, p[i-1]+cutMemoRec(p, n-i, memo));
        }
        memo[n]=tmp_value;
        return tmp_value;
    }
    public static int cutBottomUp(int[] p, int n) {
        int[] memo=new int[n+1];
        for (int i=0;i<=n;i++){
            int tmp_value=0;
            for (int j=1;j<=i;j++) {
                tmp_value=Math.max(tmp_value, p[j-1]+memo[i-j]);
            }
            memo[i]=tmp_value;
        }
        return memo[n];
    }
    public static void main(String[] args){
        // 切钢管问题
        // https://blog.csdn.net/u013309870/article/details/75193592
        int n=4;
        int[] p={1,5,8,9};
        System.out.println("Recursion:");
        int max1=cutRecursion(p, n);
        System.out.println(max1);
        System.out.println("Memo:");
        int max2=cutMemo(p, n);
        System.out.println(max2);
        System.out.println("BottomUp:");
        int max3=cutBottomUp(p, n);
        System.out.println(max3);
    }
}

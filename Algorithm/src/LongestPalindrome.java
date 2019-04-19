public class LongestPalindrome {
    public String lpDynamicProgramming(String s) {
        int n = s.length();
        int max=0;
        int start=0,end=0;
        int[][] l=new int[n][n];
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++) {
                if(i==j){
                    l[i][j]=1;
                }else if(s.charAt(i)==s.charAt(j)){
                    if(i+1==j) {
                        l[i][j]=2;
                    } else if (l[i+1][j-1]!=0) {
                        l[i][j]=l[i+1][j-1]+2;
                    }
                }
                if(l[i][j]!=0){
                    if (l[i][j]>max) {
                        max=l[i][j];
                        start=i;
                        end=j;
                    }
                }
            }
        }
        return max==0 ? "" : s.substring(start,end+1);
    }
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String lp=longestPalindrome.lpDynamicProgramming("ccc");
        System.out.println(lp);
    }
}

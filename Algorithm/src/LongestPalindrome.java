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
    public String manacher(String s) {
        if (s.equals("")){
            return "";
        }
        int n=s.length();
        char[] p= new char[n*2 + 1];
        for(int i=0;i<n;i++) {
            p[i*2]='#';
            p[i*2+1]=s.charAt(i);
        }
        p[n*2]='#';
        int[] mx= new int[n*2 + 1];
        int pos=0,mr=0,max=0,max_mr=0;
        for(int i=0; i<p.length;i++){
            if (mr > i) {
                mx[i]=Math.min(mx[pos*2-i],mr-i);
            }else {
                mx[i]=1;
            }
            while (i-mx[i]>=0 && i+mx[i]<p.length && p[i-mx[i]]==p[i+mx[i]]) {
                mx[i]=mx[i]+1;
            }
            if (mr < mx[i]+i-1) {
                mr=mx[i]+i-1;
                pos=i;
            }

            if (mx[i] > max){
                max=mx[i];
                max_mr=mr;
            }
        }
        int sr=(max_mr-1)/2;
        int sl=sr-(max-1)+1;
        return s.substring(sl, sr+1);
    }
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String lp=longestPalindrome.lpDynamicProgramming("banana");
        System.out.println(lp);
        String ma=longestPalindrome.manacher("");
        System.out.println(ma);
    }
}

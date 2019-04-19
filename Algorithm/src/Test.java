class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int max=0;
        String str="";
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int a=i,b=j;
                boolean flag=true;
                while (a!=j){
                    if(s.charAt(a)!=s.charAt(b)) {
                        flag=false;
                        break;
                    }
                    a++;b--;
                }
                if(flag && j-i+1 > max) {
                    max=j-i+1;
                    str=s.substring(i,j+1);
                }
            }
        }
        return str;
    }
}

public class Test {
    public static void main(String[] str) {
        Solution s=new Solution();
        String ss=s.longestPalindrome("babad");
        System.out.println(ss);
        ss=s.longestPalindrome("aab");
        System.out.println(ss);
    }
}

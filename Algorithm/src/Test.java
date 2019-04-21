import java.net.InetAddress;

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
    public static void main(String[] str) throws Exception{
        int timeout=1000;
        for (int i=1;i<254;i++){
            String host="192.168.56" + "." + i;
            System.out.println(InetAddress.getByName(host).getAddress());
            if (InetAddress.getByName(host).isReachable(timeout)){
                System.out.println(host + " is reachable");
            }
        }
    }
}

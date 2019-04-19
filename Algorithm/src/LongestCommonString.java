import java.util.ArrayList;
import java.util.List;

public class LongestCommonString {
    public ArrayList<String> lcsDynamicProgramming(String str1, String str2) {
        int n1=str1.length(), n2=str2.length();
        int max=0;
        int[][] l = new int[n1][n2];
        ArrayList<String> ret = new ArrayList<>();
        for (int i=0;i<n1;i++){
            for (int j=0;j<n2;j++){
                if (str1.charAt(i)==str2.charAt(j)){
                    if (i==0 || j==0) {
                        l[i][j]=1;
                    } else {
                        l[i][j]=l[i-1][j-1]+1;
                    }
                    if (max < l[i][j]) {
                        max=l[i][j];
                        ret.clear();
                        ret.add(str1.substring(i-l[i][j]+1, i+1));
                    }else if(max == l[i][j]){
                        ret.add(str1.substring(i-l[i][j]+1, i+1));
                    }
                } else {
                    l[i][j]=0;
                }
            }
        }
        for (int i=0;i<n1;i++){
            for (int j=0;j<n2;j++){
                System.out.print(l[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        return ret;
    }
    public static void main(String[] args) {
        LongestCommonString longestCommonString = new LongestCommonString();
        ArrayList<String> ret = longestCommonString.lcsDynamicProgramming("chengl","englisheng");
        for(String s: ret) {
            System.out.println(s);
        }
    }
}

public class KMP {
    public int[] getNextArray(String temp) {
        int len = temp.length();
        int[] next = new int[len];
        int k=-1,i=1;
        next[0]=-1;
        while (i<len-1){
            if(k==-1||temp.charAt(i)==temp.charAt(k)) {
                i++;
                k++;
                next[i]=k;
            } else {
                k=next[k];
            }
        }
        return next;
    }
    public int indexof(String str, String temp) {
        int[] next = getNextArray(temp);
        int i=0,p=0;
        while (i < str.length() && p < temp.length()) {
            if(p==-1||str.charAt(i)==temp.charAt(p)) {
                i++;
                p++;
            } else {
              p = next[p];
            }
        }
        if(p==temp.length()) {
            return i - p;
        }
        return -1;
    }
    public static void main(String[] args){
        String bg = "TCGACGTACGCGCCGCCACG";
        String temp = "CGCGCC";
        KMP kmp = new KMP();
        int index = kmp.indexof(bg, temp);
        System.out.println(index);
    }
}

public class PrimePalindrome {
    public int primePalindrome(int N) {
        while (true) {
            if(isPrime(N)&&isPalindrome(N)) {
                return N;
            }
            N++;
        }
    }
    public boolean isPrime(int N) {
        if (N==1) {
            return false;
        }
        for(int i=2;i <= Math.sqrt(N);i++) {
            if(N % i == 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(int N) {
        String str=Integer.toString(N);
        for(int i=0;i<str.length();i++){
            if (str.charAt(i)!=str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        PrimePalindrome primePalindrome = new PrimePalindrome();
        int leastPP = primePalindrome.primePalindrome(9989900);
        System.out.println(leastPP);
    }
}

class Solution {
    public boolean Find(int target, int [][] array) {
        int i=array.length, j=0;
        while (i >=0 && j < array[0].length) {
            if(array[i][j]==target) {
                return true;
            } else if(array[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}


public class Test {
    public static void main(String[] args) {
        System.out.println(1);
    }
}

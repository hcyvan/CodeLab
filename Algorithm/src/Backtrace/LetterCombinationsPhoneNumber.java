package Backtrace;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> ret=new ArrayList<>();
    private void comb(String digits, StringBuilder stringBuilder) {
        if (digits==""){
            return;
        }
        int index = stringBuilder.length();
        int num = Character.getNumericValue(digits.charAt(index));
        int span = num == 9||num==7 ? 4 : 3;
        int ascii=num > 7 ? (num-2)*3+97 + 1 : (num-2)*3+97;
        for (int i=0;i<span;i++){
            stringBuilder.append((char)(ascii+i));
            if (stringBuilder.length()==digits.length()){
                ret.add(stringBuilder.toString());
            }else{
                comb(digits, stringBuilder);
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        StringBuilder sb=new StringBuilder();
        comb(digits,sb);
        return ret;
    }
}

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args){
        Solution s=new Solution();
        List<String> ret = s.letterCombinations("7");
        for(String str:ret) {
            System.out.println(str);
        }
    }
}

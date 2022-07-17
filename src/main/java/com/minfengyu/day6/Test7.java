package com.minfengyu.day6;

import java.util.HashMap;

public class Test7 {
    public static void main(String[] args) {
        String s = new Test7().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
    public String minWindow(String s,String t){
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            charToCount.put(c,charToCount.getOrDefault(c,0)+1);
        }
        int count=charToCount.size();
        int start=0,end=0,minStart=0,minEnd=0,minLength=Integer.MAX_VALUE;
        while (end<s.length()||(count==0&&end==s.length())){
            if (count>0){
                char endChar = s.charAt(end);
                if (charToCount.containsKey(endChar)){
                    charToCount.put(endChar,charToCount.get(endChar)-1);
                    if (charToCount.get(endChar)==0){
                        count--;
                    }
                }
                end++;
            }else {
                if (end-start<minLength){
                    minLength=end-start;
                    minStart=start;
                    minEnd=end;
                }
                char startCh=s.charAt(start);
                if (charToCount.containsKey(startCh)){
                    charToCount.put(startCh,charToCount.get(startCh)+1);
                    if (charToCount.get(startCh)==1){
                        count++;
                    }
                }
                start++;
            }

        }
        return minLength<Integer.MAX_VALUE? s.substring(minStart,minEnd):"";
    }
}

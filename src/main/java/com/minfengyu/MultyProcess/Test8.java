package com.minfengyu.MultyProcess;

public class Test8 {
    //add two number
}
class Solution {
    public int countSubstrings(String s) {
        if(null==s||s.length()==0){
            return 0;
        }
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=isParam(s,i,i);
            count+=isParam(s,i,i+1);
        }
        return count;
    }

    public int isParam(String s,int start,int end){
        int count=0;
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            count++;
            start++;
            end--;
        }
        return count;
    }

    public static void main(String[] args) {

        int abc = new Solution().countSubstrings("abc");
        System.out.println(abc);
    }
}
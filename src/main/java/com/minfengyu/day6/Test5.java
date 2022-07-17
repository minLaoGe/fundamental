package com.minfengyu.day6;

public class Test5 {
    public static void main(String[] args) {
        int nfpdmpi = new Test5().lengthOfLongestSubstring("nfpdmpi");
        System.out.println(nfpdmpi);
    }
    public int lengthOfLongestSubstring1(String s) {
        int j=0;
        int i=0;
        int length=0;
        int[] counts=new int[256];
        int countDump=0;
        for(;i<s.length();i++){
            counts[s.charAt(i)]++;
            if(counts[s.charAt(i)]==2){
                countDump++;
            }
            while(countDump>0){
                counts[s.charAt(j++)]--;
                System.out.println(s.charAt(j));
                if(counts[s.charAt(j)]==1){
                    countDump--;
                }
            }
            length=Math.max(length,i-j+1);
        }
        return length;
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<0){
            return 0;
        }
        int j=0;
        int i=0;
        int length=0;
        int[] counts=new int[256];
        int countDump=0;
        for(;i<s.length();i++){
            counts[s.charAt(i)]++;
            if(counts[s.charAt(i)]==2){
                countDump++;
            }
            while(countDump>0){
                counts[s.charAt(j++)]--;
                System.out.println(s.charAt(j));
                if(counts[s.charAt(j)]==1){
                    countDump--;
                }
            }
            length=Math.max(length,i-j+1);
        }
        return length;
    }
}

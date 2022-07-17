package com.minfengyu.MultyProcess;

public class asdf {
    public static void main(String[] args) {
        String s = new asdf().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
    public String minWindow(String s, String t) {
        int[] end = new int[56];
        char[] chars = t.toCharArray();
        int left=0;
        int resLeft=0;
        int resRight=0;
        int right=0;
        for (char aChar : chars) {
            ++end[aChar - 'A'];
        }
        char[] scharts = s.toCharArray();
        int index=Integer.MAX_VALUE;

        return null;
    }

    public boolean isCompleate(int[] end){
        for (int i : end) {
            if (i>0){
                return true;
            }
        }
        return false;
    }
}

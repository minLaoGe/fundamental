package com.minfengyu.day6;

public class Test3 {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()){
            return false;
        }
        int[] arr=new int[26];

        for(int i=0;i<s1.length();i++){
            //已经开始加减运算了。
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }
        if(isAllZero(arr)){
            return true;
        }
        for(int j=s1.length();j<s2.length();j++){
            //继续上面的循环进行减法
            arr[s2.charAt(j)-'a']--;

            //这个复原已经运算过的结果
            arr[s2.charAt(j-s1.length())-'a']++;
            if(isAllZero(arr)){
                return true;
            }
        }


        return true;
    }


    public boolean isAllZero(int[] arr1){
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}

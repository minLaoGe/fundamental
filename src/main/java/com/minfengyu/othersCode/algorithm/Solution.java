package com.minfengyu.othersCode.algorithm;

public class Solution {
    public static int singleNumber(int[] nums){
        int[] bitSums=new int[32];
        for (int num:nums){
            for (int i = 0; i < 32; i++) {
             bitSums[i]+=(num>>(31-i))&1;
            }
        }
        int result=0;
        for (int i = 0; i < 32; i++) {
            result=(result<<1)+bitSums[i]%3;
        }
        return result;
    }
    public static int singleNumber2(int[] nums) {
        int[] arr=new int[32];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<32;j++){
                arr[j]=(nums[i]>>j)&1+arr[j];
            }
        }
        int result=0;

        for(int i=0;i<32;i++){
            result= (arr[31-i]%3)+(result<<1);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr={3, 3, 3, 2};
        int i = singleNumber2(arr);
        System.out.println(i);
    }
}

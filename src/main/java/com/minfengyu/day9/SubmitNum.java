package com.minfengyu.day9;

public class SubmitNum {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int divide = new SubmitNum().divide(-2147483648, 1);

        System.out.println(divide);
//        System.out.println(new SubmitNum().divide(15,1));
    }
    public int divide(int dividend, int divisor) {
        if(dividend==(Integer.MAX_VALUE*(-1))-1&&divisor==-1){
            return Integer.MAX_VALUE;
        }


        int negative=2;
        if(dividend>0){
            negative--;
            dividend=-dividend;
        }
        if(divisor>0){
            negative--;
            divisor=-divisor;
        }
        int result=divideCore(dividend,divisor);

        return negative==1? -result:result;
    }
    private int divideCore(int dividend, int divisor){
        int result=0;
        while(dividend<=divisor){
            int value=divisor;
            int quotient=1;
            while(value>=0xc0000000&&dividend<=value+value){
                quotient+=quotient;
                value+=value;
            }
            result+=quotient;
            System.out.println(quotient);
            dividend-=value;
        }
        return result;
    }
}

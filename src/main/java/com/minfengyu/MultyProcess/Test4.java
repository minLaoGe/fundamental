package com.minfengyu.MultyProcess;

public class Test4 {
    private static  int x=0,y=0;
    private static int a=0,b=0;

    public static void main(String[] args) throws Exception {
        //第一种结果 x=0,y=1;
        //第二种结果 y=0,x=1;
        //第三种结果 y=1,x=1;
        int i=0;
        for (;;){
            i++;
            x=0;y=0;
            a=0;b=0;
            Thread t1 = new Thread(() -> {
                try {
                    Thread.sleep(100);
                    a = 1;
                    x = b;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread t2 = new Thread(() -> {
                try {
                    Thread.sleep(100);
                    b = 1;
                    y = a;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            String result="第"+i +"次 ("+x+","+y+")";
            if (x==0&&y==0){
                System.out.println(result);
                break;
            }else{
                System.out.println(result);
            }

        }
    }
}

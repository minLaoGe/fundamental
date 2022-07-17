package com.minfengyu.MultyProcess;

public class Test2 {
    private static  int count=0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    count++;
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
    }
}

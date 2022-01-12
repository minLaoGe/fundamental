package com.minfengyu.nio;

import java.io.*;
import java.nio.channels.FileChannel;

public class ChannelTransferFrom {
    public static void main(String[] args) throws Exception {
        new Thread(()->{
            try {
                ChannelTransferFrom.Thread1();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                ChannelTransferFrom.threa2();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();



    }

    private static void threa2() throws IOException {
        long begin = System.currentTimeMillis();
        FileReader fileReader = new FileReader(new File("./3.pdf"));
        FileWriter fileOutputStream = new FileWriter(new File("./4.pdf"));
        char[] bytes = new char[2048];
        int num=0;
        while ((num=fileReader.read(bytes))!=-1){
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        }
        fileOutputStream.close();
        fileReader.close();
        long end=System.currentTimeMillis();
        System.out.println("time cost T2:"+(end-begin));
    }

    private static void Thread1() throws IOException {
        long begin = System.currentTimeMillis();

        RandomAccessFile rw = new RandomAccessFile("./3.pdf", "rw");
        FileChannel channel = rw.getChannel();

        RandomAccessFile rw1 = new RandomAccessFile("./2.pdf", "rw");
        FileChannel channel1 = rw1.getChannel();

        long size = channel.size();
        long pos=0;
        channel1.transferFrom(channel,0,size);
        long end=System.currentTimeMillis();
        System.out.println("time cost T1:"+(end-begin));
    }
}

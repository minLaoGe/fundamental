package com.minfengyu.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelExample {

    public static void main(String[] args) throws Exception {
        RandomAccessFile rw = new RandomAccessFile("/Users/minfengyu/files/1.php", "rw");
        FileChannel channel = rw.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(11);
        int read = channel.read(allocate);
        while (read!=-1){
            System.out.println("Read"+read);
//            allocate.flip();
            while (allocate.hasRemaining()){
                System.out.println((char)allocate.get());
            }
            allocate.clear();
           read= channel.read(allocate);
        }
        rw.close();
    }
}

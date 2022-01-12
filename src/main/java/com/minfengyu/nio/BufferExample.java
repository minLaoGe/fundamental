package com.minfengyu.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferExample {
    public static void main(String[] args) throws Exception {
        RandomAccessFile rw = new RandomAccessFile("/Users/minfengyu/files/1.php", "rw");
        FileChannel channel = rw.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(9);
        int read = channel.read(allocate);
        while (read!=-1){
            System.out.println("read+"+read);
            allocate.flip();
            while (allocate.hasRemaining()){
                System.out.println((char) allocate.get());
            }
//            allocate.clear();
            System.out.println("limit"+allocate.limit());
            allocate.rewind();
            read=channel.read(allocate);
        }
        rw.close();
    }
}

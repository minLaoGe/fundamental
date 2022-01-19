package com.minfengyu.nio;

import lombok.SneakyThrows;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class FileChannel {
    @SneakyThrows
    public static void main(String[] args) {
        String newData="New String to write to file..."+System.currentTimeMillis();
        RandomAccessFile file = new RandomAccessFile("./test.text", "rw");
        java.nio.channels.FileChannel channel = file.getChannel();
        ByteBuffer allocate = ByteBuffer.allocate(newData.getBytes(StandardCharsets.UTF_8).length);
//        allocate.clear();
        allocate.put(newData.getBytes(StandardCharsets.UTF_8));
        allocate.flip();
//        allocate.flip();
        while (allocate.hasRemaining()) {
            channel.write(allocate);
        }
        channel.close();;
    }
}

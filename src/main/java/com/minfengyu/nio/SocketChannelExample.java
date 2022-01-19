package com.minfengyu.nio;

import lombok.SneakyThrows;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

//Clinet
public class SocketChannelExample {
    @SneakyThrows
    public static void main(String[] args) {
        SocketChannel open = SocketChannel.open();
        open.connect(new InetSocketAddress("http://jenkov.com",9000));
        ByteBuffer allocate = ByteBuffer.allocate(1024 * 1024 * 3);
        allocate.clear();

        open.read(allocate);

        while (allocate.hasRemaining()){
            System.out.print((char)allocate.get());
        }
        open.close();;
    }
}

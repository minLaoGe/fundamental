package com.minfengyu.nio;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

// Server
public class ServerSocketChannelExample {
    @SneakyThrows
    public static void main(String[] args) {
        ServerSocketChannel open = ServerSocketChannel.open();
        open.socket().bind(new InetSocketAddress(9999));
        // set Non-blocked ;
        open.configureBlocking(false);
        while (true){
            // Thus, the accept() method blocks until an incoming connection arrives.
            SocketChannel accept = open.accept();
            if (accept!=null){
                byte[] bytes = new byte[2048];
                InputStream inputStream = accept.socket().getInputStream();
                int numb=0;
                while ((numb=inputStream.read(bytes))!=-1){
                    System.out.println(new String(bytes,numb));
                }

            }
        }

    }
}

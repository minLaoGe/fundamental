package com.minfengyu.nio;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class SelectorExample {
    @SneakyThrows
    public static void main(String[] args) {
        Selector selector = Selector.open();
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.socket().bind(new InetSocketAddress(80));
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocketChannel ssChannel1 = ServerSocketChannel.open();
        ssChannel1.configureBlocking(false);
        ssChannel1.socket().bind(new InetSocketAddress(81));
        ssChannel1.register(selector, SelectionKey.OP_ACCEPT);
        while (true){

            int num = selector.selectNow();
            System.out.println("numbers"+num);
            mytest(ssChannel,selector);

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                if (next.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector,SelectionKey.OP_READ);
                    System.out.println("接收到一个socket");
                }else  if (next.isReadable()){
                    SocketChannel sChannel = (SocketChannel) next.channel();
                    System.out.println(readDataFromSocketChannel(sChannel));
                    sChannel.close();
                }
                 iterator.remove();
            }

        }
    }

    private static void mytest(ServerSocketChannel ssChannel,Selector selector) {
        SelectionKey selectionKey = ssChannel.keyFor(selector);
        System.out.println(selectionKey.interestOps());

    }

    private static String readDataFromSocketChannel(SocketChannel socketChannel) throws IOException{
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();
        while (true){
            allocate.clear();
            int read = socketChannel.read(allocate);
            if (read<0){
                break;
            }
            allocate.flip();
            int limit = allocate.limit();
            char[] chars = new char[limit];
            for (int i = 0; i < limit; i++) {
                chars[i]=(char) allocate.get(i);
            }
            data.append(chars);
            allocate.clear();
        }
        return  data.toString();
    }
}

class Clinet{
    @SneakyThrows
    public static void main(String[] args) {
        Socket socket = new Socket("127.0.0.1", 80);
        OutputStream outputStream = socket.getOutputStream();
        String helloworld="helloWorld";
        outputStream.write(helloworld.getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }
}
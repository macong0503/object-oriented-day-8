package com.hqyj.mc.Test.TCPtest01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
TCP通信的服务器端：接收客户端的请求，读取客户端的请求，给客户端回写一个数据
表示服务器端的类：
java.net.ServerSocket
构造方法：
public ServerSocket(int port)throws IOException创建绑定到指定端口的服务器套接字。
成员方法：
public Socket accept() throws IOException侦听要连接到此套接字并接受它。 该方法将阻塞直到建立连接。
public InputStream getInputStream() throws IOException返回此套接字的输入流。
public OutputStream getOutputStream()throws IOException返回此套接字的输出流。
public void close()throws IOException关闭此套接字。
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        OutputStream os = socket.getOutputStream();
        os.write("收到".getBytes());
        socket.close();


    }
}

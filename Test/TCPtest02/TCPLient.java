package com.hqyj.mc.Test.TCPtest02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPLient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("D:\\1.jpg");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        //解决堵塞
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes))!=-1){
            System.out.println(new String(bytes));
        }
        fis.close();
        socket.close();
    }
}

package com.hqyj.mc.Test.TCPtest02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        /**
         * 让服务器处于监听状态，死循环accept方法
         * 有一个客户端上传文件，就是开启一个线程，就保存到我的服务器中，完成上传文件
         */
        while (true) {
            Socket socket = ss.accept();
            FileOutputStream fos = null;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        //判断d:\\upload文件夹是否存在，不存在创建
                        File file = new File("d:\\upload");
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        /**
                         * 自定义一个文件名的命名规范：防止同名文件被覆盖
                         * 规则：域名+毫秒值+随机数
                         */
                        String fileName = "hqyj" + System.currentTimeMillis() + new Random().nextInt(9999999) + ".jpg";
                        FileOutputStream fos = new FileOutputStream(file + "\\" + fileName);
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        while ((len = is.read(bytes)) != -1) {
                            fos.write(bytes, 0, len);
                        }
                        OutputStream os = socket.getOutputStream();
                        os.write("上传成功".getBytes());
                        fos.close();
                        socket.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}


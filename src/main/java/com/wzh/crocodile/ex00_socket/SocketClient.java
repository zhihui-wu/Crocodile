package com.wzh.crocodile.ex00_socket;

import java.io.*;
import java.net.Socket;

/**
 * @Description: 套接字对象
 * @Author: 吴智慧
 * @Date: 2019/11/7 11:12
 */
public class SocketClient {

//    private final static Logger LOGGER = Logger.getLogger(SocketClient.class);

    public static void client() throws IOException {
        // 套接字对象，创建客户端
        Socket socket = new Socket("127.0.0.1", 8081);
//        LOGGER.info("客户端启动成功");
        System.out.println("客户端启动成功");

        // 输出对象，用于发送请求
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);

        // 发送request
        out.println("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection: Close");
        out.println();

        // 关闭网络资源
        out.close();
        socket.close();
    }

}

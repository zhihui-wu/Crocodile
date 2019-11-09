package com.wzh.crocodile.ex00_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: socket服务端
 * @Author: 吴智慧
 * @Date: 2019/11/7 13:10
 */
public class SocketService {

//    private final static Logger LOGGER = Logger.getLogger(SocketService.class);

    public static void service() throws IOException {
        // 创建服务器
        ServerSocket server = new ServerSocket(8081, 1, InetAddress.getByName("127.0.0.1"));
//        LOGGER.info("服务器启动成功");
        System.out.println("服务器启动成功");

        // 等待客户端连接，接收客户端socket
        Socket socket = server.accept();

        // 获取客户端socket的输入流
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // 读取response
        boolean loop = true;
        StringBuilder sb = new StringBuilder(8096);
        while (loop) {
            if (in.ready()) {
                int i = 0;
                while (i != -1){
                    i = in.read();
                    sb.append((char)i);
                }
                loop = false;
            }
        }
        System.out.println(sb.toString());

        // 关闭网络资源
        in.close();
        socket.close();
        server.close();


    }

}

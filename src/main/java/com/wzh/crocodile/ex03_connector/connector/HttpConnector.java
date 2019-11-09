package com.wzh.crocodile.ex03_connector.connector;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 连接器
 * @Author: 吴智慧
 * @Date: 2019/11/9 10:03
 */
public class HttpConnector implements Runnable {

    private boolean stopped = false;

    private String scheme = "http";

    public String getScheme(){
        return this.scheme;
    }

    public void start() {
        // 创建新的线程
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // 监听端口
        ServerSocket serverSocket = null;
        int port = 8081;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        // 轮询等待请求
        while (!stopped){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            // 创建请求处理类
            HttpProcessor processor = new HttpProcessor(this);
            // 交由请求处理类处理
            processor.process(socket);
        }
    }

}

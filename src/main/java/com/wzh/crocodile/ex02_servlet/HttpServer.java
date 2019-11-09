package com.wzh.crocodile.ex02_servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 服务器
 * @Author: 吴智慧
 * @Date: 2019/11/7 14:06
 */
public class HttpServer {

    /**
     * 命令：关闭服务器
     */
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    /**
     * 服务器状态，是否关闭
     * false:启动状态
     * true:关闭状态
     */
    private boolean shutdown = false;

    /**
     * 监听端口，处理请求
     */
    private void await() {
        ServerSocket serverSocket = null;
        Integer port = 8081;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        while (!shutdown){
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                // 创建request对象，并解析
                Request request = new Request(input);
                request.parse();

                // 创建response对象，并响应
                Response response = new Response(output);
                response.setRequest(request);

                // 检查请求静态文件，还是请求servlet类
                if (request.getUri().startsWith("/servlet/")) {
                    ServletProcessor servletProcessor = new ServletProcessor();
                    servletProcessor.process(request, response);
                }else {
                    StaticResourceProcessor staticResourceProcessor = new StaticResourceProcessor();
                    staticResourceProcessor.process(request, response);
                }

                // 关闭套接字
                socket.close();

                // 检查是否为关闭服务器命令
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }


}

package com.wzh.crocodile.ex03_connector.connector;

import com.wzh.crocodile.ex03_connector.connector.HttpConnector;
import com.wzh.crocodile.ex03_connector.connector.HttpRequest;
import com.wzh.crocodile.ex03_connector.connector.HttpResponse;
import com.wzh.crocodile.ex03_connector.connector.SocketInputStream;
import com.wzh.crocodile.ex03_connector.core.ServletProcessor;
import com.wzh.crocodile.ex03_connector.core.StaticResourceProcessor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description: socket处理类
 * @Author: 吴智慧
 * @Date: 2019/11/9 10:30
 */
public class HttpProcessor {

    private HttpRequest request;

    private HttpResponse response;

    private HttpConnector connector;

    public HttpProcessor(HttpConnector connector){
        this.connector = connector;
    }

    public void process(Socket socket){
        SocketInputStream input = null;
        OutputStream output = null;
        try {
            // 获取请求的套接字的输入流输出流
            input = new SocketInputStream(socket.getInputStream(), 2048);
            output = socket.getOutputStream();

            // 使用输出流，创建请求对象
            request = new HttpRequest(output);

            // 使用输入流，创建响应对象
            response = new HttpResponse(input);
            response.setRequest(request);
            // 向客户端发送响应头信息
            response.setHeader("Server", "Pyrmont Servlet Container");

            // 解析请求
            parseRequest(input, output);
            parseHeader(input);

            // 根据请求的URI模式，不同模式，发送给不同处理类处理
            if (request.getRequestUri().startsWith("/servlet/")){
                // 用于处理servlet类的请求
                ServletProcessor processor = new ServletProcessor();
                processor.process(request, response);
            }else {
                // 用于处理静态资源的请求
                StaticResourceProcessor processor = new StaticResourceProcessor();
                processor.process(request, response);
            }

            // 关闭套接字资源
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseHeader(SocketInputStream input) {

    }

    private void parseRequest(SocketInputStream input, OutputStream output) {

    }
}

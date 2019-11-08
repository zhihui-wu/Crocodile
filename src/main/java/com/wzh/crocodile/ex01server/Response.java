package com.wzh.crocodile.ex01server;

import com.wzh.crocodile.ex01server.HttpServer;
import com.wzh.crocodile.ex01server.Request;

import java.io.*;

/**
 * @Description: Http响应
 * @Author: 吴智慧
 * @Date: 2019/11/7 15:00
 */
public class Response {

    /**
     * 一次读取信息的容量
     */
    private static final int BUFFER_SIZE = 1024;

    /**
     * http请求
     */
    private Request request;

    /**
     * 从socket对象中获取的，用于创建Response对象
     * 其中包含HTTP响应的结果
     */
    private OutputStream output;

    public Response(OutputStream output){
        this.output = output;
    }

    public void setRequest(Request request){
        this.request = request;
    }

    /**
     * 发送一个静态资源到浏览器，如html文件
     */
    public void sendStaticResource() {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            // 打开文件
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()){
                // 文件存在，读取文件，写入Response响应的结果
                // 打开输入流
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1){
//                    StringBuilder stringBuilder = new StringBuilder();
//                    for (int i = 0; i < ch; i++){
//                        stringBuilder.append((char)bytes[i]);
//                    }
//                    System.out.println(stringBuilder.toString());
                    output.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            }else {
                // 文件不存在，将错误信息，写入Response响应的结果
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type: test/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                output.write(errorMessage.getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

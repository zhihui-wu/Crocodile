package com.wzh.crocodile.ex01_server;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: Http请求
 * @Author: 吴智慧
 * @Date: 2019/11/7 14:33
 */
public class Request {

    /**
     * 从socket对象中获取的，用于创建Request对象
     * 其中包含HTTP请求的原始数据
     */
    private InputStream input;

    /**
     * 统一资源标识符
     */
    private String uri = "/index.html";

    public  Request(InputStream input){
        this.input = input;
    }

    /**
     * 解析Http请求中的原始数据，读取整个字节流，转换为string字符串
     */
    public void parse(){
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++){
            request.append((char) buffer[j]);
        }
        System.out.println(request.toString());

        // 解析uri
        if (parseUri(request.toString()) != null){
            uri = parseUri(request.toString());
        }
    }

    private String parseUri(String requestString){
        int index1, index2;
        index1 = requestString.indexOf(' ');
        if (index1 != -1){
            index2 = requestString.indexOf(' ', index1 + 1);
            if (index2 > index1){
                return requestString.substring(index1 + 1, index2);
            }
        }
        return null;
    }

    public String getUri(){
        return uri;
    }
}

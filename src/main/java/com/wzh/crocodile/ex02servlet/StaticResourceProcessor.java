package com.wzh.crocodile.ex02servlet;

import java.io.IOException;

/**
 * @Description: 处理静态资源的请求
 * @Author: 吴智慧
 * @Date: 2019/11/8 14:20
 */
public class StaticResourceProcessor {

    public void process(Request request, Response response){
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

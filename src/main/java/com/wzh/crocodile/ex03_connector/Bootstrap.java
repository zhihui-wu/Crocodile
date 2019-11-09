package com.wzh.crocodile.ex03_connector;

import com.wzh.crocodile.ex03_connector.connector.HttpConnector;

/**
 * @Description: 启动类
 * @Author: 吴智慧
 * @Date: 2019/11/9 10:01
 */
public final class Bootstrap {

    public static void main(String[] args) {
        // 创建连接器
        HttpConnector connnector = new HttpConnector();
        // 启动连接器
        connnector.start();
    }

}

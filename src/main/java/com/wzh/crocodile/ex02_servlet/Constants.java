package com.wzh.crocodile.ex02_servlet;

import java.io.File;

/**
 * @Description: 常量类
 * @Author: 吴智慧
 * @Date: 2019/11/8 13:45
 */
public class Constants {

    /**
     * 服务器用于存放静态资源的路径，如：html
     * 该目录在当前工程目录下
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
}

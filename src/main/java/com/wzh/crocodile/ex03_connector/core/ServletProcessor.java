package com.wzh.crocodile.ex03_connector.core;

import com.wzh.crocodile.ex02_01_facade.*;
import com.wzh.crocodile.ex03_connector.connector.HttpRequest;
import com.wzh.crocodile.ex03_connector.connector.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @Description: 处理对servlet资源的请求
 * @Author: 吴智慧
 * @Date: 2019/11/8 14:22
 */
public class ServletProcessor {

    public void process(HttpRequest request, HttpResponse response){
        // 获取uri
        String uri = request.getRequestUri();
        // 获取servlet类名
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        // 创建类载入器实例
        URLClassLoader loader = null;
        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Constants.WEB_ROOT);

            // 类载入器查找servlet类的目录成为仓库（repository）
            // 只需要查找一个位置，即工作目录下的webroot目录
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();

            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 载入servlet类
        Class myClass = null;
        try {
            myClass = loader.loadClass(servletName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 创建已载入的servlet类的一个实例，并调用service()方法
//        Servlet servlet = null;
//        RequestFacade requestFacade = new RequestFacade(request);
//        ResponseFacade responseFacade = new ResponseFacade(response);
//        try {
//            servlet = (Servlet) myClass.newInstance();
//            servlet.service(requestFacade, responseFacade);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

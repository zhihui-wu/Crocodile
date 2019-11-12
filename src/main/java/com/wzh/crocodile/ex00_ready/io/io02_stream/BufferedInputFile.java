package com.wzh.crocodile.ex00_ready.io.io02_stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description: 打开一个文件用于字符输入
 * @Author: 吴智慧
 * @Date: 2019/11/12 15:58
 */
public class BufferedInputFile {

    public static String read(String filename) throws IOException {
        // 可以使用String或File对象构建FileReader对象
        // 为了提高速度，对文件进行缓存，使用BufferedReader进行包装
        BufferedReader in = new BufferedReader(new FileReader(filename));

        String s;
        StringBuilder sb = new StringBuilder();
        // 遍历读取每一行数据
        while ((s = in.readLine())!= null){
            sb.append(s + "\n");
        }
        // 关闭文件
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        // 文件绝对路径
        // 项目根路径：System.getProperty("user.dir")
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\wzh\\crocodile\\ex00_ready\\io\\io02_stream\\BufferedInputFile.java";
        System.out.println(read(path));
    }
}

package com.wzh.crocodile.ex00_ready.io.io02_stream;

import java.io.IOException;
import java.io.StringReader;

/**
 * @Description: 从内存输入
 * @Author: 吴智慧
 * @Date: 2019/11/12 17:06
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        // 文件绝对路径
        // 项目根路径：System.getProperty("user.dir")
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\wzh\\crocodile\\ex00_ready\\io\\io02_stream\\MemoryInput.java";
        // 打开一个文件用于字符输入
        String content = BufferedInputFile.read(path);
        // 使用内存中的字符串，创建StringReader对象
        StringReader in = new StringReader(content);
        int c;
        // 遍历读取字符
        while ((c = in.read()) != -1){
            System.out.print((char)c);
        }
    }
}

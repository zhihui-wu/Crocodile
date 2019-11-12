package com.wzh.crocodile.ex00_ready.io.io02_stream;

import java.io.*;

/**
 * @Description: 基本的文件输出
 * @Author: 吴智慧
 * @Date: 2019/11/12 17:55
 */
public class BasicFileOutput {

    /**
     * 输出的文件
     */
    static String file = System.getProperty("user.dir") + "\\src\\main\\java\\com\\wzh\\crocodile\\ex00_ready\\io\\io02_stream\\BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        // 文件绝对路径
        // 项目根路径：System.getProperty("user.dir")
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\wzh\\crocodile\\ex00_ready\\io\\io02_stream\\BasicFileOutput.java";
        // 打开一个文件用于字符输入
        String content = BufferedInputFile.read(path);
        // 使用内存中的字符串，创建BufferedReader对象
        BufferedReader in = new BufferedReader(new StringReader(content));
        // 使用文件名，创建Writer对象
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        // 遍历输出文件内容
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null){
            out.println(lineCount++ + ": " + s);
        }
        // 关闭文件
        // 如果不为所有的输入文件调用close()，就会发现缓冲区内容不会被刷新清空，内容将不完整
        out.close();
        // 查看输出文件
        System.out.println(BufferedInputFile.read(file));
    }
}

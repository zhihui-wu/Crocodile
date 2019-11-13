package com.wzh.crocodile.ex00_ready.io.io02_stream;

import java.io.*;

/**
 * @Description: 存储和恢复数据
 * @Author: 吴智慧
 * @Date: 2019/11/13 09:31
 */
public class StoringAndRecoveringData {

    /**
     * 文件路径
     */
    private static String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\wzh\\crocodile\\ex00_ready\\io\\io02_stream\\Data.txt";

    public static void main(String[] args) throws IOException {
        // 打开输出流，输出数据到指定文件
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        // 打开输入流，读取文件内容
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
    // 我们需要知道文件内容地排版，此处的存储和恢复数据相对粗糙；对象序列化和XML可能是更容易地存储和读取复杂数据结构和方式
}

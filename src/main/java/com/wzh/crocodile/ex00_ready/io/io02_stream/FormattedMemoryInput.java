package com.wzh.crocodile.ex00_ready.io.io02_stream;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @Description: 格式化的内存输入
 * @Author: 吴智慧
 * @Date: 2019/11/12 17:14
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        // 文件绝对路径
        // 项目根路径：System.getProperty("user.dir")
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\wzh\\crocodile\\ex00_ready\\io\\io02_stream\\FormattedMemoryInput.java";
        // 打开一个文件用于字符输入
        String content = BufferedInputFile.read(path);
        try {
            // 使用内存中的字符串，创建DataInputStream对象
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(content.getBytes()));
            // 遍历输出内容
            while (true){
                System.out.println((char)in.readByte());
            }
        }catch (EOFException e){
            // 读到文件尾，则输出提示
            System.out.println("End of stream");
        }
        // 此处使用捕获异常来检测输入的末尾；
        // 但是，使用异常来进行流控制，被认为是对异常特性的错误使用
    }
}

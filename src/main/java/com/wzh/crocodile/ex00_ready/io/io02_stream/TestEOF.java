package com.wzh.crocodile.ex00_ready.io.io02_stream;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @Description: 格式化的内存输入（查看还有多少可供读取的字符）(同 FormattedMemoryInput.java 文件)
 * @Author: 吴智慧
 * @Date: 2019/11/12 17:39
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        // 文件绝对路径
        // 项目根路径：System.getProperty("user.dir")
        String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\wzh\\crocodile\\ex00_ready\\io\\io02_stream\\TestEOF.java";
        // 打开一个文件用于字符输入
        String content = BufferedInputFile.read(path);
        // 使用内存中的字符串，创建DataInputStream对象
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(content.getBytes()));
        // available()的工作方式会随着所读取的媒介类型的不同而有所不同
        // 字面意思就是“在没有阻塞的情况下所能读取的字节数”
        // 对于文件，这意味着整个文件；但是对于不同类型的流，可能不是这样，应谨慎使用
        while (in.available() != 0){
            System.out.print((char)in.readByte());
        }
    }
}

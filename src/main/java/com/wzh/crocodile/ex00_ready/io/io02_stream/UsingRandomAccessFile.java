package com.wzh.crocodile.ex00_ready.io.io02_stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description: 读写随机访问文件
 * @Author: 吴智慧
 * @Date: 2019/11/13 09:48
 */
public class UsingRandomAccessFile {

    /**
     * 文件路径
     */
    private static String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\wzh\\crocodile\\ex00_ready\\io\\io02_stream\\rtest.dat";

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(path, "rw");
        // 写入数据
        for (int i = 0; i < 7; i ++){
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("The end of the file");
        // 查找位置
        // double总是8字节长，用seek()查找第五个双精度值
        rf.seek(5 * 8);
        // 修改数据（覆盖所在位置）
        rf.writeDouble(47.0001);
        rf.close();
        // 读取数据，展示结果
        display();
    }

    /**
     * 读取数据，展示结果
     * @throws IOException
     */
    private static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(path, "r");
        for (int i = 0; i < 7; i++){
            System.out.println(
                    "Value " + i + ": " + rf.readDouble()
            );
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

}

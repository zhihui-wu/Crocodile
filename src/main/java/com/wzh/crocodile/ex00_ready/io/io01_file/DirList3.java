package com.wzh.crocodile.ex00_ready.io.io01_file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description: 目录列表
 * @Author: 吴智慧
 * @Date: 2019/11/11 11:27
 */
public class DirList3 {

    /**
     * 主函数
     * @param args 第一个参数可为正则表达式字符串
     */
    public static void main(final String[] args) {
        // 创建文件/目录对象（"."表示当前文件夹，在IDEA中运行指项目文件夹，可以运行试一下）
        final File path = new File(".");
        String[] list;
        // 判断是否传入正则表达式
        if (args.length == 0){
            list = path.list();
        }else {
            // 获取受限文件名列表，使用匿名类目录过滤器，回调函数过滤结果
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        if (list == null){
            System.exit(1);
        }
        // 数组排序，忽略字符串大小写
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        // 输出列表
        for (String dirName : list){
            System.out.println(dirName);
        }
    }
}

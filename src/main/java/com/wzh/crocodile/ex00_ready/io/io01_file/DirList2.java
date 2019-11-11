package com.wzh.crocodile.ex00_ready.io.io01_file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description: 目录列表(使用匿名类)
 * @Author: 吴智慧
 * @Date: 2019/11/11 11:04
 */
public class DirList2 {

    /**
     * 获取目录过滤器
     * @param regex 正则表达式字符串
     * @return 目录过滤器对象
     * PS：filter的参数必须是final的。这在匿名内部类中是必须的，这样它才能够使用来自该类范围之外的对象
     */
    public static FilenameFilter filter(final String regex){
        // 创建匿名内部类
        return new FilenameFilter() {
            /**
             * 匹配模式
             */
            private Pattern pattern = Pattern.compile(regex);

            /**
             * 回调函数，用于过滤文件列表
             * @param dir 目录对象
             * @param name 文件名
             * @return
             */
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }

    /**
     * 主函数
     * @param args 第一个参数可为正则表达式字符串
     */
    public static void main(String[] args) {
        // 创建文件/目录对象（"."表示当前文件夹，在IDEA中运行指项目文件夹，可以运行试一下）
        File path = new File(".");
        String[] list;
        // 判断是否传入正则表达式
        if (args.length == 0){
            // 获取所有文件名列表
            list = path.list();
        }else {
            // 获取受限文件名列表，使用目录过滤器，回调函数过滤结果
            list = path.list(filter(args[0]));
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

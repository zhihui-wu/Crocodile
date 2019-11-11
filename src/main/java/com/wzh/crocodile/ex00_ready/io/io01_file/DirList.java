package com.wzh.crocodile.ex00_ready.io.io01_file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Description: 目录列表
 * @Author: 吴智慧
 * @Date: 2019/11/11 10:18
 */
public class DirList {

    /**
     * 主函数
     * @param args 第一个参数可为正则表达式字符串
     */
    public static void main(String[] args) {
        // 创建文件对象（既能指一个特定文件的名称，又能指一个目录下的一组文件）
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        }else {
            // 使用DirFilter提供的回调函数accept()方法，对文件列表进行过滤
            list = path.list(new DirFilter(args[0]));
        }
        // 数组排序，忽略字符串大小写
        if (list == null){
            System.exit(1);
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        // 输出列表
        for (String dirItem : list){
            System.out.println(dirItem);
        }
    }

}

/**
 * @Description: 目录过滤器
 * @Author: 吴智慧
 * @Date: 2019/11/11 10:18
 */
class DirFilter implements FilenameFilter {

    /**
     * 正则匹配模式
     */
    private Pattern pattern;

    /**
     * 构造函数
     * @param regex
     */
    public DirFilter(String regex) {
        // 根据正则表达式字符串生成匹配模式对象
        this.pattern = Pattern.compile(regex);
    }

    /**
     * 回调函数
     * @param dir 目录对象
     * @param name 文件名
     * @return
     */
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}

package com.wzh.crocodile.ex00_ready.io.io01_file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Description: 目录实用工具
 * @Author: 吴智慧
 * @Date: 2019/11/11 13:44
 */
public class Directory {

    public static File[] local(File dir, final String regex){
        // 使用File.list()的变体listFile()来产生File数组
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }

    public static File[] local(String path, final String regex){
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll (TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "TreeInfo{" +
                    "files=" + files +
                    ", dirs=" + dirs +
                    '}';
        }
    }

    /**
     * 主函数
     * @param args 参数为文件/目录路径
     */
    public static void main(String[] args) {
        // 是否存入参数
        if (args.length == 0) {
            // 没有参数，传入当前文件目录
            System.out.println(walk("."));
        }else {
            // 有参数，则遍历参数，传入参数
            for (String arg : args){
                System.out.println(walk(arg));
            }
        }
    }

    private static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    private static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    /**
     * 调用recurseDirs
     * @param start 文件/目录路径
     * @return
     */
    private static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    private static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    /**
     * 递归遍历目录
     * @param startDir 文件/目录对象
     * @param regex 正则表达式字符串
     * @return
     */
    static TreeInfo recurseDirs(File startDir, String regex){
        TreeInfo result = new TreeInfo();
        // 遍历指定文件/目录下的文件
        for (File item : startDir.listFiles()){
            // 如果是目录
            if (item.isDirectory()){
                // 存入目录列表
                result.dirs.add(item);
                // 深入子目录继续遍历
                result.addAll(recurseDirs(item, regex));
            }else {
                // 不是目录，且文件名符合正则匹配的
                if (item.getName().matches(regex)){
                    // 存入文件列表
                    result.files.add(item);
                }
            }
        }
        return result;
    }
}

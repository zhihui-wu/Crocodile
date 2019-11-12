package com.wzh.crocodile.ex00_ready.io.io01_file;

import java.io.File;

/**
 * @Description: 目录的检查与创建
 * @Author: 吴智慧
 * @Date: 2019/11/12 14:12
 */
public class MakeDirectories {

    /**
     * 默认运行方法，无实际操作
     */
    private static void usage(){
        System.out.println(
                "Usage:MakeDirectories path1...\n" +
                "Creates each path\n" +
                "Usage:MakeDirectories -d path1...\n" +
                "Deletes each path\n" +
                "Usage:MakeDirectories -r path1 path2\n" +
                "Renames from path1 to path2"
        );
        System.exit(1);
    }

    /**
     * 通过多种不同的文件特征查询方法输出文件或目录路径的信息
     * @param f 文件/目录对象
     */
    private static void fileDate(File f) {
        System.out.println(
                // 绝对路径
                "Absolute path: " + f.getAbsolutePath() +
                // 读权限
                "\n Can read: " + f.canRead() +
                // 写权限
                "\n Can write: " + f.canWrite() +
                // 获取文件名
                "\n getName: " + f.getName() +
                // 获取...
                "\n getParent: " + f.getParent() +
                // 获取...
                "\n getPath: " + f.getPath() +
                // 长度...
                "\n length: " + f.length() +
                // 上次改动时间
                "\n lastModified: " + f.lastModified()
        );
        if (f.isFile()){
            System.out.println("It's a file");
        }else if (f.isDirectory()){
            System.out.println("It's a directory");
        }
    }

    public static void main(String[] args) {
        // 没有参数，运行默认方法
        if (args.length < 1){
            usage();
        }
        // 有参数，移动/重命名命令，如 -r [旧文件名] [新文件名]
        if (args[0].equals("-r")){
            // 如果参数个数不为三个，则运行默认方法
            if (args.length != 3){
                usage();
            }
            // 为旧文件名，新文件名分别创建文件对象
            File old = new File(args[1]), rname = new File(args[2]);
            // 将一个文件重命名（或移动）到由参数所指示的另一个完全不同的新路径（也就是另一个File对象）下面
            old.renameTo(rname);
            //
            fileDate(old);
            fileDate(rname);
            return;
        }
        int count = 0;
        boolean del = false;
        // 有参数，删除命令，如 -d [文件名] [文件名] ...
        if (args[0].equals("-d")){
            count ++;
            del = true;
        }
        count--;
        // 遍历参数，分别操作
        while(++count < args.length){
            File f = new File(args[count]);
            // 如果文件存在，且为删除命令
            if (f.exists()){
                System.out.println(f + " exists");
                // 则删除
                if (del){
                    System.out.println("deleting ... " + f);
                    f.delete();
                }
            }else {
                // 如果不存在，且不为删除命令
                if (!del){
                    // 则新建文件
                    f.mkdir();
                    System.out.println("created " + f);
                }
            }
            fileDate(f);
        }
    }
}

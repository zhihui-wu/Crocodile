package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 使用ThreadFactory创建ExecutorService对象
 * @Author: 吴智慧
 * @Date: 2019/11/16 19:21
 */
public class DaemonFromFactory implements Runnable{
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 每个静态的ExecutorService创建方法都被重载为接受一个ThreadFactory对象
        // 这个对象将被用来创建新的线程
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++){
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        exec.shutdown();
        TimeUnit.MILLISECONDS.sleep(500);
    }
}

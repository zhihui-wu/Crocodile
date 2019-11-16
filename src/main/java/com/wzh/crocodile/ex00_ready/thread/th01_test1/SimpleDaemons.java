package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 设定后台线程
 * @Author: 吴智慧
 * @Date: 2019/11/16 19:02
 */
public class SimpleDaemons implements Runnable {

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
        for (int i = 0; i < 10; i++){
            Thread daemon = new Thread(new SimpleDaemons());
            // 必须在线程启动之前调用setDaemon()方法，才能把它设置为后台程序
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        // 一旦main()线程终止，则其余后台线程都会一起终止
        // 将main()线程暂时休眠，可以观察到后台程序的输出
        TimeUnit.MILLISECONDS.sleep(175);
    }
}

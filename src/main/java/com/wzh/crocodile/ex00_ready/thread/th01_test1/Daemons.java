package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.concurrent.TimeUnit;

/**
 * 用于创建后台线程
 */
class Daemon implements  Runnable{
    private Thread[] t = new Thread[10];
    @Override
    public void run() {
        for (int i = 0; i < t.length; i++){
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("DaemonSpawn " + i + " started");
        }
        for (int i = 0; i < t.length; i++){
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon());
        }
        while (true){
            Thread.yield();
        }
    }
}

/**
 * 用于后台线程创建派生的子线程
 */
class DaemonSpawn implements Runnable{
    @Override
    public void run() {
        while (true){
            Thread.yield();
        }
    }
}

/**
 * @Description: 如果是一个后台线程，那么它创建的任何线程都将被自动设置成后台线程
 * @Author: 吴智慧
 * @Date: 2019/11/16 19:40
 */
public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        // 调用isDaemon()方法来确定线程是否是一个后台线程
        System.out.println("d.isDaemon() = " + d.isDaemon() + ". ");
        TimeUnit.SECONDS.sleep(2);
    }
}

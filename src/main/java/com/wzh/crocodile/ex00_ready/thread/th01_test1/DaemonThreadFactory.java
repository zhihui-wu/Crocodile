package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.concurrent.ThreadFactory;

/**
 * @Description: 通过编写定制的ThreadFactory可以定制由Executor创建的线程的属性（后台、优先级、名称）
 * @Author: 吴智慧
 * @Date: 2019/11/16 19:15
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        // 设置为后台线程
        t.setDaemon(true);
        return t;
    }
}

package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.concurrent.*;

/**
 * @Description: TODO
 * @Author: 吴智慧
 * @Date: 2019/11/16 19:33
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                new DaemonThreadFactory());
    }
}

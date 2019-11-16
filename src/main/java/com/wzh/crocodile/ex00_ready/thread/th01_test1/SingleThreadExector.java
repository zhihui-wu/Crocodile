package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: SingleThreadExector就像是线程数量为1的FixedThreadPool
 * @Author: 吴智慧
 * @Date: 2019/11/16 16:03
 */
public class SingleThreadExector {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        // 如果向SingleThreadExecutor提交了多个任务，那么这些任务将排队。
        // 每个任务都会在上一个任务运行结束后开始运行，所有任务都使用相同的线程
        // SingleThreadExecutor会序列化所有提交给它的任务，并维护（隐藏）的悬挂任务队列
        for (int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}

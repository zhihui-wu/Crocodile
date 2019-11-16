package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 使用Executor管理Thread对象
 * @Author: 吴智慧
 * @Date: 2019/11/16 15:25
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        // ExecutorService知道如何构建恰当的上下文来执行Runnable对象
        // CachedThreadPool在程序执行过程中通常会创建与所需数量相同的线程,
        // 然后在它收回旧线程时停止创建新线程。
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            // 为每个任务都创建一个线程
            exec.execute(new LiftOff());
        }
        // shutdown()方法的调用可以防止创新任务被提交给这个Executor
        // 当前线程将继续运行在shutdown()被调用之前提交的所有任务
        exec.shutdown();

    }
    // Executor是启动任务的优选方法
    // 常见情况是，单个的Executor被用来创建和管理系统中的所有任务
    // ExecutorService对象是使用静态的Executor方法创建的，这个方法确定其Executor类型
    // 可以很容易的将CachedThreadPool替换为不同类型的Executor，如：FixedThreadPool
}

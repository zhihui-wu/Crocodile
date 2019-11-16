package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 使用有限的线程来执行所提交的任务
 * @Author: 吴智慧
 * @Date: 2019/11/16 15:48
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        // 一次性预先执行代价高昂的线程分配，需要线程时，直接从池中获取线程，节省时间，尽快提供服务
        // 限制线程的数量，防止滥用可获得的资源
        // 在任何线程池中，现有线程在可能的情况下，都会被自动复用
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}

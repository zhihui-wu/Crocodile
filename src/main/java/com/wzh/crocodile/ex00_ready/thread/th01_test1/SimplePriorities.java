package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 线程优先级
 * @Author: 吴智慧
 * @Date: 2019/11/16 17:53
 */
public class SimplePriorities implements Runnable{

    private int countDown = 5;

    private volatile double d;

    private int priority;

    public SimplePriorities(int priority){
        this.priority = priority;
    }

    public String toString(){
        // Thread.currentThread()方法，返回线程名称、线程优先级一级线程所属的“线程组”
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        // 设置当前线程优先级
        // 在run()的开头部分设定的，在构造器中设置不会有任何好处
        // 因为Executor在创建对象时还没有开始执行任务
        Thread.currentThread().setPriority(priority);
        while (true){
            for (int i = 1; i < 100000; i++){
                d += (Math.PI + Math.E) / (double) i;
                if (i % 1000 == 0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            // 每种系统的优先级设置不同，无法映射
            // 唯一可移植的方法是调整优先级的时候，只使用MAX_PRIORITY \ NORM_PRIORITY \ MIN_PRIORITY三种级别
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}

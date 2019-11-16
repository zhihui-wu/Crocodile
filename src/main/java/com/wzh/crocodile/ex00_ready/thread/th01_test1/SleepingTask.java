package com.wzh.crocodile.ex00_ready.thread.th01_test1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 线程休眠
 * 调用sleep()，将使任务中止执行给定的时间
 * @Author: 吴智慧
 * @Date: 2019/11/16 17:08
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        // 异常在run()中被捕获，因为异常不能跨线程传播回main()
        // 必须在本地处理所有在任务内部产生的异常
        try {
            while (countDown-- > 0){
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}

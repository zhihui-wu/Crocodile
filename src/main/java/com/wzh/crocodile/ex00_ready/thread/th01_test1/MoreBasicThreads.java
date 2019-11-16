package com.wzh.crocodile.ex00_ready.thread.th01_test1;

/**
 * @Description: 多线程运行火箭发射倒计时
 * @Author: 吴智慧
 * @Date: 2019/11/16 14:57
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            // 输出说明不同任务的执行在线程被换进换出时混在一起
            // 这种交换是由线程调度器自动控制的
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
        // 当main()创建Thread对象时，它并没有捕获任何对这些对象的引用。
        // 在使用普通对象时,这对于垃圾回收来说是一场公平的游戏，但是在使用Thread时，情况就不同了。
        // 每个Thread都“注册”了它自己，因此确实有一-个对它的引用，而且在它的任务退出其run()并死亡之前，垃圾回收器无法清除它。
        // 可以从输出中看到，这些任务确实运行到了结束，因此,一个线程会创建一个单独的执行线程，在对start()的调用完成之后， 它仍旧会继续存在。
    }
}

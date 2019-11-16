package com.wzh.crocodile.ex00_ready.thread.th01_test1;

/**
 * @Description: 用线程驱动发射倒计时
 * @Author: 吴智慧
 * @Date: 2019/11/16 14:45
 */
public class BasicThreads {
    public static void main(String[] args) {
        // 将Runnable对象转变为工作任务地传统方式是把它提交给一个Thread构造器
        // 使用Tread来驱动LiftOff对象
        Thread t = new Thread(new LiftOff());
        // start()方法为新线程执行必须地初始化操作，然后调用Runnable的run()方法
        t.start();
        // 可以看到输出结果
        // “Waiting for LiftOff”在倒计时完成之前就出现了
        // 实际上，LiftOff.run()是由新线程执行的，本线程会继续往下运行输出结果，并不是顺序的
        System.out.println("Waiting for LiftOff");
    }
}

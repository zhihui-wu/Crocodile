package com.wzh.crocodile.ex00_ready.thread.th01_test1;

/**
 * @Description: 火箭发射倒计时
 * @Author: 吴智慧
 * @Date: 2019/11/16 14:19
 */
public class LiftOff implements Runnable {

    /**
     * 从10开始倒数
     */
    protected int countDown = 10;

    private static int taskCount = 0;

    /**
     * 用于区分任务的多个实例
     */
    private final int id = taskCount++;

    public LiftOff(){

    }

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    @Override
    public void run() {
        // 任务的run()方法通常会用某种形式的循环，使得任务一直运行下去，直到达成循环终止条件
        // 需学习如何安全地终止线程
        while (countDown-- > 0){
            System.out.println(status());
            // 这是对线程调度器的一种建议，不是该线程一定会被挂起
            // 声明：该线程已经执行完生命周期中最重要的部分了，此刻是切换给其他任务执行一段时间的大好时机
            // 这样更有可能看到任务的换进换出
            Thread.yield();
        }
    }

    protected String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + ").";
    }
}

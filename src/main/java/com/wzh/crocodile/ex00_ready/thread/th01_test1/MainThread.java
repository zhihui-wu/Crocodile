package com.wzh.crocodile.ex00_ready.thread.th01_test1;

/**
 * @Description: 直接调用火箭发射倒计时（非多线程）
 * @Author: 吴智慧
 * @Date: 2019/11/16 14:39
 */
public class MainThread {

    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        // 当从Runnable导出一个类时，必须实现run()方法，但是这个方法并无特殊之处（不会产生任何内在地线程能力）
        // 要实现线程行为，必须显示地将一个任务附着于线程上
        // 此错火箭倒计时，不创建新线程
        launch.run();
    }
}

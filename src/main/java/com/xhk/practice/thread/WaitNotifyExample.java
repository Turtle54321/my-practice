package com.xhk.practice.thread;

/**
 * @author xuhaikun
 * @date 2019-08-25
 */
public class WaitNotifyExample {
    public synchronized void before() {
        System.out.println("before");
        System.exit(0);
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }
}

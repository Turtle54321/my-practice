package com.xhk.practice.thread;

/**
 * @author xuhaikun
 * @date 2019-09-03
 */
public class VolatileTest implements Runnable {
    public static String name = "dog";

    @Override
    public void run() {
        while (true) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        Thread thread = new Thread(volatileTest);
        thread.start();
        // 让主线程睡一段时间，保证子线程的开启。
        Thread.sleep(5000);
        VolatileTest.name = "wangcai";
    }
}

package com.xhk.practice.thread;

/**
 * @author xuhaikun
 */
public class Main {
    public static void main(String[] args){
        Thread thread = new Thread(new MyRunnable());
        Thread thread1 = new Thread(new MyRunnable(2));
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();
        thread.interrupt();
        System.out.println(Thread.currentThread().toString());
    }
}

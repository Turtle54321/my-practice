package com.xhk.practice.thread;

/**
 * @author xuhaikun
 */
public class MyRunnable implements Runnable{
    private Integer num = 1;

    MyRunnable(){}
    MyRunnable(Integer num){
        this.num = num;
    }
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+"线程"+Thread.currentThread().getId()+"值"+this.num++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

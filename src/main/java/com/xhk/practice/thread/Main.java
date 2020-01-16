package com.xhk.practice.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xuhaikun
 */
public class Main {
    public static void main(String[] args){

        ClassLoader cl = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };
        //Thread thread = new Thread(new MyRunnable());
        //Thread thread1 = new Thread(new MyRunnable(2));
        //thread.start();
        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //thread1.start();
        //thread.interrupt();
        //System.out.println(Thread.currentThread().toString());

        //JoinExample example = new JoinExample();
        //example.test();

        //ExecutorService executorService = Executors.newCachedThreadPool();
        //WaitNotifyExample example = new WaitNotifyExample();
        //executorService.execute(() -> example.after());
        //executorService.execute(() -> example.before());
        //
        //CyclicBarrier cyclicBarrier = new CyclicBarrier();
        //cyclicBarrier.await();
        //cyclicBarrier.reset();
    }
}

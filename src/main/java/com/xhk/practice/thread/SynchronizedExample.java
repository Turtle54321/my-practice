package com.xhk.practice.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuhaikun
 * @date 2019-08-23
 */
public class SynchronizedExample {

    private Lock lock = new ReentrantLock();

    public void test(){
        lock.lock();
        for (int i = 0; i< 10; i++){
            System.out.println(i);
        }
        lock.unlock();
    }
}

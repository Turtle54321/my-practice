package com.xhk.practice.thread;

import java.util.concurrent.*;

/**
 * @author xuhaikun
 * @date 2019-09-11
 */
public class FutureTaskExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            System.out.println("进入线程");
            Thread.sleep(3000);
            return "success";
        };
        System.out.println("开始线程");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future future = executor.submit(callable);
        System.out.println(future.get());

    }
}

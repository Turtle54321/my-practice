package com.xhk.practice.thread;

/**
 * @author xuhaikun
 * @date 2019-08-25
 */
public class JoinExample {
    private class A extends Thread {
        @Override
        public void run() {
            System.out.println("into A");
            System.out.println("A");
        }
    }

    private class B extends Thread {

        private A a;

        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            System.out.println("into B");
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test() {
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }
}

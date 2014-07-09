/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.core.thread;

/**
 * 类SynchronizedTest.java的实现描述：TODO 类实现描述
 * 
 * @author yuci.wyc 2014年7月9日 下午4:26:08
 */
public class SynchronizedTest {

    class Inner {

        private void run3() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + "Loop:" + i);
            }
            try {
                Thread.sleep(5500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void run4() {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + "Loop:" + i);
            }
            try {
                Thread.sleep(5500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void run3(Inner inner) {
        // synchronized (inner) {
        inner.run3();
        // }
    }

    private void run4(Inner inner) {
        inner.run4();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Thread1 t1 = new Thread1();
        final SynchronizedTest t1 = new SynchronizedTest();

        final Inner inner = t1.new Inner();

        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                t1.run3(inner);
            }
        }, "run3");
        ;

        Thread t4 = new Thread(new Runnable() {

            @Override
            public void run() {
                t1.run4(inner);
            }
        }, "run4");
        t3.start();
        t4.start();

        // Thread taThread = new Thread(new Runnable() {
        //
        // @Override
        // public void run() {
        // t1.run1();
        // }
        // }, "A");
        // Thread tbThread = new Thread(new Runnable() {
        //
        // @Override
        // public void run() {
        // t1.run2();
        //
        // }
        // }, "B");
        // taThread.start();
        // tbThread.start();

    }

    public void run1() {
        // synchronized (this) {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // }
    }

    public synchronized void run2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread1 implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " loop " + i);
            }

        }

    }

}

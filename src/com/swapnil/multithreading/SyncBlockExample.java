package com.swapnil.multithreading;

import java.util.Objects;

/**
 * Created by swapn on 2/6/2017.
 * Synchronized block example
 */
public class SyncBlockExample {
    private static int count1 = 0;
    private static int count2 = 0;

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static synchronized void add() {
        synchronized (lock1) {
            count1++;
        }
    }

    public static synchronized void addAgain() {
        synchronized (lock2) {
            count2++;
        }
    }

    public static void compute() {
        for(int i = 0; i< 100; i++) {
            add();
            addAgain();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                compute();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                compute();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished with count1 : " + count1 + " and count2 : " + count2);
    }
}

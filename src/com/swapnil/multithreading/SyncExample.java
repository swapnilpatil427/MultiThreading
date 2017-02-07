package com.swapnil.multithreading;

/**
 * Created by swapn on 2/6/2017.
 */
public class SyncExample {
    public static int counter = 0;

    // Synchronised keyword make threads to be synchronised.
    // THey wait for each other to complete the operations
    public static synchronized void increment() {
        ++counter;
    }
    public static void process() {
        Thread t1 = new Thread(() -> {
            for(int i=0;i<100;i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<100;i++) {
                increment();
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
    }
    public static void main(String[] args) {
        process();
        System.out.println("Counter : " + counter);
    }
}

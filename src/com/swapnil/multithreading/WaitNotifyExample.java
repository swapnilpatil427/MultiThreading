package com.swapnil.multithreading;

/**
 * Created by swapn on 2/6/2017.
 */

class Processor {
    public void produce() throws InterruptedException {
        // Intrinsic lock
        synchronized (this) {
            System.out.println("We are in the prducer method");
            wait();
            System.out.println("Again Producer method");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);

        synchronized (this) {
            System.out.println("Consumer Method");
            notify();
            // Notify method is not going to stop the execution of further statements
            Thread.sleep(3000);
        }
    }
}
public class WaitNotifyExample {
    public static void main(String[] args) {
        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
}

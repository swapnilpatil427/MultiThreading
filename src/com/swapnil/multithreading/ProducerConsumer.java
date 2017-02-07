package com.swapnil.multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swapn on 2/6/2017.
 */
class Producer_Consumer {
    private List<Integer> list = new ArrayList<Integer>();
    private final int LIMIT = 5;
    private final int BOTTOM = 0;
    private final Object lock = new Object();
    private int value = 0;
    public void produce() throws InterruptedException {
        // Intrinsic lock
        synchronized (lock) {
            while(true) {
                if(list.size() == LIMIT) {
                    System.out.println("Waiting for removing items from the list");
                    lock.wait();
                } else {
                    System.out.println("Adding : " +value);
                    list.add(value);
                    value++;
                    lock.notify();
                    /*
                        Why other method don't get called on calling notify here.
                        As we know notify method waits for other instruction to get finished,
                        we are in while loop so it will keep iterating until it meets the if condition where
                        Wait() will be the last instruction for that thread and after that notify will execute.
                     */
                }

                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);

        synchronized (lock) {
            while(true) {
                if(list.size() == BOTTOM) {
                    System.out.println("Waiting for adding items to the list");
                    lock.wait();
                } else {
                    System.out.println("Removed : " +list.remove(list.size() - 1));
                    lock.notify();
                }

                Thread.sleep(1000);
            }
        }
    }
}
public class ProducerConsumer {
    public static void main(String[] args) {
        Producer_Consumer processor = new Producer_Consumer();

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

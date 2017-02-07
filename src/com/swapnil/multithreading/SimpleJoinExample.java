package com.swapnil.multithreading;

import com.swapnil.multithreading.Runnables.Parallel_Runner1;
import com.swapnil.multithreading.Runnables.Parallel_Runner2;

/**
 * Created by swapn on 2/6/2017.
 * Join Operation Execution Demo
 * Join waits for thread to finish before continuing to next instruction.
 */

public class SimpleJoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Parallel_Runner1());
        Thread t2 = new Thread(new Parallel_Runner2());

        // Runs the methods Parallel.
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Threads have finished....");
    }
}

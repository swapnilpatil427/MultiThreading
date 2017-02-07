package com.swapnil.multithreading;

import com.swapnil.multithreading.Runnables.Parallel_Runner1;
import com.swapnil.multithreading.Runnables.Parallel_Runner2;

/**
 * Created by swapn on 2/6/2017.
 * Paraller Execution Demo
 */

public class SimpleParallelExecution {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Parallel_Runner1());
        Thread t2 = new Thread(new Parallel_Runner2());

        // Runs the methods Parallel.
        t1.start();
        t2.start();
    }
}

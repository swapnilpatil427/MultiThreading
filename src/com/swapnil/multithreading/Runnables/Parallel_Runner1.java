package com.swapnil.multithreading.Runnables;

/**
 * Created by swapn on 2/6/2017.
 */
public class Parallel_Runner1 implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<10;++i) {
            System.out.println("Parallel Runner 1 : " + i);
        }
    }
}

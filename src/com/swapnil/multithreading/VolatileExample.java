package com.swapnil.multithreading;

import com.swapnil.multithreading.Runnables.Worker;

/**
 * Created by swapn on 2/6/2017.
 */
public class VolatileExample {
    public static void main (String[] args) {
        Worker w = new Worker();
        Thread t1 = new Thread(w);
        t1.start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.setTerminated(true);
        System.out.println("Finished");
    }
}

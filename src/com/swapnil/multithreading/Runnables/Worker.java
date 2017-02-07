package com.swapnil.multithreading.Runnables;

/**
 * Created by swapn on 2/6/2017.
 */
public class Worker implements Runnable {
    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }

    private volatile boolean isTerminated = false;
    @Override
    public void run() {
        while(!isTerminated) {
            System.out.println("Hello from Worker Class");

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

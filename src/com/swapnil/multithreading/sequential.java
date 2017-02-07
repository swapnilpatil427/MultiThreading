package com.swapnil.multithreading;

/**
 * Created by swapn on 2/6/2017.
 * Sequential Execution Demo
 */
class Runner1 {
     public void startRunning() {
         for(int i=0;i<10;++i) {
             System.out.println("Runner 1 : " + i);
         }
     }
}

class Runner2 {
    public void startRunning() {
        for(int i=0;i<10;++i) {
            System.out.println("Runner 2 : " + i);
        }
    }
}

public class sequential {
    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();

        // Runs the methods sequentially.
        runner1.startRunning();
        runner2.startRunning();
    }
}

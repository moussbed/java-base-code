package org.mb.base.threads.managing.concurrent.processes.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManagerWithCyclicBarrier {

    private void removeAnimals() { System.out.println("Removing animals"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addAnimals() { System.out.println("Adding animals"); }

    public void  performtask(CyclicBarrier c1, CyclicBarrier c2){
        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ExecutorService service =null;

        try {
            service = Executors.newFixedThreadPool(4);
            LionPenManagerWithCyclicBarrier lionPenManager = new LionPenManagerWithCyclicBarrier();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println(" *** Pen  cleaned!"));

            for (int i = 0; i < 4; i++) {
                service.submit(()-> {
                    lionPenManager.performtask(c1, c2);
                });
            }
        }finally {
            if (service != null) {
                service.shutdown();
            }
        }

        // The following is sample output based on this revised implementation of our LionPenManager class:

        /*

        Removing animals
        Removing animals
        Removing animals
        Removing animals
        Cleaning the pen
        Cleaning the pen
        Cleaning the pen
        Cleaning the pen
        *** Pen Cleaned!
        Adding animals
        Adding animals
        Adding animals
        Adding animals
         */

    }
}

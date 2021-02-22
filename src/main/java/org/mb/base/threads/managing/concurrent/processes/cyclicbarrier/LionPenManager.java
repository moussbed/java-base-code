package org.mb.base.threads.managing.concurrent.processes.cyclicbarrier;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {

    private void removeAnimals() { System.out.println("Removing animals"); }
    private void cleanPen() { System.out.println("Cleaning the pen"); }
    private void addAnimals() { System.out.println("Adding animals"); }
    public void performTask() {
        removeAnimals();
        cleanPen();
        addAnimals();
    }
    public static void main(String[] args) {

        ExecutorService executorService=null;

        try {

            executorService = Executors.newFixedThreadPool(4);
            LionPenManager lionPenManager = new LionPenManager();
            for (int i = 0; i < 4; i++) {
                executorService.submit(lionPenManager::performTask);
            }

        }finally {
            if(executorService != null) executorService.shutdown();
        }

        //  The following is sample output based on this implementation:

        /*
         Removing animals
         Removing animals
         Cleaning the pen
         Adding animals
         Removing animals
         Cleaning the pen
         Adding animals
         Removing animals
         Cleaning the pen
         Adding animals
         Cleaning the pen
         Adding animals

         */

    }
}
